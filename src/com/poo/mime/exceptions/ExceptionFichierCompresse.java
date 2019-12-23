package com.poo.mime.exceptions;

public class ExceptionFichierCompresse extends Exception {

	private String message;
	
	public ExceptionFichierCompresse(String mes) {
		this.message  = mes;
	}
	public void setMessage(String mesg) {
		this.message = mesg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
