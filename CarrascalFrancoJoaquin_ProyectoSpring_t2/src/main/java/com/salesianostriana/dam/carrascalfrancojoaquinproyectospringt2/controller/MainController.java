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
	private ProductService prodserv;
	
	@Autowired
	private AlertService aserv;
	
	@GetMapping({"/","/home"})
	public String showHome(Model model) {
		
		model.addAttribute("productList" , prodserv.findAll());
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "home";
	}
	
}
