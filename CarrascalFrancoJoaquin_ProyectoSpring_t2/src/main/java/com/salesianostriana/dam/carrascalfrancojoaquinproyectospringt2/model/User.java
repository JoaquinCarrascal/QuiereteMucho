package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@MappedSuperclass @Data
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@SuppressWarnings("unused")
	private String username , userLastName, email , telNumber , password , address;

	public User(Long id,String userName , String userLastName, String email, String telNumber, String pass) {
		this.id = id;
		this.username = userName;
		this.userLastName = userLastName;
		this.email = email;
		this.telNumber = telNumber;
		this.password = pass;
	}
	
	
	
}
