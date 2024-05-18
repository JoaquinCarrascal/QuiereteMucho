package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/loggedUser/showCart/")
	public String showSelfShoppingCart(Model model , @AuthenticationPrincipal UserEntity loggedUser) {
		
		Appointment appoint = appointServ.checkAppointment(loggedUser);
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("ableToShow" , appointServ.apLinePresent(appoint));
		model.addAttribute("idAppointment" , appoint.getId());
		model.addAttribute("appointFullPrice" , appoint.getFullPrice());
		model.addAttribute("appoint" , appoint);
		model.addAttribute("appointmentLineSelfList" , appointServ.apLinesOnSelfAppoint(appoint));
		
		return "shoppingCart";
		
	}
	
	@GetMapping("/loggedUser/showCart/increase/{id}")
	public String increaseApLineFromCart(@AuthenticationPrincipal UserEntity loggedUser ,  @PathVariable("id") Long productId) {
		
		Appointment appoint = appointServ.checkAppointment(loggedUser);
		
		appointServ.increaseExistingProductQuantity(appoint , productId);
		
		return "redirect:/loggedUser/showCart/";
	}
	
	@GetMapping("/loggedUser/showCart/decrease/{id}")
	public String decreaseApLineFromCart(@AuthenticationPrincipal UserEntity loggedUser ,  @PathVariable("id") Long productId) {
		
		Appointment appoint = appointServ.checkAppointment(loggedUser);
		
		appointServ.decreaseExistingProductQuantity(appoint , productId);
		
		return "redirect:/loggedUser/showCart/";
	}
	
	@GetMapping("/loggedUser/showCart/hardDeleteApLine/{id}")
	public String hardDeleteApLine(@AuthenticationPrincipal UserEntity loggedUser ,  @PathVariable("id") Long apLineId) {
		
		Appointment appoint = appointServ.checkAppointment(loggedUser);
		
		if(appointServ.hardDeleteAppointmentLine(appoint, apLineId)) {
			
			return "redirect:/loggedUser/showCart/";
		
		}else {
			
			return "redirect:/loggedUser/showCart/?errorHardDelete=true";
			
		}
		
	}
	
	@GetMapping("/loggedUser/myAppointments/add/{id}")
	public String addProductToAppointment(@AuthenticationPrincipal UserEntity loggedUser , Model model , @PathVariable("id") Long productId) {
		
		Appointment appoint = appointServ.checkAppointment(loggedUser);
		
		if(appointServ.isProductPresentInApLine(appoint, productId)) {
			
			appointServ.increaseExistingProductQuantity(appoint, productId);
			
		}else {
			
			appointServ.addApLineWithProductToAppoint(appoint, productId);
			
		}
		
		return "redirect:/home";
		
	}
	
	@PostMapping("/loggedUser/showCart/submitCart")
	public String submitCart(@AuthenticationPrincipal UserEntity loggedUser , @ModelAttribute("appoint") Appointment appoint) {
		
		if(appointServ.processCart(loggedUser, appoint.getAppointmentDate())) {
			
			return "redirect:/home";
			
		}else {
			
			return "redirect:/loggedUser/showCart/?backToTheFuture=true";
			
		}
		
	}
	
	@GetMapping("/userMenu/myAppointments/delete/{id}")
	public String deleteSelfAppointments(@AuthenticationPrincipal UserEntity loggedUser, @PathVariable("id") Long id) {
		
		if(appointServ.deleteSelfAppointments(loggedUser, id)) {
			
			return "redirect:/userMenu/myAppointments/";
			
		}else {
			
			return "redirect:/userMenu/myAppointments/?error=true";
			
		}
		
	}
	
	@GetMapping("/admin/appointmentList/delete/{id}")
	public String deleteAppointmentsAdmin(@AuthenticationPrincipal UserEntity loggedUser, @PathVariable("id") Long id) {
		
		appointServ.deleteSelfAppointments(loggedUser, id);
		
		return "redirect:/admin/appointmentList/";
		
	}
	
	@GetMapping("/admin/appointmentDetails/{id}")
	public String appointmentDetails(Model model, @PathVariable("id") Long appointId) {
		
		model.addAttribute("alertContext" , aserv.showAlert());
		model.addAttribute("idAppointment" , appointId);
		model.addAttribute("apLineDetails" , appointServ.findAllApLineByAppointId(appointId));
		model.addAttribute("appointFullPrice" , appointServ.findById(appointId).get().getFullPrice());
		
		return "adminTemplates/appointmentDetails";
		
	}
	
	@GetMapping("/admin/appointmentList/")
	public String listAllAppointments(Model model) {
		
		model.addAttribute("AppointmentList" , appointServ.findAll());
		model.addAttribute("alertContext" , aserv.showAlert());
		
		return "adminTemplates/appointmentList";
		
	}
	
	
	
	
	
}
