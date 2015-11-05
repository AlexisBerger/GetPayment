package tp01;

import java.util.Iterator;
import java.util.Scanner;

public class TestFilRouge {

	public static void main(String[] args) {


			Personne p = new Personne("Jacques", "DUMONT", 60);
			p.nouveauCompte(1000.00, "A");
			p.nouveauCompte(100.0, "B");
			p.nouveauCompte(10.0, "C");

			Iterator<CompteBancaire> it;

			String num;
			CompteBancaire compteSelect = null;
		while(true) {
			Menu m = new Menu();
			Scanner sc = new Scanner(System.in);
			int nb = 5;
			if (sc.hasNextInt()) {
				nb = sc.nextInt();
			} else {
				System.err.println("Il faut saisir un nombre !");
			}

			switch (nb) {
				case 1:
					p.visualiserCompte();
					break;
				case 2:
					sc = new Scanner(System.in);
					it = p.getCompteBancaires().iterator();
					System.out.println("Veiller saisir le numero de compte a utilisé :");

					num = sc.nextLine();
					compteSelect = null;

					while (it.hasNext()) {
						CompteBancaire compte = it.next();
						if (compte.getNumeroDeCompte().equals(num)) {
							compteSelect = compte;
							break;
						}
					}
					if (compteSelect == null) {
						System.out.println("veiller saisir un compte valide");
					} else {
						sc = new Scanner(System.in);
						System.out.println("Combien voulai vous retirer ?");
						if (sc.hasNextDouble()) {

							compteSelect.RetirerMontant(sc.nextDouble());
						}
					}

					break;
				case 3:
					sc = new Scanner(System.in);
					it = p.getCompteBancaires().iterator();
					System.out.println("Veiller saisir le numero de compte a utilisé :");
					num = sc.nextLine();
					compteSelect = null;

					while (it.hasNext()) {
						CompteBancaire compte = it.next();
						if (compte.getNumeroDeCompte().equals(num)) {
							compteSelect = compte;
							break;
						}
					}
					if (compteSelect == null) {
						System.out.println("Veuillez saisir un compte valide");
					} else {
						sc = new Scanner(System.in);
						System.out.println("Combien voulai vous ajouter?");
						if (sc.hasNextDouble()) {
							compteSelect.ajouterMontant(sc.nextDouble());
						}
					}
					break;
				case 4:

					break;
				case 5:
					System.out.println("Saisir numero de compte : ");
					sc = new Scanner(System.in);
					String numCompte = sc.next();
					System.out.println("Saisir solde du compte : ");
					sc = new Scanner(System.in);
					if (sc.hasNextDouble()) {
						Double solde = sc.nextDouble();
						p.nouveauCompte(solde,numCompte);
						System.out.println("Compte cree");
					}else{
						System.out.println("Veuillez saisir un nombre!!!!");
					}

					break;
				case 6:
					System.exit(0);
					break;

			}
		}
	}
}
