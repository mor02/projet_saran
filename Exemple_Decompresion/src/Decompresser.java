
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class Decompresser {
 
    public static void main(String[] args) {
        String FILE_PATH = "C://Users//amgharm//Documents//C4//Transverse//Formations//cours_saran//Dossier.zip";
        
        ZipInputStream zipIs=null;
        try {
        	System.out.println("debut");
            // Créez l'objet ZipInputStream pour lire le fichier zip.
        	 zipIs = new ZipInputStream(new FileInputStream(FILE_PATH));
 
            ZipEntry entry = null;
            // Parcourir chaque Entry (de haut en bas jusqu'à la fin)
            while ((entry = zipIs.getNextEntry()) != null) {
               System.out.println("test");
            	if (entry.isDirectory()) {
                    System.out.print("Repertoire: ");
                } else {
                    System.out.print("fichier: ");
                }
                System.out.println(entry.getName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zipIs.close();
            } catch (Exception e) {
            }
        }
    }
 
}

	
	

