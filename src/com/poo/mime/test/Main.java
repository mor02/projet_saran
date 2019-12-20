package com.poo.mime.test;

import java.io.File;
import java.util.List;

import com.poo.mime.impl.Analyseur;

public class Main {

	public static void main(String[] args) {
		
		//TODO : SARAN récupération du parémtrage
		String TYPE_ACTION = args[1];
		Analyseur analyseur = new Analyseur();
		System.out.println("Les param�tre : " );
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		switch (TYPE_ACTION) {
		case "f":
			analyseur.analysePrincaple(args[2]);
			break;
		case "d" : 
			//TODO SARAN : 1 Récupérer les ficheir de ce reperotire dans une liste
				
			//les lesFichiers represente le repertoire
			//laliste c'est la ou seront les fichiers du repertoire
			File lesFichiers = new File(args[0]);
			String laListe[]=lesFichiers.list();
			if (laListe !=null){
				for (int i=0;i<laListe.length;i++) {
					
					System.out.println(laListe[i]);
				}
			}else {
				System.out.println("nom du repertoire invalide");
				
				
			}
			List<String> listeFichiers=null;
			for(String cheminF: listeFichiers) {
				analyseur.analysePrincaple(cheminF);
			}
			break;
		}
		
		
	}
}
