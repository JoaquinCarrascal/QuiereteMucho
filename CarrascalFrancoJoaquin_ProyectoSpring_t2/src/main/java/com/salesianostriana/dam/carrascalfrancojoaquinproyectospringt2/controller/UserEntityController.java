package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@GetMapping("/admin/clientList")
	public String showClientList(Model model) {
		
		model.addAttribute("clientList" , ueservice.findAll());
		
		return "adminTemplates/clientListui";
	}
	
	@GetMapping("/regform")
	public String showRegForm(Model model) {
		
		model.addAttribute("clientRegForm" , new UserEntity());
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("legend" , "Formulario de creación de cuenta");
		
		return "register";
	}
	
	@PostMapping("/addClient/submit")//todo no permitir username duplicado
	public String submit(@ModelAttribute("clientRegForm") UserEntity ue , Model model) /* throws UnavailableUserNameException */{
		
			if(!ueservice.checkUsernameAvailability(ue.getUsername())) {
		
				ue.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(ue.getPassword()));
		
				ueservice.save(ue);
		
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
	
	@GetMapping("/editClient/{id}")//TODO edit client
	public String showEditForm(Model model , @PathVariable("id") Long id) {
		
		model.addAttribute("legend" , "Formulario de edición");
		model.addAttribute("clientRegForm" , ueservice.findById(id).get());
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "register";
	}
	
	@PostMapping("/editClient/submit")
	public String submitEditedForm(@ModelAttribute("clientRegForm") UserEntity ue) {
		
		ueservice.save(ue);
		
		return "redirect:/clientList";
	}
	
	@GetMapping("/admin/deleteClient/{id}")
	public String deleteClient(@PathVariable("id") Long id) {
		
		ueservice.deleteById(id);
		
		return "redirect:/admin/clientList";
	}
	
}
