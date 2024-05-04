package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_appointment_client_user"))
	private ClientUser client;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="appointment",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<AppointmentLine> appointmentLList = new ArrayList<AppointmentLine>();
	
	private double fullPrice;
	private boolean paid;
	private Date appointmentDate;
	
	// MÉTODOS HELPER
	
		public void addAppointmentLine(AppointmentLine apl) {
			apl.setAppointment(this);
			this.appointmentLList.add(apl);
		}
		
		public void removeAppointmentLine(AppointmentLine apl) {
			this.appointmentLList.remove(apl);
			apl.setAppointment(null);
			
		}
	

}
