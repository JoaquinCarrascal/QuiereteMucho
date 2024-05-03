package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Alert;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.AlertRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class AlertService extends BaseServiceImpl<Alert, Long, AlertRepository>{

	public String showAlert() {
		
		Optional<Alert> opt = findById(1L); //TODO gestion alertas
		
		if(opt.get() instanceof Alert) {
			return opt.get().getDescription();
		}else {
			return "Quiérete mucho";	
		}
		
	}
	
}
