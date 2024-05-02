package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "alert")
public class Alert {

	@Id //id no será autogenerado ya que sólamente tendré 1 alerta guardada
	private Long id;
	
	@SuppressWarnings("unused")
	private String description;
	
	public Alert(String description) {
		this.description = description;
	}
	
}
