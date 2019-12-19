package com.poo.mime.exceptions;

public class ExceptionRepertoireNonTrouve extends Exception {

	private String message;
	
	public ExceptionRepertoireNonTrouve(String mes) {
		this.message  = mes;
	}
	public void setMessage(String mesg) {
		this.message = mesg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
