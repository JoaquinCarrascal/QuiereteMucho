package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.AlertService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.ReportService;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.UserEntityService;

@Controller
@RequestMapping("/userMenu")
public class userController {
	
	@Autowired
	private UserEntityService ueservice;
	
	@Autowired
	private AlertService as1;
	
	@Autowired
	private ReportService repserv;

	@GetMapping({"/",""})
	public String showUserMenu(Model model , @AuthenticationPrincipal UserEntity userentity) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("selfProfileForm" , userentity);
		
		return "clientProfile";
		
	}
	
	@GetMapping("/editSelf")
	public String showEditSelf() {
		
		return "redirect:/userMenu";
		
	}
	
	@PostMapping("/editSelf/submit")
	public String submitEditedSelf(@ModelAttribute("selfProfileForm") UserEntity ue , @AuthenticationPrincipal UserEntity userentity) {
		
		if(!ueservice.checkUsernameAvailability(ue.getUsername())) { //que no esté registrado aún
			
			ueservice.save(ue);
			
			ueservice.securityContextHolderUpdate(ue);
			
		}else if(ue.getUsername().equals(userentity.getUsername())) { //que sea su anterior nombre
			
			ueservice.save(ue);
			
			ueservice.securityContextHolderUpdate(ue);
			
		}
		
		return "redirect:/userMenu";
		
	}
	
	@GetMapping("/changePass")
	public String showEditPassSelf(Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("passForm" , new UserEntity());
		
		return "changePass";
		
	}
	
	@PostMapping("/changePass/submit")
	public String editPassSubmit(@AuthenticationPrincipal UserEntity loggedUser , @ModelAttribute("passForm") UserEntity formUser) {
		
		String newPass = "{bcrypt}" + new BCryptPasswordEncoder().encode(formUser.getPassword());
		
		ueservice.changeSelfPass(loggedUser.getId(), newPass);
				
		return "redirect:/userMenu";
		
	}
	
	@GetMapping("/myReports")
	public String showSelfReportList(@AuthenticationPrincipal UserEntity userentity , Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("reportSelfList" , repserv.findReportsByUserId(userentity.getId()));
		
		return "myReports";
		
	}
	
	@GetMapping("/myReports/delete/{id}")
	public String deleteSelfReports(@AuthenticationPrincipal UserEntity userentity , Model model , @PathVariable("id") Long id) {
		
		//comprobante de propiedad de la reclamacion
		if(repserv.erasableReport(id, userentity.getId())) {
			repserv.deleteById(id);
		}
		
		return "redirect:/userMenu/myReports";
		
	}
	
}
