package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Report;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ReportService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReportController {

	@Autowired
	private ReportService repservice;
	
	private final AlertService aserv;
	
	@GetMapping("/reportForm/")
	public String showReportForm(Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("legend", "Formulario de reclamación");
		model.addAttribute("reportBlank" , new Report());
		
		return "report";
		
	}
	
	//Éste método invoca un método de la clase ReportService
	//dicho método setea el usuario logueado como propietario de la reclamación
	//y la guarda en bbdd
	@PostMapping("/addReport/submit")
	public String submitReport(@ModelAttribute("reportBlank") Report reportForm , @AuthenticationPrincipal UserEntity loggedUser) {
		
		if(repservice.processAddingReport( reportForm , loggedUser)) {
			
			return "redirect:/home";
			
		}
		else {
			
			return "redirect:/reportForm/?error=true";
			
		}
		
	}
	
	//Éste método invoca un método que lanza una consulta a la bbdd
	//que devuelve las reclamaciones que aún no han sido contestadas
	@GetMapping("/admin/reportList")
	public String showReportList(Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("reportList" , repservice.findNonRepliedReportList());
		
		return "adminTemplates/reportListui";
		
	}
	
	//Éste método carga un formulario de reclamación con los datos de una reclamación
	//y le permite al administrador contestarla para poner en conocimiento al cliente
	@GetMapping("/admin/replyReport/{id}")
	public String showReportRepliable(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("legend", "Formulario de resolución");
		model.addAttribute("reportBlank" , repservice.findById(id).get());
		
		return "report";
		
	}
	
	@PostMapping("/admin/replyReport/submit")
	public String replyReport(@ModelAttribute("reportBlank") Report r1) {
		
		repservice.save(r1);
		
		return "redirect:/admin/reportList";
		
	}
	
	@GetMapping("/admin/deleteReport/{id}")
	public String deleteReport(@PathVariable("id") Long id) {
	
		repservice.deleteById(id);
		
		return "redirect:/admin/reportList";
		
	}
	
	@GetMapping("/userMenu/myReports/")
	public String showSelfReportList(@AuthenticationPrincipal UserEntity userentity , Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("reportSelfList" , repservice.findReportsByUserId(userentity.getId()));
		
		return "myReports";
		
	}
	
	@GetMapping("/userMenu/myReports/delete/{id}")
	public String deleteSelfReports(@AuthenticationPrincipal UserEntity loggedUser, @PathVariable("id") Long id) {
		
		if(repservice.processDeletingSelfReports( loggedUser, id)) {
		
		return "redirect:/userMenu/myReports/";
		
		}
		else {
			
			return "redirect:/userMenu/myReports/?errorDelete=true"; 
			
		}
		
		
	}
	
	//redirecciona a otro doc html de edicion de reporte porque está maquetado con el menu del usuario también.
	@GetMapping("/userMenu/myReports/EditSelfReport/{id}")
	public String editSelfReports(@AuthenticationPrincipal UserEntity loggedUser, @PathVariable("id") Long id , Model model) {
		
		if(repservice.isReportOwner(loggedUser, id)) {
			
			model.addAttribute("alertContext" , aserv.showAlert());
			model.addAttribute("reportEdit" , repservice.findById(id).get());
			
			return "selfReportEdit";
			
		}else {
			
			return "redirect:/userMenu/myReports/?error=true";
			
		}
		
	}
	
	@PostMapping("/userMenu/myReports/EditSelfReport/submit")
	public String submitEditedSelfReport(@ModelAttribute("reportEdit") Report r1) {
		
		repservice.save(r1);
		
		return "redirect:/userMenu/myReports/";
		
	}
	
	
}
