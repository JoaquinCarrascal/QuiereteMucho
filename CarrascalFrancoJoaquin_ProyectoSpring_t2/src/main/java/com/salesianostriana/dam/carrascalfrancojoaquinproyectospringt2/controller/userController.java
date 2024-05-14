package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Report;
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
	
	//Éste método invoca un método de UserEntityService que recibiendo el formulario
	//actualizado y la referencia del usuario logueado, comprueba que el nombre de usuario no esté
	//siendo utilizado (para que éstos no se repitan) , lo guarda y actualiza el SecurityContextHolder
	//con las nuevas credenciales, adicionalmente detecta si está usando su nombre de usuario anterior
	//en cuyo caso también permite sobreescribir los valores
	@PostMapping("/editSelf/submit")
	public String submitEditedSelf(@ModelAttribute("selfProfileForm") UserEntity userForm , @AuthenticationPrincipal UserEntity loggedUser) {
		
		if(ueservice.processEditingSelfForm(userForm , loggedUser)) {
			
			return "redirect:/userMenu";
			
		} else {
			
			return "redirect:/userMenu/?error=true";
			
		} 
		
		
		
	}
	
	@GetMapping("/changePass")
	public String showEditPassSelf(Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("passForm" , new UserEntity());
		
		return "changePass";
		
	}
	
	//Éste método invoca otro método de la clase UserEntityService que codifica una nueva
	//contraseña para el usuario y la concatena con un literal tal que : '{bcrypt}' que avisa
	//sobre el tipo de cifrado de la misma, a continuación por medio de una consulta setea la nueva
	//contraseña para el usuario logueado, una vez realizado dicho procesamiento, el método de controlador
	//presente cierra sesión para asegurar la integridad de la contraseña nueva, como medida de seguridad.
	@PostMapping("/changePass/submit")
	public String editPassSubmit(@AuthenticationPrincipal UserEntity loggedUser , @ModelAttribute("passForm") UserEntity formUser) {
		
		ueservice.processEditingSelfPass(loggedUser, formUser);
				
		return "redirect:/logout";
		
	}
	
	@GetMapping("/myReports/")
	public String showSelfReportList(@AuthenticationPrincipal UserEntity userentity , Model model) {
		
		model.addAttribute("alertContext" , as1.showAlert());
		model.addAttribute("reportSelfList" , repserv.findReportsByUserId(userentity.getId()));
		
		return "myReports";
		
	}
	
	@GetMapping("/myReports/delete/{id}")
	public String deleteSelfReports(@AuthenticationPrincipal UserEntity loggedUser, @PathVariable("id") Long id) {
		
		repserv.processDeletingSelfReports( loggedUser, id);
		
		return "redirect:/userMenu/myReports/";
		
	}
	
	//redirecciona a otro doc html de edicion de reporte porque está maquetado con el menu del usuario también.
	@GetMapping("/myReports/EditSelfReport/{id}")
	public String editSelfReports(@AuthenticationPrincipal UserEntity loggedUser, @PathVariable("id") Long id , Model model) {
		
		if(repserv.isReportOwner(loggedUser, id)) {
			
			model.addAttribute("alertContext" , as1.showAlert());
			model.addAttribute("reportEdit" , repserv.findById(id).get());
			
			return "selfReportEdit";
			
		}else {
			
			return "redirect:/userMenu/myReports/?error=true";
			
		}
		
	}
	
	@PostMapping("/myReports/EditSelfReport/submit")
	public String submitEditedSelfReport(@ModelAttribute("reportEdit") Report r1) {
		
		repserv.save(r1);
		
		return "redirect:/userMenu/myReports/";
		
	}
	
}
