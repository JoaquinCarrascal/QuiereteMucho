package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public ProductNotFoundException() {
	        super("No hay criterios con los productos de búsqueda especificados");
	    }
	    
	    public ProductNotFoundException(String msg) {
	        super("No hay criterios con los productos de búsqueda especificados");
	    }

}
