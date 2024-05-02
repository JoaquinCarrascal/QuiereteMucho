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
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_appointment_client_user"))
	private ClientUser client;
	
	private double fullPrice;
	private boolean paid;
	private Date appointmentDate;
	
	
}
