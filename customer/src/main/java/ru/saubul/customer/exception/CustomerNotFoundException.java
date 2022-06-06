package ru.saubul.customer.exception;


public class CustomerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2871715505185664754L;
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
