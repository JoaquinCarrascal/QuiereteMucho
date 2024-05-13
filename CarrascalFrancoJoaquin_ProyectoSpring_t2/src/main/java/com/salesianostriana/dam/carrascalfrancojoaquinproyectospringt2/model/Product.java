package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String descImg;

	private String name, description , alterText;
	private double avgDuration, basePrice;

	@Enumerated(EnumType.STRING)
	private ProductType productType;
	

	public Product(String name, String description, double avgDuration, double basePrice, ProductType prodT) {
		this.name = name;
		this.description = description;
		this.avgDuration = avgDuration;
		this.basePrice = basePrice;
		this.productType = prodT;
	}


	public Product(String descImg, String name, String description, double avgDuration, double basePrice,
			ProductType productType) {
		this.descImg = descImg;
		this.name = name;
		this.description = description;
		this.avgDuration = avgDuration;
		this.basePrice = basePrice;
		this.productType = productType;
	}
	
	

}
