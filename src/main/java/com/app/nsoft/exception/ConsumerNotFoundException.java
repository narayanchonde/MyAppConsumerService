package com.app.nsoft.exception;

public class ConsumerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConsumerNotFoundException() {
		super();
	}
	
	public ConsumerNotFoundException(String message) {
		super(message);
	}

}
