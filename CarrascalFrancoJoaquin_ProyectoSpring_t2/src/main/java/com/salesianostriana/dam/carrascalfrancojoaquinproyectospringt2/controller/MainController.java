package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService ps1;
	
	@Autowired
	private AlertService as1;
	
	@GetMapping({"/","/home"})
	public String showHome(Model model) {
		
		model.addAttribute("productList" , ps1.findAll());
		model.addAttribute("alertContext" , as1.showAlert());
		
		return "home";
	}
	
}
