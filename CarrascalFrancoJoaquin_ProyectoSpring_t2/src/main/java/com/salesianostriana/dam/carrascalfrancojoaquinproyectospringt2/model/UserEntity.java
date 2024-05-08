package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data @Entity @Table(name="userentity")
@Builder @SuppressWarnings("serial")
public class UserEntity implements UserDetails{

	@Id
	@GeneratedValue
	private Long id;
	
	private int points;
	
	@SuppressWarnings("unused")
	private String username , userLastName, email , telNumber , password , address;
	
	private boolean admin;

	public UserEntity(String username, String userLastName, String email, String telNumber, String password,
			String address) {
		this.username = username;
		this.userLastName = userLastName;
		this.email = email;
		this.telNumber = telNumber;
		this.password = password;
		this.address = address;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
	
}