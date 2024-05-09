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
	
	@GetMapping("/reportForm")
	public String showReportForm(Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("legend", "Formulario de reclamación");
		model.addAttribute("reportBlank" , new Report());
		
		return "report";
		
	}
	
	@PostMapping("/addReport/submit")
	public String submitReport(@ModelAttribute("reportBlank") Report r , @AuthenticationPrincipal UserEntity userentity) {
		
		r.setClient(userentity);
		
		repservice.save(r);
		
		return "redirect:/home";
		
	}
	
	@GetMapping("/admin/reportList")
	public String showReportList(Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("reportList" , repservice.findAll());
		
		return "adminTemplates/reportListui";
		
	}
	
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
	
	
	
	
}
