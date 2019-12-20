package com.poo.mime.impl;

import com.poo.mime.beans.Fichier;
import com.poo.mime.exceptions.ExceptionExtensionDiffMime;
import com.poo.mime.exceptions.ExceptionRepertoireNonTrouve;
import com.poo.mime.exceptions.ExceptionVide;
import com.poo.mime.interfaces.IAnalyseur;
import com.poo.mime.interfaces.ISerialisation;
import com.poo.mime.messages.ConstanteMessage;
import com.poo.mime.utils.TableDecodageMime;

public class Analyseur implements IAnalyseur{

	ISerialisation composanteTraitement = new Serialisation();
	TableDecodageMime tableDecodage = new TableDecodageMime();
	public boolean analysePrincaple(String chemin) {
		//1 Parsing
		Fichier fichierAnalyse = composanteTraitement.processing(chemin);
		
		//Checking 
		
		try {
			//Anomalie 1
			this.analyseIsFichierVide(fichierAnalyse);
			//Anomalie 2
			this.analyseExtDiffMime(fichierAnalyse);
		}catch (ExceptionVide e1) {
			System.out.println(e1.getMessage());
		}catch (ExceptionExtensionDiffMime e2) {
			System.out.println(e2.getMessage());
		}catch (ExceptionRepertoireNonTrouve e3) {
			System.out.println(e3.getMessage());
		}
		
		return false;
	}
	
	public void analyseIsFichierVide(Fichier f) throws ExceptionVide {
		
		if(f== null || f.getTaille()==0) {
			throw new ExceptionVide(ConstanteMessage.MESSAGE_ANOMALIE_FICHIER_VIDE);
		}
	}

	public void analyseExtDiffMime(Fichier f) throws ExceptionExtensionDiffMime,ExceptionRepertoireNonTrouve {
		if(f!=null) {
			String mimeAttendu = tableDecodage.getTableDecodage().get(f.getExtention());
			if(!mimeAttendu.equals(f.getMime())) {
					throw new ExceptionExtensionDiffMime(ConstanteMessage.MESSAGE_ANOMALIE_FICHIER_EXTENTION_DIFF_MIME);
			}
		}else {
			throw new ExceptionRepertoireNonTrouve(ConstanteMessage.MESSAGE_ANOMALIE_REP_NON_TROUVE);
		}
		
	}


	
	
}
