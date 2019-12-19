package com.poo.mime.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TableDecodageMime {

	private Map<String, String> tableDecodage = new HashMap<String, String>();
	private final String cheminFichierCSV="./reference.csv";
	public TableDecodageMime() {
		this.initTableDecodage();
	}
	
	public void initTableDecodage() {
		
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(cheminFichierCSV));
			String Line;
			while ((Line=in.readLine()) != null ) {		
				String[] args = Line.split(",");
				tableDecodage.put(args[0], args[1]);
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
	}
	
	public Map<String, String> getTableDecodage(){
		return this.tableDecodage;
	}

}
