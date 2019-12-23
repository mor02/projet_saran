package com.poo.mime.impl;

import com.poo.mime.beans.Fichier;
import com.poo.mime.beans.ResultatAnalyse;
import com.poo.mime.exceptions.ExceptionExtensionDiffMime;
import com.poo.mime.exceptions.ExceptionFichierCompresse;
import com.poo.mime.exceptions.ExceptionImage;
import com.poo.mime.exceptions.ExceptionRepertoireNonTrouve;
import com.poo.mime.exceptions.ExceptionVide;
import com.poo.mime.interfaces.IAnalyseur;
import com.poo.mime.interfaces.ISerialisation;
import com.poo.mime.messages.Constantes;
import com.poo.mime.utils.Decompresser;
import com.poo.mime.utils.JImage;
import com.poo.mime.utils.TableDecodageMime;

public class Analyseur implements IAnalyseur{

	ISerialisation composanteTraitement = new Serialisation();
	TableDecodageMime tableDecodage = new TableDecodageMime();
	public ResultatAnalyse analysePrincaple(String chemin) {
		String res=null;
		//0 resultat analyse;
		ResultatAnalyse resultatAnalyse = new ResultatAnalyse();
		//1 Parsing == serialisation
		Fichier fichierAnalyse = composanteTraitement.processing(chemin);
		//1-1 : On sauvegarde la serialisation dans le resultat d'analyse
		resultatAnalyse.setFichieraAnalyser(fichierAnalyse);
		//Checking 
		
		try {
			// Anomalie 1
			this.analyseIsFichierVide(fichierAnalyse);
			// Anomalie 2
			res= this.analyseExtDiffMime(fichierAnalyse);
			// Anamalie 3
			if ("png".equals(fichierAnalyse.getExtention()) || "jpeg".equals(fichierAnalyse.getExtention())) {
				 res = this.analyseImage(chemin);
			}
			//Anomalie zip et sa famille
			if ("zip".equals(fichierAnalyse.getExtention()) || "docx".equals(fichierAnalyse.getExtention())
					|| "xlsx".equals(fichierAnalyse.getExtention()) || "pptx".equals(fichierAnalyse.getExtention())
					|| "odt".equals(fichierAnalyse.getExtention()) || "ods".equals(fichierAnalyse.getExtention())
					|| "odp".equals(fichierAnalyse.getExtention())||"jar".equals(fichierAnalyse.getExtention())) {
				boolean resultatDecompression = Decompresser.unzip(chemin);
				if(!resultatDecompression) {
					throw new ExceptionFichierCompresse(Constantes.MESSAGE_ZIP_NON_VALIDE);
				}else {
					resultatAnalyse.setResultatAnalyse("Fichier compressé valide");
				}
			}
		}catch (ExceptionVide e1) {
			//System.out.println(e1.getMessage());
			resultatAnalyse.setResultatAnalyse(e1.getMessage());
		}catch (ExceptionExtensionDiffMime e2) {
			//System.out.println(e2.getMessage());
			resultatAnalyse.setResultatAnalyse(e2.getMessage());
		}catch (ExceptionRepertoireNonTrouve e3) {
			//System.out.println(e3.getMessage());
			resultatAnalyse.setResultatAnalyse(e3.getMessage());
		}catch (ExceptionImage e4) {
			//System.out.println(e4.getMessage());
			resultatAnalyse.setResultatAnalyse(e4.getMessage());
		}catch (ExceptionFichierCompresse e5) {
			resultatAnalyse.setResultatAnalyse(e5.getMessage());
			//System.out.println(e5.getMessage());
		}finally {
			if(res!=null && !res.isEmpty()) {
				resultatAnalyse.setResultatAnalyse(res);
				return resultatAnalyse;
			}
		}
		
		return resultatAnalyse;
	}
	
	public void analyseIsFichierVide(Fichier f) throws ExceptionVide {
		
		if(f== null || f.getTaille()==0) {
			throw new ExceptionVide(Constantes.MESSAGE_ANOMALIE_FICHIER_VIDE);
		}
	}

	public String analyseExtDiffMime(Fichier f) throws ExceptionExtensionDiffMime,ExceptionRepertoireNonTrouve {
		if(f!=null) {
			String mimeAttendu =null;
			//On fait ce test uniquement si l'extension est dans le fichier reference.csv
			if(tableDecodage.getTableDecodage().get(f.getExtention())!=null) {
				mimeAttendu = tableDecodage.getTableDecodage().get(f.getExtention())[0];
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
					return (Constantes.MESSAGE_FICHIER_VALIDE +" " + f.getName());
				}
			}
			
		}else {
			throw new ExceptionRepertoireNonTrouve(Constantes.MESSAGE_ANOMALIE_REP_NON_TROUVE);
		}
		return null;
	}

	@Override
	public String analyseImage(String chemin) throws ExceptionImage {
		JImage image = new JImage(chemin);
		if(image.getDimImage()==null) {
			throw new ExceptionImage(Constantes.MESSAGE_ANOMALIE_IMAGE);
		}else {
			return  Constantes.MESSAGE_IMAGE_VALIDE ;
		}
		
	}


	
	
}
