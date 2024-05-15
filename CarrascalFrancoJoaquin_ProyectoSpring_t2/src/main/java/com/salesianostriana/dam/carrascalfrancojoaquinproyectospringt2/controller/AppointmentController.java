package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Appointment;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AppointmentController {

	@Autowired
	private AppointmentService appointServ;
	
	private final AlertService aserv;
	
	@GetMapping("/userMenu/myAppointments/")
	public String showMyOwnAppointmentsList(@AuthenticationPrincipal UserEntity loggedUser , Model model) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		
		model.addAttribute("appointmentSelfList" , appointServ.findReportsByUserId(loggedUser.getId()));
		
		return "myAppointments";
		
	}
	
	@GetMapping("/userMenu/myAppointments/add/{id}")
	public String addProductToAppointment(@AuthenticationPrincipal UserEntity loggedUser , Model model , @PathVariable("id") Long productId) {
		
		Appointment appoint = appointServ.checkAppointment(loggedUser);
		
		if(appointServ.isProductPresentInApLine(appoint, productId)) {
			
			appointServ.increaseExistingProductQuantity(appoint, productId);
			
		}else {
			
			appointServ.addApLineWithProductToAppoint(appoint, productId);
			
		}
		
		return "redirect:/home";
		
	}
	
	
}
