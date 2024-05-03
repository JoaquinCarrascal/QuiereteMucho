package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Alert;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;

@Controller
public class AlertController {

	@Autowired
	private AlertService aserv;
	
	@GetMapping("/alertlist")
	public String showAlertList(Model model){
		
		model.addAttribute("alertList" , aserv.findAll());
		
		return "alertListui";
	}
	
	@GetMapping("/alertForm")
	public String showAlertForm(Model model) {
		
		model.addAttribute("alertBlank" , new Alert());
		
		return "alertBlank";
		
	}
	
	@PostMapping("/addAlert")
	public String submitAlert(@ModelAttribute("alertBlank") Alert a1) {
		
		aserv.save(a1);
		
		return "redirect:/alertlist";
		
	}
	
}
