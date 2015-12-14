import modele.Client;
import modele.ClientParticulier;
import application.Application;

/**
 * Classe de lancement de l'application
 * 
 * @author Quentin
 * 
 */
public class Main implements Cloneable {

	public static void main(String[] args) {
		Application ap = new Application();
		ap.demarrer();		
		
		//permet de tester l'interface Cloneable 
		Client p1 = new ClientParticulier("GP.aj98765", "AiMARRE",
				"Jean", 12, "AiMARRE@mail.fr");
		p1.nouveauCompte(1000.00, "A");
		p1.nouveauCompte(100.0, "B");
		p1.nouveauCompte(10.0, "C");
		
		Client p2 = (Client) p1.clone();

		System.out.println(p1);
		System.out.println(p2);
	}

}
