package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Alert;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;

@Controller
@RequestMapping("/admin")
public class AlertController {

	@Autowired
	private AlertService aserv;
	
	@GetMapping("/alertlist")
	public String showAlertList(Model model){
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("alertList" , aserv.findAll());
		
		return "adminTemplates/alertListui";
	}
	
	@GetMapping("/alertForm")
	public String showAlertForm(Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("legend", "Formulario de agregación");
		model.addAttribute("alertBlank" , new Alert());
		
		return "adminTemplates/alertBlank";
		
	}
	
	@PostMapping("/addAlert/submit")
	public String submitAlert(@ModelAttribute("alertBlank") Alert a1) {
		
		aserv.save(a1);
		
		return "redirect:/admin/alertlist";
		
	}
	
	@GetMapping("/deleteAlert/{id}")
	public String deleteAlert(@PathVariable("id") Long id) {
		
		Alert alertDel = aserv.findById(id).get();
		
		if(!alertDel.isActive()) {
			aserv.delete(alertDel);
			return "redirect:/admin/alertlist";
		}else {
			return "redirect:/admin/alertlist";
		}
		
	}
	
	@GetMapping("/editAlert/{id}")
	public String editAlert(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("legend", "Formulario de edición");
		model.addAttribute("alertBlank" , aserv.findById(id).get());
		
		return "adminTemplates/alertBlank";
		
	}
	
	@PostMapping("/editAlert/submit")
	public String submitEditedAlert(@ModelAttribute("alertBlank") Alert a1) {
		
		aserv.save(a1);
		
		return "redirect:/admin/alertlist";
		
	}
	
	@GetMapping("/activateAlert/{id}")//revisado en el servicio
	public String activateAlert(@PathVariable("id") Long id) {
		
		aserv.activateNewAlert(id);
		
		return "redirect:/admin/alertlist";
		
	}
	
	
	
}
