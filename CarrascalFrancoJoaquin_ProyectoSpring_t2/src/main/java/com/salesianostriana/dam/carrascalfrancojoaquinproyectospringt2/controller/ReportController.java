package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Report;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ReportService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReportController {

	@Autowired
	private ReportService repservice;
	
	private final UserEntityService usenservice;
	
	@GetMapping("/reportForm")
	public String showReportForm(Model model) {
		
		model.addAttribute("legend", "Formulario de reclamación");
		model.addAttribute("reportBlank" , new Report());
		
		return "report";
		
	}
	
	@PostMapping("/addReport/submit")
	public String submitReport(@ModelAttribute("reportBlank") Report r , @AuthenticationPrincipal UserDetails userDetails) {
		
		UserEntity loggedUser = usenservice.findByAuthName(userDetails.getUsername());
		
		r.setClient(loggedUser);
		
		repservice.save(r);
		
		return "redirect:/home";
		
	}
	
	@GetMapping("/admin/reportList")
	public String showReportList(Model model) {
		
		model.addAttribute("reportList" , repservice.findAll());//TODO solo los que tienen el reply != null
		
		return "adminTemplates/reportListui";
		
	}
	
	
}
