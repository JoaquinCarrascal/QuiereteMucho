package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity , Long>{
	
	Optional<UserEntity> findFirstByUsername(String username);
	
	@Modifying
	@Query("UPDATE UserEntity u SET u.password = :newPass WHERE u.id = :id")
	void changeSelfPass(@Param("id") Long id , @Param("newPass") String newPass);
	
}
