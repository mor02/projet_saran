package com.poo.mime.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.poo.mime.beans.Fichier;
import com.poo.mime.interfaces.ISerialisation;

public class Serialisation implements ISerialisation {

	public Fichier processing(String chemin) {

		Fichier fichier = new Fichier();

		fichier.setMime(this.getMimeFichier(chemin));
		fichier.setExtention(this.getExtensionFichier(chemin));
		fichier.setName(this.getNomFichier(chemin));
		fichier.setContenu(this.getContenusFichier(chemin));
		fichier.setTaille(this.getTailleFichier(chemin));
		return fichier;
	}

	public String getMimeFichier(String chemin) {

		// fichier doit être dans le repertoire
//	      File file = new File(chemin);//
//	      
//	      //creation objet tika
//	      Tika tika = new Tika();
//	      
//	      //detection du type MIME
//	      String mime = tika.detect(file);
//		
//	      return mime;
		return "text/html";
	}

	public String getNomFichier(String chemin) {
		String nomFichierTrm = chemin.substring(chemin.lastIndexOf('\\') + 1);
		String tab [] =nomFichierTrm.split("\\.");
		return tab[0];
	}

	public String getExtensionFichier(String chemin) {
		String extension = chemin.substring(chemin.lastIndexOf('.') + 1);
		return extension;
	}

	public String getContenusFichier(String chemin) {
		Scanner input = null;
		try {
			input = new Scanner(new File(chemin));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

		List<String> allLines = new ArrayList<String>();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			return line;
		}
		return null;

	}

	public int getTailleFichier(String chemin) {
		int octets = (int) new File(chemin).length();
		return octets;
	}

}
