package com.poo.mime.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.tika.Tika;

import com.poo.mime.interfaces.ITraitement;

import com.poo.mime.beans.*;

public class Traitement implements ITraitement{

	@Override
	public Fichier processing(String chemin) {
		
		Fichier fichier = new Fichier();
		
		fichier.setMime(this.getMimeFichier(chemin));
		fichier.setExtention(this.getExtensionFichier(chemin));
		fichier.setName(this.getNomFichier(chemin));
		fichier.setContenus(this.getContenusFichier(chemin));
		fichier.setTaille(this.getTailleFichier(chemin));
		return null;
	}

	@Override
	public String getMimeFichier(String chemin) {
		
		 //fichier doit être dans le repertoire
	      File file = new File(chemin);//
	      
	      //creation objet tika
	      Tika tika = new Tika();
	      
	      //detection du type MIME
	      String mime = tika.detect(file);
		
	      return mime;
	}

	@Override
	public String getNomFichier(String chemin) {
		// TODO Saran
		return null;
	}

	@Override
	public String getExtensionFichier(String chemin) {
		// TODO Saran
		return null;
	}

	@Override
	public List<String> getContenusFichier(String chemin) {
		
		Scanner input = null;
		try {
			input = new Scanner(new File(chemin));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

		List<String> allLines = new ArrayList<String>();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			allLines.add(line);
		}
		
		return allLines;

	}

	@Override
	public int getTailleFichier(String chemin) {
		// TODO Saran
		return 0;
	}

	
}
