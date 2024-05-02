package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;


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
@Table(name="appointmentline")
public class AppointmentLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointmentLineId;
	private int quantity;
	private double subTotal;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_appointment_line_product"))
	private Product product;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_appointment_line_appointment"))
	private Appointment appointment;
	
	public AppointmentLine(Product p, int quantity , double subTotal) {
		this.product = p;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	
	
	
}
