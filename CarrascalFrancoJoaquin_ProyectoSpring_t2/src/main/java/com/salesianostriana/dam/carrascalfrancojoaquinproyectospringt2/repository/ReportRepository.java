package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Report;

public interface ReportRepository extends JpaRepository<Report , Long>{

	@Query("SELECT r FROM Report r WHERE r.reply IS NULL OR r.reply IN ('' , ' ')")
	List<Report> findNonRepliedReportList();
	
	@Query(value = "SELECT * FROM Report WHERE client_id = :id" , nativeQuery = true)
	List <Report> findReportsByUserId(@Param("id") Long id);
	
}
