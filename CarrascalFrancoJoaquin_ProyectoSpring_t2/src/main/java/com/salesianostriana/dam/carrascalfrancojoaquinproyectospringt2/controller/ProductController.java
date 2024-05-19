package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ProductService;

//Controlador para la gestion de los productos por parte del administrador
@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@Autowired
	private AlertService aserv;
	
	@GetMapping("/prodForm")
	public String showFormProduct(Model model) {
		
		model.addAttribute("productRegForm", new Product());
		model.addAttribute("pTypes" , pservice.getTypes());
		model.addAttribute("alertContext" , aserv.showAlert());

		return "adminTemplates/productReg";
	}
	
	@GetMapping("/prodList/")
	public String showProductList(Model model) {
		
		model.addAttribute("productList" , pservice.findAll());
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "adminTemplates/productListui";
		
	}
	
	@PostMapping("/addProduct/submit")
	public String submitProd(@ModelAttribute("productRegForm") Product p1) {
		
		pservice.processAddingProd(p1);
		
		return "redirect:/admin/prodForm";
		
	}
	
	//TODO restricción para no poder borrar uno que se encuentre en una linea de venta
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		
		if(pservice.processDeletingProduct(id)) {
		
			return "redirect:/admin/prodList/";
		
		}
		else {
			
			return "redirect:/admin/prodList/?error=true";
			
		}
		
	}
	
	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("productRegForm" , pservice.findById(id).get());
		
		return "adminTemplates/productReg";
		
	}
	
	@PostMapping("/editProduct/submit")
	public String submitEditedProduct(@ModelAttribute("productRegForm") Product p) {
		
		pservice.processAddingProd(p);
		
		return "redirect:/admin/prodList/";
		
	}
	
}
