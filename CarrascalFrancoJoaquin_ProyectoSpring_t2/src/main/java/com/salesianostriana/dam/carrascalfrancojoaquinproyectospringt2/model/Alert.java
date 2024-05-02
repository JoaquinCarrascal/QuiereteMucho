package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

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
@Table(name = "alert")
public class Alert {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@SuppressWarnings("unused")
	private String name,description;
	
	public Alert(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
}
