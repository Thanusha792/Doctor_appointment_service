package com.app.doctor.exception;
/*
 * This is the Exception class which handles NoDoctorException Exception
 */
public class NoDoctorsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NoDoctorsException(String message) {
		super(message);
	}


}
