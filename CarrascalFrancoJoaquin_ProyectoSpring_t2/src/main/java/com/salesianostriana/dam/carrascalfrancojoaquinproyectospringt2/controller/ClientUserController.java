package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ClientUserService;

@Controller
public class ClientUserController {

	@Autowired
	private ClientUserService cus1;
	
	@GetMapping("/logform")
	public String showLogForm() {
		return "login";
	}
	
	@GetMapping("/regform")
	public String showRegForm() {
		return "register";
	}
	
}
