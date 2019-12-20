package com.poo.mime.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TableDecodageMime {

	private Map<String, String[]> tableDecodage = new HashMap<String, String[]>();
	//private final String cheminFichierCSV=".\\res\\referenceV0.csv";
	//TODO : AMINE Il faut trouver une solution pour que ça fonctionne avec un chemin relatif
	private final String cheminFichierCSV="C://Users//amgharm//Documents//C4//Transverse//Formations//cours_saran//PROJET 2019-20191213T192249Z-001//PROJET 2019//POO_MIME_2019-20//res//reference.csv";
	public TableDecodageMime() {
		this.initTableDecodage();
	}
	
	public void initTableDecodage() {
		
		BufferedReader in;
		try {
			//InputStream input = getClass().getResourceAsStream("reference.csv");
			in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(cheminFichierCSV))));
			String Line;
			while ((Line=in.readLine()) != null ) {		
				String[] args = Line.split(",");
				if(args!=null) {
					String[] matrice = new String[2];
					if(args.length == 3) {
						matrice[0] = args[1];
						matrice[1] = args[2];
						
					}else {
						matrice[0] = args[1];
					}
					tableDecodage.put(args[0], matrice);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
	}
	
	public Map<String, String[]> getTableDecodage(){
		return this.tableDecodage;
	}

}
