package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		model.addAttribute("legend", "Formulario de agregación");
		model.addAttribute("alertBlank" , new Alert());
		
		return "alertBlank";
		
	}
	
	@PostMapping("/addAlert/submit")
	public String submitAlert(@ModelAttribute("alertBlank") Alert a1) {
		
		aserv.save(a1);
		
		return "redirect:/alertlist";
		
	}
	
	@GetMapping("/deleteAlert/{id}")
	public String deleteAlert(@PathVariable("id") Long id) {
		
		aserv.delete(aserv.findById(id).get());
		
		return "redirect:/alertlist";
	}
	
	@GetMapping("/editAlert/{id}")
	public String editAlert(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("legend", "Formulario de edición");
		model.addAttribute("alertBlank" , aserv.findById(id).get());
		
		return "alertBlank";
		
	}
	
	@PostMapping("/editAlert/submit")
	public String submitEditedAlert(@ModelAttribute("alertBlank") Alert a1) {
		
		aserv.save(a1);
		
		return "redirect:/alertlist";
		
	}
	
	@GetMapping("/activateAlert/{id}")
	public String activateAlert(@PathVariable("id") Long id) {
		
		aserv.activateNewAlert(id);
		
		return "redirect:/alertlist";
		
	}
	
	
	
}
