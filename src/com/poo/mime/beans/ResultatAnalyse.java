package com.poo.mime.beans;

public class ResultatAnalyse {

	private Fichier fichieraAnalyser;
	private String resultatAnalyse;
	
	
	public Fichier getFichieraAnalyser() {
		return fichieraAnalyser;
	}
	
	public void setFichieraAnalyser(Fichier f) {
		this.fichieraAnalyser =f;
	}
	
	public String getResultatAnalyse() {
		return this.resultatAnalyse;
	}
	
	public void setResultatAnalyse(String rs) {
		this.resultatAnalyse=rs;
	}
}
