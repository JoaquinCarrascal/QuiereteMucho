package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@Autowired
	private AlertService aserv;
	
	@GetMapping("/prodForm")
	public String showFormProducto(Model model) {
		
		model.addAttribute("productRegForm", new Product());
		model.addAttribute("pTypes" , pservice.getTypes());
		model.addAttribute("alertContext" , aserv.showAlert());

		return "productReg";
	}
	
	@GetMapping("/prodList")
	public String showProductList(Model model) {
		
		model.addAttribute("productList" , pservice.findAll());
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "productListui";
		
	}
	
	@PostMapping("/addProduct/submit")
	public String submitProd(@ModelAttribute("productRegForm") Product p1) {
		
		pservice.save(p1);
		
		return "redirect:/prodForm";
		
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		
		pservice.delete(pservice.findById(id).get());
		
		return "redirect:/prodList";
	}
	
	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("productRegForm" , pservice.findById(id).get());
		
		return "productReg";
		
	}
	
	@PostMapping("/editProduct/submit")
	public String submitEditedAlert(@ModelAttribute("alertBlank")Product p) {
		
		pservice.save(p);
		
		return "redirect:/prodList";
		
	}
	
}
