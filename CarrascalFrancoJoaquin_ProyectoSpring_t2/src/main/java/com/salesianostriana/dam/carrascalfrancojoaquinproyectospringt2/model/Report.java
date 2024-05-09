package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="report")
public class Report {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title , description , reply;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reportDate;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_report_client_user"))
	private UserEntity client;

	public Report(String title, String description, LocalDate reportDate, UserEntity client) {
		
		this.title = title;
		this.description = description;
		this.reportDate = reportDate;
		this.client = client;
		
	}
	
}
