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
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointmentId;
	//private List<AppointmentLine> list; TODO entidad/relacion
	private Date appointmentDate;
	//private Long clientId; revisable
	private double fullPrice;
	private boolean paid;
	
	
	
}
