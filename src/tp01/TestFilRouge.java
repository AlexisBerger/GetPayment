package tp01;

import java.util.Iterator;
import java.util.Scanner;

import Exception.NombreDeCompteTropEleveException;
import Exception.SoldeNegatifException;

public class TestFilRouge {

	public static void main(String[] args) {
		System.out.println("\t \t Bienvenue dans la gestion de votre compte Bancaire");
		System.out.println("Aprennons d'abord a nous connaitre \nVous êtes (Nom + Prénom) ? ");
		Scanner sc = new Scanner(System.in);
		String pers = sc.nextLine();
		String tab[] = pers.split("\\s");

		try {

			System.out.println(
					"Bien " + tab[1] + " " + tab[0] + ", sans indiscrétion pourrais-je connaitre votre âge ? ");

			int age = -1;
			while (age < 0) {
				sc = new Scanner(System.in);
				if (sc.hasNextInt()) {
					age = sc.nextInt();
				} else {
					System.out.println("Faites un petit effort :) ");
				}
			}

			Personne p = new Personne(tab[1], tab[0], age);
			p.nouveauCompte(1000.00, "A");
			p.nouveauCompte(100.0, "B");
			p.nouveauCompte(10.0, "C");

			Iterator<CompteBancaire> it;

			String num;
			CompteBancaire compteSelect = null;
			while (true) {
				Menu m = new Menu();
				sc = new Scanner(System.in);
				int nb = 0;
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
					System.out.println("Veillez saisir le numero de compte à utiliser :");

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
						System.out.println("veillez saisir un compte valide");
					} else {
						sc = new Scanner(System.in);
						System.out.println("Combien voulez-vous retirer ?");
						if (sc.hasNextDouble()) {

							try {
								compteSelect.RetirerMontant(sc.nextDouble());
							} catch (SoldeNegatifException e) {
								e.printStackTrace();
							}
						}
					}

					break;
				case 3:
					sc = new Scanner(System.in);
					it = p.getCompteBancaires().iterator();
					System.out.println("Veillez saisir le numero de compte a utiliser :");
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
						System.out.println("Combien voulez-vous ajouter ?");
						if (sc.hasNextDouble()) {
							compteSelect.ajouterMontant(sc.nextDouble());
						}
					}
					break;
				case 4:

					break;
				case 5:
					if (p.getNbCompte() <= 10) {
						System.out.println("Saisir numero de compte : ");
						sc = new Scanner(System.in);
						String numCompte = sc.next();
						System.out.println("Saisir solde du compte : ");
						sc = new Scanner(System.in);
						if (sc.hasNextDouble()) {
							Double solde = sc.nextDouble();
							p.nouveauCompte(solde, numCompte);
							System.out.println("Compte créé");
						} else {
							System.out.println("Veuillez saisir un nombre!!!!");
						}
					} else {
						try {
							throw new NombreDeCompteTropEleveException(
									"Vous possédez déjà le nombre maximal de compte bancaire.");
						} catch (NombreDeCompteTropEleveException e) {
							e.printStackTrace();
						}
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.err.println("Vous avez saisie n'importe quoi ! Try again ");
					break;

				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Il faut saisir le nom ET le prénom pour l'ouverture d'un compte bancaire. \nRechargez l'application");
		}
	}
}
