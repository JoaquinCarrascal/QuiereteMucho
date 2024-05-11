package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.exception;

public class UnavailableUserNameException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnavailableUserNameException() {}
	
	public UnavailableUserNameException(String msg) {
		
		super(msg);
		
	}
	

}
