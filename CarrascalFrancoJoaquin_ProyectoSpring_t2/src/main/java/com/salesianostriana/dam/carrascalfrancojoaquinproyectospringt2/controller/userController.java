package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.UserEntityService;

@Controller
@RequestMapping("/userMenu")
public class userController {
	
	@Autowired
	private UserEntityService ueservice;
	
	@Autowired
	private AlertService as1;
	
	@GetMapping({"/",""})
	public String showUserMenu(Model model , @AuthenticationPrincipal UserEntity userentity) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("selfProfileForm" , userentity);
		
		return "clientProfile";
		
	}
	
	@GetMapping("/editSelf")
	public String showEditSelf() {
		
		return "redirect:/userMenu";
		
	}
	
	//Éste método invoca un método de UserEntityService que recibiendo el formulario
	//actualizado y la referencia del usuario logueado, comprueba que el nombre de usuario no esté
	//siendo utilizado (para que éstos no se repitan) , lo guarda y actualiza el SecurityContextHolder
	//con las nuevas credenciales, adicionalmente detecta si está usando su nombre de usuario anterior
	//en cuyo caso también permite sobreescribir los valores
	@PostMapping("/editSelf/submit")
	public String submitEditedSelf(@ModelAttribute("selfProfileForm") UserEntity userForm , @AuthenticationPrincipal UserEntity loggedUser) {
		
		if(ueservice.processEditingSelfForm(userForm , loggedUser)) {
			
			return "redirect:/userMenu";
			
		} else {
			
			return "redirect:/userMenu/?error=true";
			
		} 
		
		
		
	}
	
	@GetMapping("/changePass")
	public String showEditPassSelf(Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("passForm" , new UserEntity());
		
		return "changePass";
		
	}
	
	//Éste método invoca otro método de la clase UserEntityService que codifica una nueva
	//contraseña para el usuario y la concatena con un literal tal que : '{bcrypt}' que avisa
	//sobre el tipo de cifrado de la misma, a continuación por medio de una consulta setea la nueva
	//contraseña para el usuario logueado, una vez realizado dicho procesamiento, el método de controlador
	//presente cierra sesión para asegurar la integridad de la contraseña nueva, como medida de seguridad.
	@PostMapping("/changePass/submit")
	public String editPassSubmit(@AuthenticationPrincipal UserEntity loggedUser , @ModelAttribute("passForm") UserEntity formUser) {
		
		ueservice.processEditingSelfPass(loggedUser, formUser);
				
		return "redirect:/logout";
		
	}
	
}
