package com.tfanalista.Projetospring.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource não enccontrada. Id = "+ id);
	}
}
