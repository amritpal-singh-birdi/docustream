package com.aps.docustream.exceptions;

public class PayloadSerializationException extends RuntimeException{

	private static final long serialVersionUID = 160770751516668903L;

	public PayloadSerializationException(String message) {
		super(message);
	}
	
	public PayloadSerializationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
