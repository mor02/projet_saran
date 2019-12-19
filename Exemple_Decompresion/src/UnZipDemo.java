import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class UnZipDemo {
 
    public static void main(String[] args) {
        final String OUTPUT_FOLDER = "C://Users//amgharm//Documents//C4//Transverse//Formations//cours_saran";
        String FILE_PATH = "C://Users//amgharm//Documents//C4//Transverse//Formations//cours_saran//Dossier.zip";
 
        // Créez le dossier Output s'il n'existe pas.
        File folder = new File(OUTPUT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // Créez un buffer (Tampon).
        byte[] buffer = new byte[1024];
 
        ZipInputStream zipIs = null;
        try {
            // Créez un objet ZipInputStream pour lire les fichiers à partir d'un chemin (path).
            zipIs = new ZipInputStream(new FileInputStream(FILE_PATH));
 
            ZipEntry entry = null;
            // Parcourir chaque Entry (de haut en bas jusqu'à la fin)
            while ((entry = zipIs.getNextEntry()) != null) {
                String entryName = entry.getName();
                String outFileName = OUTPUT_FOLDER + File.separator + entryName;
                System.out.println("Unzip: " + outFileName);
 
                if (entry.isDirectory()) {
                    // Créer des dossiers.
                    new File(outFileName).mkdirs();
                } else {
                    // Créez un Stream pour graver des données dans le fichier.
                    FileOutputStream fos = new FileOutputStream(outFileName);
 
                    int len;
                    // ​​​​​​​
                    // Lisez les données sur Entry présent
                    while ((len = zipIs.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
 
                    fos.close();
                }
 
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