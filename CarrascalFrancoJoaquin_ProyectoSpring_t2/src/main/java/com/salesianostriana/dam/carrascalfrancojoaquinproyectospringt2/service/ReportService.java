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
	
}
