package com.poo.mime.exceptions;

public class ExceptionExtensionEnPlusieurs extends Exception {

	private String message;
	
	public void setMessage(String mesg) {
		this.message = mesg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
