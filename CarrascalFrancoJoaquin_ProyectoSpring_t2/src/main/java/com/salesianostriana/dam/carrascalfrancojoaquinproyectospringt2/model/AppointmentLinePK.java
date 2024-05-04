package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class AppointmentLinePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long appointmentLine_id;
	
	private Long appointment_id;
	
}
