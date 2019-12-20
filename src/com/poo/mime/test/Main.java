package com.poo.mime.test;

import java.util.List;

import com.poo.mime.impl.Analyseur;

public class Main {

	public static void main(String[] args) {
		//Mockage
		//Type d'action demandée par l'utilisateur
		String TYPE_ACTION = args[0];
		//String TYPE_ACTION = "-f";
		Analyseur analyseur = new Analyseur();
//		System.out.println("Les paramètres : " );
//		for(int i=0;i<args.length;i++) {
//			System.out.println(args[i]);
//		}
		switch (TYPE_ACTION) {
		//Cas d'un fichier : java -jar cli.jar f fichierTest.html
		case "-f":
			String fichier = args[1];
			//String fichier = ".\\res\\test.html";
			analyseur.analysePrincaple(fichier);
			break;
		//Cas d'un repertoire
		case "d" : 
			//TODO SARAN : 1 RÃ©cupÃ©rer les ficheir de ce reperotire dans une liste
				
			//les lesFichiers represente le repertoire
			//laliste c'est la ou seront les fichiers du repertoire
//			File lesFichiers = new File(args[0]);
//			String laListe[]=lesFichiers.list();
//			if (laListe !=null){
//				for (int i=0;i<laListe.length;i++) {
//					
//					System.out.println(laListe[i]);
//				}
//			}else {
//				System.out.println("nom du repertoire invalide");
//				
//				
//			}
			List<String> listeFichiers=null;
			for(String cheminF: listeFichiers) {
				analyseur.analysePrincaple(cheminF);
			}
			break;
		}
		
		
	}
}
