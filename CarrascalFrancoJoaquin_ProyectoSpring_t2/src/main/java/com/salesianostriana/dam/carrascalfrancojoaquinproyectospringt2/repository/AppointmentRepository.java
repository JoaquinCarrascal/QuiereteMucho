package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Appointment;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;

public interface AppointmentRepository extends JpaRepository<Appointment , Long>{

	@Query(value = "SELECT * FROM Appointment WHERE client_id = :id" , nativeQuery = true)
	List<Appointment> findAppointmentByClientId(@Param("id") Long id);
	
	@Query("SELECT a FROM Appointment a WHERE a.client = :client AND paid = false")
	Optional<Appointment> checkActiveAppointmentByUserId(@Param("client") UserEntity client);
	
}
