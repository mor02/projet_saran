package com.poo.mime.exceptions;

public class ExceptionVide extends Exception {

	private String message;
	
	public ExceptionVide(String mes) {
		this.message  = mes;
	}
	public void setMessage(String mesg) {
		this.message = mesg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
