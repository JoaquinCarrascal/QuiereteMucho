package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;

@Controller
public class LoginController {

	@Autowired
	private AlertService as1;
	
	@GetMapping("/login")
	public String showLogForm(Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "login";
	}
	
}
