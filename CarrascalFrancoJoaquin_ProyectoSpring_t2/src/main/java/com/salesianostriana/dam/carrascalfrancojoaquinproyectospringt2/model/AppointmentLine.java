package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name="appointmentline")
public class AppointmentLine {

	@EmbeddedId
	@Builder.Default
	private AppointmentLinePK appointmentlineprimarykey = new AppointmentLinePK();
	
	private int quantity;
	private double subTotal;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_appointment_line_product"))
	private Product product;
	
	@ManyToOne
	@MapsId("appointment_id")
	@JoinColumn(name = "appointment_id")
	private Appointment appointment;
	
	
}
