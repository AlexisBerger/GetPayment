package application;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Exception.NombreDeCompteTropEleveException;
import Exception.OperationException;
import modele.ClientParticulier;
import modele.ClientProfessionnel;
import modele.Compte;
import modele.Client;

/**
 * Classe permettant de gérer les méthodes de l'application
 * 
 * @author Quentin
 * 
 */
public class Application {

	private ArrayList<Client> tabClients = new ArrayList<Client>();

	/**
	 * Constructeur par défaut la classe Application
	 */
	public Application() {

	}

	/**
	 * Procédure permettant de lancer/démarrer l'application
	 */
	public void demarrer() {
		System.out
				.println("\t \t Bienvenue dans la gestion de votre compte Bancaire");
		File monfichier = new File("monfichier.dat");
		if (monfichier.exists()) {
			FileInputStream fichier = null;
			ObjectInputStream oos = null;
			try {
				fichier = new FileInputStream("monFichier.dat");
				oos = new ObjectInputStream(fichier);
				Object read;
				while ((read = oos.readObject()) != null) {
					if (read instanceof ClientProfessionnel) {
						this.tabClients.add((ClientProfessionnel) read);
					} else if (read instanceof ClientParticulier) {
						this.tabClients.add((ClientParticulier) read);
					} else {
						System.out.println("Erreur");
					}
				}

			} catch (IOException e) {
				System.out.println("Arrivé à la fin du fichier");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Erreur de classe");
			} finally {
				try {
					oos.close();
					fichier.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			menu2();
		} else {
			System.out
					.println("Aprennons d'abord a nous connaitre \nVous êtes (Nom + Prénom) ? ");
			Scanner sc = new Scanner(System.in);
			String pers = sc.nextLine();
			String tab[] = pers.split("\\s");

			try {

				System.out
						.println("Bien "
								+ tab[1]
								+ " "
								+ tab[0]
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

				Client p = new ClientProfessionnel("P."
						+ tab[0].toLowerCase().charAt(0)
						+ tab[1].toLowerCase().charAt(0) + "12345", tab[0],
						tab[1], age, "tot@mail.fr", "Orange", 123459679);

				p.nouveauCompte(1000.00, "A");
				p.nouveauCompte(100.0, "B");
				p.nouveauCompte(10.0, "C");

				Client p1 = new ClientParticulier("GP.aj98765", "AiMARRE",
						"Jean", 12, "AiMARRE@mail.fr");
				p1.nouveauCompte(1000.00, "A");
				p1.nouveauCompte(100.0, "B");
				p1.nouveauCompte(10.0, "C");

				Client p2 = new ClientParticulier("GP.ch98765", "COVERT",
						"Harry", 14, "COVERT@mail.fr");
				p2.nouveauCompte(1000.00, "A");
				p2.nouveauCompte(100.0, "B");
				p2.nouveauCompte(10.0, "C");

				this.aouterClient(p);
				this.aouterClient(p1);
				this.aouterClient(p2);
				menu2();

			} catch (IndexOutOfBoundsException e) {
				System.out
						.println("Il faut saisir le nom ET le prénom pour l'ouverture d'un compte bancaire. \nRechargez l'application");
			}

		}

	}

	public void menu2() {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		do {
			res = menu();

			switch (res) {
			case 1:
				for (Client tpers : this.tabClients) {
					tpers.visualiserCompte();
				}
				break;
			case 2:
				String numeroClient = null;
				do {
					numeroClient = selectClient();
					if (recupererClient(numeroClient) == null) {
						System.err
								.println("Le numéro de client n'existe pas !\n");
					}
				} while (recupererClient(numeroClient) == null);
				int nb = 0;
				do {
					System.out.println();
					System.out.println("\t1. Voir le solde du compte");
					System.out.println("\t2. Retirer un montant");
					System.out.println("\t3. Faire un apport");
					System.out.println("\t4. Afficher historique");
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

			case 3:
				File f = new File("monFichier.csv");
				CSV csv = new CSV(f);
				for (ArrayList<Operation> op : csv) {
					if(recupererClient(op.getClient()) != null){
						
					}
				}
				
				
				break;
			case 4:
				try {
					FileOutputStream fichier = new FileOutputStream(
							"monFichier.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fichier);
					for (Client client : tabClients) {
						oos.writeObject(client);
					}
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Erreur de fichier");
				}
				break;

			default:
				break;
			}
		} while (res != 4);
	}

	/**
	 * Fonction permettant d'afficher le menu principal et de faire saisir un
	 * choix à l'utilisateur
	 * 
	 * @return le choix de l'utilisateur (entre 1 et 3)
	 */
	public int menu() {
		System.out.println("-->");
		System.out.println("1. Afficher tous les clients et leurs comptes.");
		System.out.println("2. Faire une opération sur le compte d’un client.");
		System.out.println("3. Faire des opérations à partir d'un fichier.");
		System.out.println("4. Quitter.");
		System.out.println("Saisir votre choix : ");
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			int c = sc.nextInt();
			return c;
		} else {
			return -1;
		}

	}

	/**
	 * Procédure permettant d'ajouter un nouveau client
	 * 
	 * @param p
	 *            : personne à ajouter dans la liste des clients.
	 */
	public void aouterClient(Client p) {
		this.tabClients.add(p);
	}

	/**
	 * Fonction permettant de récupérer un client à partir de son numéro
	 * 
	 * @param num
	 *            : numéro de la personne à rechercher
	 * @return la personne si son numéro existe, null sinon.
	 */

	public Client recupererClient(String num) {
		for (Client p : tabClients) {
			if (p.getNumero().equals(num)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Fonction permettant de saisir un numéro de client à partir d'une liste
	 * qui est affichée à l'utilisateur
	 * 
	 * @return le numéro saisir par l'utilisateur, -1
	 */
	public String selectClient() {
		for (Client p : this.tabClients) {
			System.out.println(p);
		}
		System.out.println("Saisir le numéro du client :");
		Scanner sc = new Scanner(System.in);
		return sc.next();

	}

	/**
	 * Procédure permettant de faire une opération en fonction d'un client et
	 * d'un numéro correspondant à une action
	 * 
	 * @param p
	 *            : personne dont on veut agir sur les comptes
	 * @param nb
	 *            : numéro de l'action
	 */

	public void faireOperation(Client p, int nb) {
		Iterator<Compte> it;

		String num;
		Compte compteSelect = null;

		switch (nb) {
		case 1:
			p.visualiserCompte();
			break;
		case 2:
			Scanner sc = new Scanner(System.in);
			it = p.getCompteBancaires().iterator();
			System.out
					.println("Veuillez saisir le numero de compte à utiliser :");

			num = sc.nextLine();
			compteSelect = null;

			while (it.hasNext()) {
				Compte compte = it.next();
				if (compte.getNumeroDeCompte().equals(num)) {
					compteSelect = compte;
					break;
				}
			}
			if (compteSelect == null) {
				System.out.println("Veuillez saisir un compte valide");
			} else {
				sc = new Scanner(System.in);
				System.out.println("Combien voulez-vous retirer ?");
				if (sc.hasNextDouble()) {

					try {
						compteSelect.RetirerMontant(sc.nextDouble(),
								p.getDECOUVERT_AUTORISE());
					} catch (OperationException e) {
						e.printStackTrace();
					}
				}
			}

			break;
		case 3:
			sc = new Scanner(System.in);
			it = p.getCompteBancaires().iterator();
			System.out
					.println("Veuillez saisir le numero de compte a utiliser :");
			num = sc.nextLine();
			compteSelect = null;

			while (it.hasNext()) {
				Compte compte = it.next();
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
			sc = new Scanner(System.in);
			it = p.getCompteBancaires().iterator();
			System.out
					.println("Veuillez saisir le numero de compte a utiliser :");
			num = sc.nextLine();
			compteSelect = null;

			while (it.hasNext()) {
				Compte compte = it.next();
				if (compte.getNumeroDeCompte().equals(num)) {
					compteSelect = compte;
					break;
				}
			}
			if (compteSelect == null) {
				System.out.println("Veuillez saisir un compte valide");
			} else {
				compteSelect.visualiserHistorique();
			}
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
