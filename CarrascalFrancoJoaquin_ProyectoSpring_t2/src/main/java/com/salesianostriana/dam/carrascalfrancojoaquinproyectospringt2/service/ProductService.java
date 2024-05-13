package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.ProductType;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.ProductRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class ProductService 
		extends BaseServiceImpl <Product , Long , ProductRepository>{
	
	public List<String> getTypes(){
		
		List<String> typeList = new ArrayList<>();
		
		for(ProductType pt : ProductType.values()) {
			
			typeList.add(pt.toString());
			
		}
		
		return typeList;
		
	}

}
