package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name="adminuser")
public class AdminUser extends User{

	private String adminDni;

	public AdminUser(Long id, String userName, String userLastName, String email, String telNumber, String pass,
			String adminDni) {
		super(id, userName, userLastName, email, telNumber, pass);
		this.adminDni = adminDni;
	}
	
}
