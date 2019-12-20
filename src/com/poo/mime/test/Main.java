package com.poo.mime.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.poo.mime.impl.Analyseur;

public class Main {

	public static void main(String[] args) {
		// Mockage
		// Type d'action demandée par l'utilisateur
		if(args==null || args.length==0) {
			//TODO :SARAN UREGENT Ajouter l'explication du programme
		}
		//String TYPE_ACTION = args[0];
		 String TYPE_ACTION = "-d";
		Analyseur analyseur = new Analyseur();
		switch (TYPE_ACTION) {
		// Cas d'un fichier : java -jar cli.jar f fichierTest.html
		case "-f":
			String fichier = args[1];
			analyseur.analysePrincaple(fichier);
			break;
		// Cas d'un repertoire
		case "-d":
			List<String> listeFichiers = new ArrayList<String>();
			//String rep = args[1];
			String rep=".\\res\\rep1";
			File repertoire = new File(rep);
			File[] files=repertoire.listFiles();
			for(File f : files) {
				System.out.println(f.getAbsolutePath());
				//TODO : SARAN avant de rajouter le ficheir dans la liste il faut vérifier si c'est un zip ou jar, si c'est le cas, il faut le dézipper (attention au cas des zip dans des zip)
				listeFichiers.add(f.getAbsolutePath());
			}
			
			for (String cheminF : listeFichiers) {
				analyseur.analysePrincaple(cheminF);
			}
			break;
		}
		
		//TODO : SARAN Travailler sur la partie sauvegarde sous csv (option s)

	}
}
