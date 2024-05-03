package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;

@Controller
public class AlertController {

	@Autowired
	private AlertService aserv;
	
	@GetMapping("/admin/alertlist")
	public String showAlertList(Model model){
		
		model.addAttribute("alertList" , aserv.findAll());
		
		return "adminTemplates/alertListui";
	}
	
}
