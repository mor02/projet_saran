package com.poo.mime.exceptions;

public class ExceptionExtensionDiffMime extends Exception {

	private String message;
	
	
	public ExceptionExtensionDiffMime(String mes) {
		this.message  = mes;
	}
	public void setMessage(String mesg) {
		this.message = mesg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
