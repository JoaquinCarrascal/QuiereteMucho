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

//Controlador de gestión de alertas por parte de los administradores
@Controller
@RequestMapping("/admin")
public class AlertController {

	@Autowired
	private AlertService aserv;
	
	//Éste método sirve para listar las alertas en el menú admin
	@GetMapping("/alertlist/")
	public String showAlertList(Model model){
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("alertList" , aserv.findAll());
		
		return "adminTemplates/alertListui";
	}
	
	//Éste método devuelve un formulario para que un admin pueda crear una alerta nueva
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
		
		return "redirect:/admin/alertlist/";
		
	}
	
	//Éste método se interpone en el borrado de una alerta 
	//invocando un método del AlertService que prohíbe
	//su borrado si está siendo usada en la página
	//éste procesamiento se efectúa en el AlertService
	@GetMapping("/deleteAlert/{id}")
	public String deleteAlert(@PathVariable("id") Long id) {
		
		if(aserv.processDeletingAlert(id)) {
			return "redirect:/admin/alertlist/?error=true";
		}else {
			return "redirect:/admin/alertlist/";
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
		
		return "redirect:/admin/alertlist/";
		
	}
	
	//Éste método recibe por parámetros la id de una alerta e invoca un método del AlertService
	//que primero desactiva la actual y posteriormente activa la deseada
	//éste procesamiento se da en el AlertService y se apoya de 2 consultas
	//en el AlertRepository
	@GetMapping("/activateAlert/{id}")
	public String activateAlert(@PathVariable("id") Long id) {
		
		aserv.activateNewAlert(id);
		
		return "redirect:/admin/alertlist/";
		
	}
	
	
	
}
