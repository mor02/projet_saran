package com.poo.mime.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.poo.mime.beans.ResultatAnalyse;
import com.poo.mime.impl.Analyseur;

public class Main {

	public static void main(String[] args) {
		// Mockage
		// Type d'action demandÃ©e par l'utilisateur
		if((args==null || args.length==0 || "-h".equals(args[0]))) {
			System.out.println("Modes d'utilisation ");
			System.out.println("-d : liste et analyse tous les fichiers a partir du dossier specifie");
			System.out.println("-f : prend en entree le fichier voulu et affiche a l'ecran le resultat de son traitement");
			System.out.println("-s : sauvegarde le resultat de la verification");
			System.out.println("gui.jar : la derniere ligne correspond au lancement de l'interface graphique");	
			
		}
		//String TYPE_ACTION = args[0];
		 String TYPE_ACTION = "-d";
		Analyseur analyseur = new Analyseur();
		List<ResultatAnalyse> listeResAnalyse =new ArrayList<ResultatAnalyse>();
		switch (TYPE_ACTION) {
		// Cas d'un fichier : java -jar cli.jar f fichierTest.html
		case "-f":
			//String fichier = args[1];
			String fichier = ".\\res\\testWord.docx";
			ResultatAnalyse r = analyseur.analysePrincaple(fichier);
			listeResAnalyse.add(r);
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
				listeFichiers.add(f.getAbsolutePath());
			}
			
			for (String cheminF : listeFichiers) {
				ResultatAnalyse r1 = analyseur.analysePrincaple(cheminF);
				listeResAnalyse.add(r1);
			}
			break;
		}
		
		if(args!=null && args.length>3 && "-s".equals(args[2])) {
			//Procéder à la generation du resultat d'analyse en CSV
			//VO : imprission au console de l'objet
			for(ResultatAnalyse rTmp: listeResAnalyse) {
				System.out.println("Nom Fichier : " + rTmp.getFichieraAnalyser().getName() + " Extension fichier : " + rTmp.getFichieraAnalyser().getExtention() + " resultat analyse :" + rTmp.getResultatAnalyse());
			}
			//V1 : Ecriture de l'objet dans un fichier csv
			
			for(ResultatAnalyse rTmp: listeResAnalyse) {
				rTmp.writeFile(new FileWriter(file));
				System.out.println("Nom Fichier : " + rTmp.getFichieraAnalyser().getName() + " Extension fichier : " + rTmp.getFichieraAnalyser().getExtention() + " resultat analyse :" + rTmp.getResultatAnalyse());
			}
		}

	}
}
