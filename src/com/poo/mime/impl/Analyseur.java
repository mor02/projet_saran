package com.poo.mime.impl;

import com.poo.mime.beans.Fichier;
import com.poo.mime.exceptions.ExceptionExtensionDiffMime;
import com.poo.mime.exceptions.ExceptionImage;
import com.poo.mime.exceptions.ExceptionRepertoireNonTrouve;
import com.poo.mime.exceptions.ExceptionVide;
import com.poo.mime.interfaces.IAnalyseur;
import com.poo.mime.interfaces.ISerialisation;
import com.poo.mime.messages.Constantes;
import com.poo.mime.utils.JImage;
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
			
			//TODO SARAN : Anomalie sur les images si l'extention jpeg ... ==> FAIT a expliquer lors de la seance
			this.analyseImage(chemin);
			//TODO : vnd.oasis.opendocument.text, --> à clarifier
		}catch (ExceptionVide e1) {
			System.out.println(e1.getMessage());
		}catch (ExceptionExtensionDiffMime e2) {
			System.out.println(e2.getMessage());
		}catch (ExceptionRepertoireNonTrouve e3) {
			System.out.println(e3.getMessage());
		}catch (ExceptionImage e4) {
			System.out.println(e4.getMessage());
		}
		
		return false;
	}
	
	public void analyseIsFichierVide(Fichier f) throws ExceptionVide {
		
		if(f== null || f.getTaille()==0) {
			throw new ExceptionVide(Constantes.MESSAGE_ANOMALIE_FICHIER_VIDE);
		}
	}

	public void analyseExtDiffMime(Fichier f) throws ExceptionExtensionDiffMime,ExceptionRepertoireNonTrouve {
		if(f!=null) {
			String mimeAttendu = tableDecodage.getTableDecodage().get(f.getExtention())[0];
			if(!mimeAttendu.equals(f.getMime())) {
					//On gère le cas HTML et SH
					if(Constantes.EXT_HTML.equals(f.getExtention()) || Constantes.EXT_SH.equals(f.getExtention())) {
						String contenuFichier = f.getContenu();
						String contenuAttendu = tableDecodage.getTableDecodage().get(f.getExtention())[1];
						if(!contenuFichier.contentEquals(contenuAttendu)) {
							throw new ExceptionExtensionDiffMime(Constantes.MESSAGE_ANOMALIE_FICHIER_EXTENTION_DIFF_MIME);
						}
					}
			}else {
				System.out.println(Constantes.MESSAGE_FICHIER_VALIDE +" " + f.getName());
			}
		}else {
			throw new ExceptionRepertoireNonTrouve(Constantes.MESSAGE_ANOMALIE_REP_NON_TROUVE);
		}
		
	}

	@Override
	public void analyseImage(String chemin) throws ExceptionImage {
		JImage image = new JImage(chemin);
		if(image.getDimImage()==null) {
			throw new ExceptionImage(Constantes.MESSAGE_ANOMALIE_IMAGE);
		}
		
	}


	
	
}
