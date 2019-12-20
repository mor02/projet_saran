package com.poo.mime.test;

import java.util.List;

import com.poo.mime.impl.Analyseur;

public class Main {

	public static void main(String[] args) {
		
		//TODO : SARAN récupération du parémtrage
		String TYPE_ACTION = args[1];
		Analyseur analyseur = new Analyseur();
		System.out.println("Les paramètre : " );
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		switch (TYPE_ACTION) {
		case "f":
			analyseur.analysePrincaple(args[2]);
			break;
		case "d" : 
			//TODO SARAN : 1 Récupérer les fichier de ce reperotire dans une liste
			List<String> listeFichiers=null;
			for(String cheminF: listeFichiers) {
				analyseur.analysePrincaple(cheminF);
			}
			break;
		}
		
		
	}
}
