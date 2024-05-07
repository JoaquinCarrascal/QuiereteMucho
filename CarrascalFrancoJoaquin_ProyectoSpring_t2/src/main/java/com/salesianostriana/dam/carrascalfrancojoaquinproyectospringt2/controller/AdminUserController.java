package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AdminUserService;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private AdminUserService aduservice;
	
	@GetMapping("/")
	public String showAdminProfile() {
		
		return "adminTemplates/adminProfile";
		
	}
	
	
	
}
