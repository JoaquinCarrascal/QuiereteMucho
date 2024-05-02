package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reportId;
	
	private String title;
	private String description;
	private Date reportDate;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_report_client_user"))
	private ClientUser client;

	public Report(String title, String description, Date reportDate, ClientUser client) {
		super();
		this.title = title;
		this.description = description;
		this.reportDate = reportDate;
		this.client = client;
	}
	
}
