package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Alert;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.AlertRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class AlertService extends BaseServiceImpl<Alert, Long, AlertRepository>{

	@Autowired
	private AlertRepository arepo;
	
	public String showAlert() {
		
		String desc = findActiveAlert().getDescription();
		
		if(desc != null) {
			return desc;
		}else {
			return "Quiérete mucho";	
		}
		
	}
	
	@Transactional
	public void activateNewAlert(Long newAlertId) {
		
		Long oldAlertId = findActiveAlert().getId();
		deactivateAlert(oldAlertId);
		
		activateAlert(newAlertId);
		
	}
	
	@Transactional
	public Alert findActiveAlert() {
		
		return arepo.findActiveAlert().get(0);
		
	}
	
	@Transactional
	public void deactivateAlert(Long id) {
		
		arepo.deactivateAlertQuery(id);
		
	}
	
	public void activateAlert(Long id) {
		
		arepo.activateAlertQuery(id);
		
	}
	
	
}
