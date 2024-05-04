package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Alert;

public interface AlertRepository extends JpaRepository<Alert , Long>{

	/*@Query(value = "select * from alert where alert.active = TRUE" , nativeQuery = true)
	List<Alert> findActiveAlert();*/
	
	@Query("SELECT a FROM Alert a WHERE a.active = TRUE")
	List<Alert> findActiveAlert();
	
	@Modifying
	@Query("UPDATE Alert a SET a.active = FALSE WHERE a.id = :id")
	void deactivateAlertQuery(@Param("id") Long id);
	
	@Modifying
	@Query("UPDATE Alert a SET a.active = TRUE WHERE a.id = :id")
	void activateAlertQuery(@Param("id") Long id);
	
	
}
