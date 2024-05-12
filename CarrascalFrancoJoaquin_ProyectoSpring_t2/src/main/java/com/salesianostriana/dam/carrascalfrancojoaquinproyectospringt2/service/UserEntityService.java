package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.UserEntityRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class UserEntityService extends BaseServiceImpl<UserEntity, Long , UserEntityRepository>{

	@Autowired
	private UserEntityRepository userrepo;
	
	public UserEntity findByAuthName(String name) {
		
		return userrepo.findFirstByUsername(name).get();
		
	}
	
	//este método devuelve true si encuentra el usuario en la lista
	public boolean checkUsernameAvailability(String requestedUsername) {

		return userrepo
				.findAll()
				.stream()
				.anyMatch(x -> x.getUsername().equalsIgnoreCase(requestedUsername));
		
	}
	
	@Transactional
	public void changeSelfPass(Long id , String newPass) {
		
		userrepo.changeSelfPass(id, newPass);
		
	}
	
	public void securityContextHolderUpdate(UserEntity ue) {
	
		Authentication auth = new UsernamePasswordAuthenticationToken(ue, null, ue.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	
	}
	
	
}
