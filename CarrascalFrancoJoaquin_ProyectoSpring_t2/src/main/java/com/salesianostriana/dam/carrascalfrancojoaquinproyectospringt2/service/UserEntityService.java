package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.UserEntityRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class UserEntityService extends BaseServiceImpl<UserEntity, Long , UserEntityRepository>{

	@Autowired
	private UserEntityRepository userrepo;
	
	@Autowired
	private ReportService repserv;
	
	public UserEntity findByAuthName(String name) {
		
		return userrepo.findFirstByUsername(name).get();
		
	}
	
	public List<UserEntity> findAllExceptCurrentUser(Long id){
		
		return userrepo.findAllExceptCurrentUser(id);
		
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
	
	@Transactional
	public void processEditingSelfPass(UserEntity loggedUser , UserEntity formUser) {

		String newPass = "{bcrypt}" + new BCryptPasswordEncoder().encode(formUser.getPassword());
		
		changeSelfPass(loggedUser.getId(), newPass);
		
	}
	
	//Comprueba que al editar tu propio usuario no uses de nombre de usuario uno existente
	//a no ser que sea el tuyo propio.
	public boolean processEditingSelfForm(UserEntity userForm , UserEntity loggedUser) {
		
		if(!checkUsernameAvailability(userForm.getUsername())) { //que no esté registrado aún
			
			save(userForm);
			
			refreshSecurityContext(userForm);
			
			return true;
			
		}else if(userForm.getUsername().equals(loggedUser.getUsername())) { //que sea su anterior nombre
			
			save(userForm);
			
			refreshSecurityContext(userForm);
			
			return true;
			
		}
		
		return false;
		
	}
	
	public boolean processAddingNewClient(UserEntity userForm) {
		
		//Si NO lo encuentra le setea su contraseña cifrada y lo guarda en bbdd
		//además devuelve true para hacer la comprobacion en el formulario
		if(!checkUsernameAvailability(userForm.getUsername())) {
			
			userForm.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userForm.getPassword()));
	
			save(userForm);
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public boolean processClientDeletingByAdmin(Long id) {
		
		if(repserv.findReportsByUserId(id).isEmpty()) {
			
			deleteById(id);
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	private void refreshSecurityContext(UserEntity ue) {
	
		Authentication auth = new UsernamePasswordAuthenticationToken(ue, null, ue.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	
	}
	
	
}
