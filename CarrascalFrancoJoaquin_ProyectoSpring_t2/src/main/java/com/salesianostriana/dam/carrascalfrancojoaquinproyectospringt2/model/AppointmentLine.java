package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder @IdClass(AppointmentLinePK.class)
@NoArgsConstructor @AllArgsConstructor
@Table(name="appointmentline")
public class AppointmentLine {

	@Id
	@GeneratedValue
	private Long id;
	
	@Id
	@ManyToOne
	private Appointment appointment;
	
	private int quantity;
	private double subTotal;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_appointment_line_product"))
	private Product product;
	
	
}
