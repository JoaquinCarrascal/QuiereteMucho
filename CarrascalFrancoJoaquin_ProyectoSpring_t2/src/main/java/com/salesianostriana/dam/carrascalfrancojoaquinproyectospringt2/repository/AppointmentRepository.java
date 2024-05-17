package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Appointment;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.AppointmentLine;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;

public interface AppointmentRepository extends JpaRepository<Appointment , Long>{

	@Query(value = "SELECT * FROM Appointment WHERE client_id = :id" , nativeQuery = true)
	List<Appointment> findAppointmentByClientId(@Param("id") Long id);
	
	@Query("SELECT a FROM Appointment a WHERE a.client = :client AND paid = false")
	Optional<Appointment> checkActiveAppointmentByUserId(@Param("client") UserEntity client);
	
	/*@Modifying
	@Query("DELETE FROM AppointmentLine al WHERE al.id = :id")
	void hardDeleteAppointmentLine(@Param("id") Long id);
	
	@Query("SELECT CASE WHEN EXISTS (SELECT al FROM AppointmentLine al WHERE al.appointment.id = :id AND al.id = :idApL) THEN true ELSE false END")
	boolean isThisApLineOnTheAppoint(@Param("id")Long idAppoint , @Param("idApL")Long idApLine); */
	
	@Query("SELECT al FROM AppointmentLine al WHERE al.id = :idApLine AND al.appointment.id = :idAppoint")
	Optional<AppointmentLine> findApLineById(@Param("idAppoint")Long idAppoint , @Param("idApLine")Long idApLine);
	
	@Query("SELECT a FROM Appointment a WHERE a.appointmentDate >= :todaysDate ORDER BY a.appointmentDate ASC LIMIT :limit")
	List<Appointment> closeDateAppointList(@Param("todaysDate") LocalDate date , @Param("limit") int limit);
	
	@Query("SELECT al FROM AppointmentLine al WHERE al.appointment.id = :appointId")
	List<AppointmentLine> findAllApLineByAppointId(@Param("appointId") Long id);
	
	@Query("SELECT SUM(a.fullPrice) FROM Appointment a WHERE a.appointmentDate >= :todaysDate")
	Double estimatedEarningsFromDay(@Param("todaysDate") LocalDate date);
	
	@Query("SELECT SUM(al.subTotal) FROM Appointment a JOIN AppointmentLine al ON a.id = al.appointment.id WHERE al.product.productType = 'PELUQUERIA' AND a.appointmentDate < :todaysDate")
	Double earningsPerHairdressing(@Param("todaysDate") LocalDate date);
	
	@Query("SELECT SUM(al.subTotal) FROM Appointment a JOIN AppointmentLine al ON a.id = al.appointment.id WHERE al.product.productType = 'ESTETICA' AND a.appointmentDate < :todaysDate")
	Double earningsPerAesthetics(@Param("todaysDate") LocalDate date);
	
	@Query("SELECT SUM(a.fullPrice) FROM Appointment a WHERE YEAR(a.appointmentDate) = YEAR(:todaysDate)")
	Double estimatedEarningsFromCurrentYear(@Param("todaysDate") LocalDate date);
	
}
