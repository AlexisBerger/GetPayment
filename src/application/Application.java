package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Exception.NombreDeCompteTropEleveException;
import Exception.SoldeNegatifException;
import modele.CompteBancaire;
import modele.Personne;

public class Application {

	private ArrayList<Personne> tabClients = new ArrayList<Personne>();

	public Application() {

	}

	public void demarrer() {
		System.out
				.println("\t \t Bienvenue dans la gestion de votre compte Bancaire");
		System.out
				.println("Aprennons d'abord a nous connaitre \nVous êtes (Nom + Prénom) ? ");
		Scanner sc = new Scanner(System.in);
		String pers = sc.nextLine();
		String tab[] = pers.split("\\s");

		try {

			System.out.println("Bien " + tab[1] + " " + tab[0]
					+ ", sans indiscrétion pourrais-je connaitre votre âge ? ");

			int age = -1;
			while (age < 0) {
				sc = new Scanner(System.in);
				if (sc.hasNextInt()) {
					age = sc.nextInt();
				} else {
					System.out.println("Faites un petit effort :) ");
				}
			}

			Personne p = new Personne(1, tab[0], tab[1], age, "tot@mail.fr");
			p.nouveauCompte(1000.00, "A");
			p.nouveauCompte(100.0, "B");
			p.nouveauCompte(10.0, "C");

			Personne p1 = new Personne(2, "AiMARRE", "Jean", 12,
					"AiMARRE@mail.fr");
			p1.nouveauCompte(1000.00, "A");
			p1.nouveauCompte(100.0, "B");
			p1.nouveauCompte(10.0, "C");

			Personne p2 = new Personne(3, "COVERT", "Harry", 14,
					"COVERT@mail.fr");
			p2.nouveauCompte(1000.00, "A");
			p2.nouveauCompte(100.0, "B");
			p2.nouveauCompte(10.0, "C");
			
			this.aouterClient(p);
			this.aouterClient(p1);
			this.aouterClient(p2);

			while (true) {
				int res = menu();

				switch (res) {
				case 1:
					for (Personne tpers : this.tabClients) {
						tpers.visualiserCompte();
					}
					break;
				case 2:
					int numeroClient = selectClient();
					int nb = 0;
					do {
						System.out.println();
						System.out.println("\t1. Voir le solde du compte");
						System.out.println("\t2. Retirer un montant");
						System.out.println("\t3. Faire un apport");
						System.out.println("\t5. Ajouter un compte");
						System.out.println("\t6. Quitter");
						System.out.println();
						sc = new Scanner(System.in);

						if (sc.hasNextInt()) {
							nb = sc.nextInt();
						} else {
							System.err.println("Il faut saisir un nombre !");
						}

						faireOperation(recupererClient(numeroClient), nb);
					} while (nb != 6);
					break;

				default:
					break;
				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out
					.println("Il faut saisir le nom ET le prénom pour l'ouverture d'un compte bancaire. \nRechargez l'application");
		}

	}

	public int menu() {
		System.out.println("-->");
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

	public Personne recupererClient(int num) {
		for (Personne p : tabClients) {
			if (p.getNumero() == num) {
				return p;
			} 
		}
		return null;
	}

	public int selectClient() {
		for (Personne p : this.tabClients) {
			System.out.println(p);
		}
		System.out.println("Saisir le numéro du client :");
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			return sc.nextInt();
		} else {
			return -1;
		}

	}

	public void faireOperation(Personne p, int nb) {
		Iterator<CompteBancaire> it;
		String num;
		CompteBancaire compteSelect = null;

		switch (nb) {
		case 1:
			p.visualiserCompte();
			break;
		case 2:
			Scanner sc = new Scanner(System.in);
			it = p.getCompteBancaires().iterator();
			System.out
					.println("Veillez saisir le numero de compte à utiliser :");

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
			System.out
					.println("Veillez saisir le numero de compte a utiliser :");
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
			break;
		default:
			System.err.println("Vous avez saisie n'importe quoi ! Try again ");
			break;

		}
	}
}
