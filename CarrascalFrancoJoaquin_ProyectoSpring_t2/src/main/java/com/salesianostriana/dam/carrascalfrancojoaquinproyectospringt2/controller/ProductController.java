package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@Autowired
	private AlertService as1;
	
	@GetMapping("/prodForm")
	public String showFormProducto(Model model) {
		
		model.addAttribute("productRegForm", new Product());
		model.addAttribute("pTypes" , pservice.getTypes());
		model.addAttribute("alertContext" , as1.showAlert());

		return "productReg";
	}
	
	@PostMapping("/addProduct")
	public String submitProd(@ModelAttribute("productRegForm") Product p1) {
		
		pservice.save(p1);
		
		return "redirect:/prodForm";
		
	}
	
	
	
	
	
	
}
