package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.UserEntityService;

@Controller
public class UserEntityController {

	@Autowired
	private UserEntityService ueservice;
	
	@Autowired
	private AlertService as1;
	
	@GetMapping("/admin/clientList/")
	public String showClientList(Model model , @AuthenticationPrincipal UserEntity loggedUser) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("clientList" , ueservice.findAllExceptCurrentUser(loggedUser.getId()));
		
		return "adminTemplates/clientListui";
	}
	
	@GetMapping("/regform/")
	public String showRegForm(Model model) {
		
		model.addAttribute("clientRegForm" , new UserEntity());
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("legend" , "Formulario de creación de cuenta");
		
		return "register";
	}
	
	//Éste método invoca un método de procesamiento localizado en la clase UserEntityService
	//que comprueba que el usuario deseado no se encuentre ya registrado en la bbdd (en cuyo caso
	//lanza un error que se traduce en una alerta de BS5 en la vista de usuario) y posteriormente
	//si el usuario está disponible, encripta la contraseña , lo guarda en bbdd y devuelve un boolean
	//si dicho boolean es true, redirecciona al usuario a la página principal, si es false
	//lo traduce en una alerta de BS5 encima del formulario de registro
	@PostMapping("/addClient/submit")
	public String submit(@ModelAttribute("clientRegForm") UserEntity userForm , Model model) /* throws UnavailableUserNameException */{
		
			if(ueservice.processAddingNewClient(userForm)) {
		
				return "redirect:/home";
		
			}
			else {
				
				return "redirect:/regform/?error=true";
				
				/*throw new UnavailableUserNameException();*/
				
			}
		
		/*catch(UnavailableUserNameException uune) {
			
			return "redirect:/regform/?error=true";
			
		}*/
		
	}
	
	//ADMIN OPTIONS
	@GetMapping("/editClient/{id}")//TODO edit client
	public String showEditForm(Model model , @PathVariable("id") Long id) {
		
		model.addAttribute("legend" , "Formulario de edición");
		model.addAttribute("clientRegForm" , ueservice.findById(id).get());
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "register";
	}
	
	//TODO edit client
	@PostMapping("/editClient/submit") //ADMIN OPTIONS 
	public String submitEditedForm(@ModelAttribute("clientRegForm") UserEntity ue) {
		
		ueservice.save(ue);
		
		return "redirect:/admin/clientList/";
	}
	
	//Éste método invoca otro método de la clase UserEntityService, que evalúa si el cliente
	//tiene alguna reclamación asociada , si no la tiene lo elimina sin problema, si la tiene
	//lanza un error que se traduce en una alerta de BS5
	@GetMapping("/admin/deleteClient/{id}")
	public String deleteClient(@PathVariable("id") Long id) {
		
		if(ueservice.processClientDeletingByAdmin(id)) {
		
			return "redirect:/admin/clientList/";
			
		}else {
			
			return "redirect:/admin/clientList/?error=true"; 
			
		} 
		
		
	}
	
}
