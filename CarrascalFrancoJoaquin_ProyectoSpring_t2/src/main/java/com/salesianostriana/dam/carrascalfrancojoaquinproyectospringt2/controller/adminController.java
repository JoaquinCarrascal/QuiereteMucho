package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class adminController {
	
	private final AlertService aserv;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "adminTemplates/adminProfile";
	}
	
}
