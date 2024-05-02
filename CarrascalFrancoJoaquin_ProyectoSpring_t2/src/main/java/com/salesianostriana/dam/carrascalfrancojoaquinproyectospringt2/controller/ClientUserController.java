package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.ClientUser;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ClientUserService;


@Controller
public class ClientUserController {

	@Autowired
	private ClientUserService cuservice;
	
	@Autowired
	private AlertService as1;
	
	@GetMapping("/logform")
	public String showLogForm(Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "login";
	}
	
	@GetMapping("/regform")
	public String showRegForm(Model model) {
		
		ClientUser cu1 = new ClientUser();
		model.addAttribute("clientRegForm" , cu1);
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "register";
	}
	
	@PostMapping("/addClient")
	public String submit(@ModelAttribute("clientRegForm") ClientUser cu1) {
		
		cuservice.save(cu1);
		
		return "redirect:/home";
		
	}
	
}
