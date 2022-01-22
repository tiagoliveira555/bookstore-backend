package com.tiago.bookstore.services.exceptions;

public class DataIntagrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntagrityViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntagrityViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
