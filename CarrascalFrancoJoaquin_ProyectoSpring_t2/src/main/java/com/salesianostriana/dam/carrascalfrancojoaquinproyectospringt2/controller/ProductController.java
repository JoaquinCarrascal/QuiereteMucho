package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps1;
	
	@GetMapping({"/","/home"})
	public String showHome(Model model) {
		
		model.addAttribute("productList" , ps1.findAll());
		
		return "home";
	}
}
