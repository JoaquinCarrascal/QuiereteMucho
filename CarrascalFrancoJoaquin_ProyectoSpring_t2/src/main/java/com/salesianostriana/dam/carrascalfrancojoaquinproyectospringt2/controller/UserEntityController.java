package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/clientList")
	public String showClientList(Model model) {
		
		model.addAttribute("clientList" , ueservice.findAll());
		
		return "clientListui";
	}
	
	@GetMapping("/logform")
	public String showLogForm(Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "login";
	}
	
	@GetMapping("/regform")
	public String showRegForm(Model model) {
		
		UserEntity ue = new UserEntity();
		model.addAttribute("clientRegForm" , ue);
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("legend" , "Formulario de creación de cuenta");
		
		return "register";
	}
	
	@PostMapping("/addClient/submit")
	public String submit(@ModelAttribute("clientRegForm") UserEntity ue) {
		
		ueservice.save(ue);
		
		return "redirect:/home";
		
	}
	
	@GetMapping("/editClient/{id}")
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
	
}
