package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Report;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.ReportRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class ReportService extends BaseServiceImpl<Report , Long , ReportRepository>{

	@Autowired
	private ReportRepository reprepo;
	
	
	public List<Report> findNonRepliedReportList(){
		
		return reprepo.findNonRepliedReportList();
		
	}
	
	public List <Report> findReportsByUserId(Long id){
	
		return reprepo.findReportsByUserId(id);
		
	}
	
	//devuelve true si la reclamacion es del usuario recibido por argumentos
	/*public boolean isReportOwner(UserEntity loggedUser , Long reportId) {
		
		if(reprepo.findById(reportId).get().getClient().getId() == loggedUser.getId()) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}*/
	
	public boolean isReportOwner(UserEntity loggedUser , Long reportId) {
		
		if(reprepo.isReportOwner(loggedUser.getId(), reportId)) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	//true = lo puede borrar , false = no lo puede borrar
	/*public boolean erasableReport(Long reportId , Long clientId) { 
		
		return (reprepo.findById(reportId).get().getClient().getId() == clientId) ? true : false;
		
	}
	
	public void processDeletingSelfReports( UserEntity loggedUser,  Long id) {
		
		if(erasableReport(id, loggedUser.getId())) {
			deleteById(id);
		}
		
	}*/
	
	public boolean processDeletingSelfReports( UserEntity loggedUser,  Long reportId) {
		
	if(reprepo.isReportOwner(loggedUser.getId(), reportId)) {
			
			reprepo.deleteById(reportId);
			
			return true;
			
		}if(loggedUser.isAdmin()) {
		
			reprepo.deleteById(reportId);
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	public boolean processAddingReport(Report reportForm , UserEntity loggedUser) {
		
		if(reportForm.getReportDate().isBefore(LocalDate.now())) {
			
		reportForm.setClient(loggedUser);
		
		save(reportForm);
		
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	
}
