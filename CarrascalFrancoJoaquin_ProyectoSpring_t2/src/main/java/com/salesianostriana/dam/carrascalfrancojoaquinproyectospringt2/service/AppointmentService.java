package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.time.LocalDate;
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
	
	public List<AppointmentLine> findAllApLineByAppointId(Long appointId){
		
		return appointmentRepo.findAllApLineByAppointId(appointId);
		
	}
	
	public Appointment checkAppointment(UserEntity loggedUser) {
		
		Optional<Appointment> appointment = appointmentRepo.checkActiveAppointmentByUserId(loggedUser);
		
		return (appointment.isPresent()) ? appointment.get() : Appointment.builder().client(loggedUser).paid(false).appointmentDate(LocalDate.now()).build();
		
	}
	
	public boolean isProductPresentInApLine(Appointment appoint , Long idProduct) {
		
		return appoint.getAppointmentLList()
					.stream()
					.anyMatch(x -> x.getProduct().getId() == idProduct);
		
	}
	

	public boolean hardDeleteAppointmentLine(Appointment appoint , Long idApLine) {
		
		List<AppointmentLine> ApLineList = appoint.getAppointmentLList();
		
		Optional<AppointmentLine> apLine = appointmentRepo.findApLineById(appoint.getId() , idApLine);
		
		if(apLine.isPresent()) {
		
			ApLineList.remove(apLine.get());
		
			updateAppointmentTotalPrice(appoint);
			
			appointmentRepo.save(appoint);
			
			return true;
		}
		else {
			
			return false;
			
		}
		
	}
	
	public void increaseExistingProductQuantity(Appointment appoint , Long idProduct) {
		
		appoint.getAppointmentLList()
				.stream()
				.filter(x -> x.getProduct().getId() == idProduct)
				.findFirst()
				.get()
				.increaseQuantity();
		
		updateAppointmentTotalPrice(appoint);
		
		appointmentRepo.save(appoint);
		
	}
	
	public void decreaseExistingProductQuantity(Appointment appoint , Long idProduct) {
		
		AppointmentLine apLine = appoint.getAppointmentLList()
				.stream()
				.filter(x -> x.getProduct().getId() == idProduct)
				.findFirst()
				.get();
				
		if(apLine.getQuantity()<=1) {
			
			appoint.getAppointmentLList().remove(apLine);
			
		}else {
			
			apLine.decreaseQuantity();
			
		}
		
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
	
	public boolean processCart(UserEntity loggedUser , LocalDate date) {
		
		Appointment appoint = checkAppointment(loggedUser);
		
		if(date.isAfter(LocalDate.now().minusDays(1))) {
			
			appoint.setAppointmentDate(date);
			
			appoint.setPaid(true);
			
			//updateAppointmentTotalPrice(appoint);
			
			appointmentRepo.save(appoint);
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public boolean deleteSelfAppointments(UserEntity loggedUser , Long appointId) {
		
		if((appointmentRepo.findById(appointId).get().getClient().getId() == loggedUser.getId()) || loggedUser.isAdmin()) {
			
			appointmentRepo.deleteById(appointId);
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public boolean apLinePresent(Appointment appoint) {
		
		return (appoint.getAppointmentLList().isEmpty()) ? false : true;
		
	}
	
	public List<AppointmentLine> apLinesOnSelfAppoint(Appointment appoint){
		
		return appoint.getAppointmentLList();
		
	}
	
	public List<Appointment> top10ClosestAppoints(){
		
		return appointmentRepo.closeDateAppointList(LocalDate.now(), 10);
		
	}
	
	public Double estimatedEarningsFromDay() {
		
		return appointmentRepo.estimatedEarningsFromDay(LocalDate.now());
		
	}
	
	public Double earningsPerHairdressing() {
		
		return appointmentRepo.earningsPerHairdressing(LocalDate.now());
		
	}
	
	public Double earningsPerAesthetics() {
		
		return appointmentRepo.earningsPerAesthetics(LocalDate.now());
		
	}
	
	public Double estimatedEarningsFromCurrentYear() {
		
		return appointmentRepo.estimatedEarningsFromCurrentYear(LocalDate.now());
		
	}
	
	public List<Appointment> findAppointmentByClientId(Long id){
		
		return appointmentRepo.findAppointmentByClientId(id);
		
	}
	
}
