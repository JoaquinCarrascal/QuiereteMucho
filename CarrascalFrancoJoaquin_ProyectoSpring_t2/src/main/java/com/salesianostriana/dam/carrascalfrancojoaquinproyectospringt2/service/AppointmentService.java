package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Appointment;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.AppointmentLine;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.UserEntity;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.AppointmentRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class AppointmentService extends BaseServiceImpl<Appointment , Long , AppointmentRepository>{

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private ProductService prodServ;
	
	public List <Appointment> findReportsByUserId(Long id){
		
		return appointmentRepo.findAppointmentByClientId(id);
		
	}
	
	public Appointment checkAppointment(UserEntity loggedUser) {
		
		Optional<Appointment> appointment = appointmentRepo.checkActiveAppointmentByUserId(loggedUser);
		
		return (appointment.isPresent()) ? appointment.get() : Appointment.builder().client(loggedUser).paid(false).build();
		
	}
	
	public boolean isProductPresentInApLine(Appointment appoint , Long idProduct) {
		
		return appoint.getAppointmentLList()
					  .stream()
					  .anyMatch(x -> x.getProduct().getId() == idProduct);
		
	}
	
	public void increaseExistingProductQuantity(Appointment appoint , Long idProduct) {
		
		appoint.getAppointmentLList()
				.stream()
				.filter(x -> x.getProduct().getId() == idProduct)
				.findFirst()
				.get().increaseQuantity();
		
		updateAppointmentTotalPrice(appoint);
		
		appointmentRepo.save(appoint);
		
	}
	
	public void addApLineWithProductToAppoint(Appointment appoint , Long idProduct) {
		
		appoint.getAppointmentLList().add(new AppointmentLine(appoint,1,0,prodServ.findById(idProduct).get()));
		
		updateAppointmentTotalPrice(appoint);
		
		appointmentRepo.save(appoint);
		
	}
	
	public void updateAppointmentTotalPrice(Appointment appoint) {
		
		List<AppointmentLine> ApLineList = appoint.getAppointmentLList();
		
		ApLineList.stream()
				.forEach(x -> x.setSubTotal(x.getProduct().getBasePrice() * x.getQuantity()));
		
		appoint.setFullPrice(ApLineList.stream().mapToDouble(AppointmentLine::getSubTotal).sum());
		
	}
	
	public boolean apLinePresent(Appointment appoint) {
		
		return (appoint.getAppointmentLList().isEmpty()) ? false : true;
		
	}
	
	public List<AppointmentLine> apLinesOnSelfAppoint(Appointment appoint){
		
		return appoint.getAppointmentLList();
		
	}
	
}
