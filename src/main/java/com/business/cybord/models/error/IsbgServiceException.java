package com.business.cybord.models.error;

public class IsbgServiceException extends Exception {

	private static final long serialVersionUID = 3366814987437305737L;

	private String developerMessage;
	private int httpStatus;

	public IsbgServiceException(String message, String developerMessage, int httpStatus) {
		super(message);
		this.developerMessage = developerMessage;
		this.httpStatus = httpStatus;
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

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "IsbgServiceException [developerMessage=" + developerMessage + ", httpStatus=" + httpStatus + "]";
	}

}
