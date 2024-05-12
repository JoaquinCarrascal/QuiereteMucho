package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Report;
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
	
	//true = lo puede borrar , false = no lo puede borrar
	public boolean erasableReport(Long reportId , Long clientId) { 
		
		return (reprepo.findById(reportId).get().getClient().getId() == clientId) ? true : false;
		
	}
	
	
}
