package projet;


	import java.io.File;

	import org.apache.tika.Tika;

	public class TikaDetecteur {

	   public static void main(String[] args) throws Exception {

	      //fichier doit être dans le repertoire
	      File file = new File("fichierhtml.html");//
	      
	      //creation objet tika
	      Tika tika = new Tika();
	      
	      //detection du type MIME
	      String filetype = tika.detect(file);
	      System.out.println(filetype);
	   }
	}
	
	
