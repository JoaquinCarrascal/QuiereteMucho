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
@Table(name="clientuser")
public class ClientUser extends User{
	
	private int points;

	public ClientUser(Long id, String userName, String userLastName, String email, String telNumber, String pass,
			int points) {
		super(id, userName, userLastName, email, telNumber, pass);
		this.points = points;
	}

	

}
