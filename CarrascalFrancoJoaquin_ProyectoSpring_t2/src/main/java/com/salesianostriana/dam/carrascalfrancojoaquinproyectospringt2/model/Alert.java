package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
	@GeneratedValue
	private Long id;
	
	@SuppressWarnings("unused")
	private String description , name;
	
	public Alert(String description , String name) {
		this.description = description;
		this.name = name;
	}
	
}
