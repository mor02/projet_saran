package com.poo.mime.interfaces;

import java.util.List;

import com.poo.mime.beans.Fichier;;

public interface ISerialisation {
	/**
	 * Sérialisation : Cette prend en paramètre un fichier physique et retourne un fichier logique (Fichier.java)
	 * @param f
	 * @return
	 */
	public Fichier processing(String chemin);
	
	public String getMimeFichier(String chemin);
	
	public String getNomFichier(String chemin);
	
	public String getExtensionFichier(String chemin);
	
	public List<String> getContenusFichier(String chemin);
	
	public int getTailleFichier(String chemin);
	
}
