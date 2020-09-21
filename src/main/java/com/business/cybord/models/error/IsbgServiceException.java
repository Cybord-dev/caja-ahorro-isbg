package com.business.cybord.models.error;

public class IsbgServiceException extends Exception{

	private static final long serialVersionUID = 3366814987437305737L;
	
	private String developerMessage;
	
	public IsbgServiceException(String message,String developerMessage) {
		super(message);
		this.developerMessage=developerMessage;
	}
	
	public IsbgServiceException(String message) {
		super(message);
	}
	
	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	@Override
	public String toString() {
		return "IsbgServiceError [developerMessage=" + developerMessage + "]";
	}
	
	
	
}
