package tp01;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	private ArrayList<Personne> tabClients = new ArrayList<Personne>();

	public Application() {

	}

	public void demarrer() {
		menu();
	}

	public int menu() {
		System.out.println("1. Afficher tous les clients et leurs comptes.");
		System.out.println("2. Faire une opération sur le compte d’un client.");
		System.out.println("3. Quitter.");
		System.out.println("Saisir votre choix : ");
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			int c = sc.nextInt();
			return c;
		} else {
			return -1;
		}

	}

	public void aouterClient(Personne p) {
		this.tabClients.add(p);
	}

	public boolean faireOperation(String numClient, String numCompte,
			int typeOperation, double montant) {
		
	}
}
