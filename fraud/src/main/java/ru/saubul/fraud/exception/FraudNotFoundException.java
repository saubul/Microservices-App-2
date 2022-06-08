package ru.saubul.fraud.exception;

public class FraudNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2184602564463703273L;
	public FraudNotFoundException(String message) {
		super(message);
	}
}
