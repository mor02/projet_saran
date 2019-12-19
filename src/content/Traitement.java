package content;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author maeva
 *
 * contient la lecture et le traitement des fichiers
 */
public class Traitement {
	
	public Traitement(String filename){
			
			Fichier fichier=faireFichier(filename);
			boolean value = comparerCSV("reference.csv",fichier);
			
			System.out.println(fichier.toString());
			
			if (value==false) {
				System.out.println("Extention et mime incoherents");
			} else{
				System.out.println("Extention et mime coherents");
				if (fichier.getExtention().equals("html") || fichier.getExtention().contentEquals("sh")){
					//System.out.println(getSignature(filename));
					if (fichier.getExtention().equals(getSignature(filename))){
						System.out.println("Contenu fichier ("+fichier.getExtention()+") et signature ("+getSignature(filename)+") coherents\n");
					}
				} else if (fichier.getExtention().equals("png") || fichier.getExtention().equals("jpg") || fichier.getExtention().equals("jpeg")){
					try {
						BufferedImage img;
						img = ImageIO.read(new File(filename));
						int height = img.getHeight();
						int width = img.getWidth();
						
						System.out.println("Les dimensions de cette image sont h ="+height+"px, w ="+width+"px");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else {
					System.out.println("probleme");
				}

			}
			
		}
		/**
		 * compare le contenu d'un fichier en lecture
		 * retourne l'extention attendue selon les premières lignes du fichier
		 * @param filename
		 * @return
		 */
		public String getSignature(String filename) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(filename));
				String Line;
				// tant que le fichier n'est pas vide
				while ((Line=in.readLine()) != null ) {		
					String[] args = Line.split("\n");
					
					if (args.length!=0) {
						if (args[0].contains("<!--") && args[0].contains("-->")) {
							if (args[1].contains("<!DOCTYPE>")) {
								return "html";
							} 
						} else if (args[0].contains("<!DOCTYPE html>")) {
							return "html";
						} else if (args[0].contains("#bin/")) {
								return "sh";
						
					} else {
						return "inconnu";
					}
					
				}
			}
				in.close();
			} catch (EOFException e) {
				// No message predefined, we have to write here our own message.
				System.out.println("End of file reading");
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			return "inconnu";

		}
		/**
		 *  compare le mime du fichier csv au mime du fichier en entrée
		 * @param filename
		 * @param fichier
		 * @return
		 */
		public boolean comparerCSV(String filename,Fichier fichier) {
			
			try {
				BufferedReader in = new BufferedReader(new FileReader(filename));
				String Line;
				// tant que le fichier n'est pas vide
				while ((Line=in.readLine()) != null ) {		
					String[] args = Line.split(",");
					if (args.length!=0) {
						if (fichier.getExtention().equals(args[0])) {
							//System.out.println("args[0] est "+ args[0]);
							if (fichier.getMime().equals(args[1])) {
								//System.out.println("args[1] est "+ args[1]);
								return true;
							}
						}
						
					}
					
				}
				in.close();
			}
			catch (EOFException e) {
				// No message predefined, we have to write here our own message.
				System.out.println("End of file reading");
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			return false;
		}
						
						/*switch(args[0]) {
						
						
						case "html":
							if (fichier.getMime().equals(args[1])) {
								return true;
							}
							
						case "sh":
							if (fichier.getMime().equals(args[1])){
								return true;
							}
							
						case "png":
							if (fichier.getMime().equals(args[1])){
								return true;
							}
							
						case "jpg" :
							if (fichier.getMime().equals(args[1])){
								return true;
							}
						case "jpeg" :
							if (fichier.getMime().equals(args[1])){
								return true;
							}
							
						case "zip" :
							
							if (fichier.getMime().equals(args[1])){
								return true;
							}
							
						case "odt" :
							
							if (fichier.getMime().equals(args[1])){
								return true;
							}
						}
					}
				}
				in.close();
			} catch (EOFException e) {
				// No message predefined, we have to write here our own message.
				System.out.println("End of file reading");
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			return false;
		}*/
		
		
		
		/**
		 * permet de traiter tous les fichiers d'un dossier spécifié 
		 * @param FileDirectory
		 */
		public void arborescence(String FileDirectory) {
			File directory = new File(FileDirectory);
			File[] files = directory.listFiles();
			
			for(File file : files) {
				if(file.isDirectory() && file.exists()) {
					arborescence(file.getPath());
				}
				if(file.getName().contains(".html") || file.getName().contains(".sh") || file.getName().contains(".png") || file.getName().contains(".zip") || file.getName().contains(".odt")) {
					System.out.println(directory.getName()+"/"+file.getName());

				}
			}
		}
		
		public Fichier faireFichier(String filename) {

				Fichier fichier =new Fichier();
				fichier.setName(filename);
				//fichier.setMime("text/html"); //sara
				fichier.setMime("image/png");
				//pour l'instant seuls les fichiers test.* sont pris en compte
				String[] args = filename.split("test.");
				for (String string : args) {
					fichier.setExtention(string);
				}
				
				
				return fichier;

		}
		
}