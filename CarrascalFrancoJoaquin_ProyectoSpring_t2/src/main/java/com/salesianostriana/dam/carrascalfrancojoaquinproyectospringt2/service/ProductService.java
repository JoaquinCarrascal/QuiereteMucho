package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.model.Product;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.repository.ProductRepository;
import com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.service.base.BaseServiceImpl;

@Service
public class ProductService 
		extends BaseServiceImpl <Product , Long , ProductRepository>{

}
