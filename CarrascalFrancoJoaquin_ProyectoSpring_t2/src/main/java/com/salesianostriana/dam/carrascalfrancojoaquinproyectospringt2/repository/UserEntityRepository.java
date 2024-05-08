package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity , Long>{

	Optional<UserEntity> findFirstByUsername(String username);
	
}
