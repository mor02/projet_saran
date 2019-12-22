package com.poo.mime.exceptions;

public class ExceptionImage extends Exception {

	private String message;
	
	public ExceptionImage(String mes) {
		this.message  = mes;
	}
	public void setMessage(String mesg) {
		this.message = mesg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
