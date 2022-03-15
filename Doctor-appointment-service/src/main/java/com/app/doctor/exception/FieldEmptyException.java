package com.app.doctor.exception;
/*
 * This is the Exception class which handles FieldEmpty Exception
 */

public class FieldEmptyException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FieldEmptyException(String message) {
		super(message);
	}

}
