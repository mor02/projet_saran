package content;
/**
 * 
 * @author mratovo
 *
 */
public class Analyse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Avant de sauvegarder dans le fichier");
		
		testhtml();
		
		
		
		/*testpng();
		testsh();
		testodt();
		testzip();
		*/
	}

	
	private static void testhtml() {
		System.out.println("-- Analyse test.html --");
		Traitement traitement = new Traitement("test.html");
		
		
		System.out.println("\n");

	}
	
	private static void testpng() {
		System.out.println("-- Analyse test.png --");
		Traitement traitement = new Traitement ("test.png");
		System.out.println("\n");
	}
	
	private static void testsh() {
		System.out.println("-- Analyse test.sh --");
		Traitement traitement = new Traitement ("test.sh");
		System.out.println("\n");
	}

	private static void testodt() {
		System.out.println("-- Analyse test.odt --");
		Traitement traitement = new Traitement ("test.odt");
		System.out.println("\n");
	}
	
	private static void testzip() {
		
	}
	
}
