package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.exception.ProductNotFoundException;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.ProductType;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.ProductRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService 
		extends BaseServiceImpl <Product , Long , ProductRepository>{
	
	private final ProductRepository prodRepo;
	
	public List<String> getTypes(){
		
		List<String> typeList = new ArrayList<>();
		
		for(ProductType pt : ProductType.values()) {
			
			typeList.add(pt.toString());
			
		}
		
		return typeList;
		
	}
	
	public List<Product> top4BestSellingProducts(){
		
		return prodRepo.top4BestSellingProducts(); 
		
	}
	
	public List<Product> findByNameOrDesc(String search) throws ProductNotFoundException{
        List<Product> result = prodRepo.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(search, search);
        if (result.isEmpty()) {
            throw new ProductNotFoundException("No se han encontrado productos como éste.");
        }
        return result;
    }
	
	public boolean erasableProd(Long prodId) {
		
		return (prodRepo.erasableProd(prodId).isEmpty()) ? true : false;
		
	}
	
	public boolean processDeletingProduct(Long prodId) {
		
		if(erasableProd(prodId)) {
			
			prodRepo.deleteById(prodId);
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
		
	}
	
	public void processAddingProd(Product p) {
		
		prodRepo.save(p);
		
	}

}
