package com.poo.mime.interfaces;

import com.poo.mime.beans.Fichier;
import com.poo.mime.exceptions.ExceptionExtensionDiffMime;
import com.poo.mime.exceptions.ExceptionVide;

public interface IAnalyseur {

	public boolean analysePrincaple(String chemin);
	
	public void analyseIsFichierVide(Fichier f) throws ExceptionVide;
	
	public void analyseExtDiffMime(Fichier f) throws ExceptionExtensionDiffMime;
}
