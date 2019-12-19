package content;

import java.io.File;
import content.*;

/**
 * ;
 * @author maeva
 *
 */
public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Entree nulle de parametre au terminal : affichage du mode d'utilisation
		
		if (args.length==0) {
			
			System.out.println("Modes d'utilisation ");
			System.out.println("-d : liste et analyse tous les fichiers a  partir du dossier specifie");
			System.out.println("-f : prend en entree le fichier voulu et affiche a l'ecran le resultat de son traitement");
			System.out.println("-s : sauvegarde le resultat de la verification");
			
		} else if(args[0].equals("-d")){

			if (args.length == 2) {
				System.out.println("arborescence a faire");
			} else {
				System.out.println("il manque le dossier a traiter");
			}
			
		} else if (args[0].equals("-f")) {
			
			if (args.length==2) {
				/*
				Fichier fichier=new Fichier();
				fichier.setMime("text/html");
				*/
				File file=new File(args[1]);
				
				if(file.length()==0) {
					System.out.println("le fichier est vide");
				} else {
					Traitement traitement = new Traitement(args[1]);
				}	
				
			} else {
				System.out.println("il manque le fichier Ã  traiter");
			}
		}

	}
}