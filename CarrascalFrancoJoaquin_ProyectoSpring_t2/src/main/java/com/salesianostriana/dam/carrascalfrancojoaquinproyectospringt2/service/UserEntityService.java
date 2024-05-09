package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
