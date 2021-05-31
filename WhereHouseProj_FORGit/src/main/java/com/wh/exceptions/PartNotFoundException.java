package com.wh.exceptions;

public class PartNotFoundException extends RuntimeException {
	
	/**
	 * custome exception for part unavalible access
	 */
	private static final long serialVersionUID = 1L;
	
	public PartNotFoundException() {
		super();
	}
	public PartNotFoundException(String msg) {
		super(msg);
	}
}
