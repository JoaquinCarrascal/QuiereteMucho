package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reportId;
	
	private String title;
	private String description;
	private Date reportDate;
	private Long clientId;
	
	public Report(String title, String description, Date reportDate, Long clientId) {
		this.title = title;
		this.description = description;
		this.reportDate = reportDate;
		this.clientId = clientId;
	}
	
}
