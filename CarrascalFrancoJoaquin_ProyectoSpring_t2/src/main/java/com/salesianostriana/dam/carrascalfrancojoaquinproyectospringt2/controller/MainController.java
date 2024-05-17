package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		model.addAttribute("productList" , prodserv.top4BestSellingProducts());
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "home";
	}
	
	@GetMapping("/home/services")
	public String showServices(Model model) {
		
		model.addAttribute("productList" , prodserv.findAll());
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "productsList";
		
	}
	
	@GetMapping("/home/services/search")
    public String buscarMerchPorNombre(Model model, @RequestParam("search") String search) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
        model.addAttribute("productList", prodserv.findByNameOrDesc(search));
        
        return "productsList";
    }
	
}
