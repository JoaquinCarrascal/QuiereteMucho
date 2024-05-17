package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

	/*@Query(value = "SELECT product_id FROM appointmentline GROUP BY product_id ORDER BY SUM(quantity) DESC LIMIT 4" , nativeQuery = true)
	List<Long> tresProductosMasVendidos();*/
	
	@Query("SELECT al.product FROM AppointmentLine al GROUP BY al.product ORDER BY SUM(al.quantity) DESC LIMIT 4")
	List<Product> top4BestSellingProducts();
	
	List<Product> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String name, String description);
	
	
}
