package com.poo.mime.exceptions;

public class ExceptionExtensionEnPlusieurs extends Exception {

	private String message;
	
	public ExceptionExtensionEnPlusieurs (String mesg){
		this.message=mesg;
	}
	public void setMessage(String mesg) {
		this.message = mes;
	}
	
	public String getMessage() {
		return this.message;
	}
}
