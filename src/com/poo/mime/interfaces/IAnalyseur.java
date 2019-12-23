package com.poo.mime.interfaces;

import com.poo.mime.beans.Fichier;
import com.poo.mime.beans.ResultatAnalyse;
import com.poo.mime.exceptions.ExceptionExtensionDiffMime;
import com.poo.mime.exceptions.ExceptionImage;
import com.poo.mime.exceptions.ExceptionRepertoireNonTrouve;
import com.poo.mime.exceptions.ExceptionVide;

public interface IAnalyseur {

	public ResultatAnalyse analysePrincaple(String chemin);
	
	public void analyseIsFichierVide(Fichier f) throws ExceptionVide;
	
	public String analyseExtDiffMime(Fichier f) throws ExceptionExtensionDiffMime,ExceptionRepertoireNonTrouve;
	
	public String analyseImage(String chemin) throws ExceptionImage;
	
}
