package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AdminUserService;

@Controller
public class AdminUserController {

	@Autowired
	private AdminUserService aduservice;
	
	@GetMapping("/admin")
	public String showAdminProfile() {
		
		return "adminTemplates/adminProfile";
		
	}
	
	
	
}
