package modele;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Classe permettant de créer une personne
 * 
 * @author Quentin
 * 
 */

public abstract class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7292297928039732026L;
	private final double DECOUVERT_AUTORISE;
	private int nbCompte;
	private String numero;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private ArrayList<Compte> compteBancaires = new ArrayList<Compte>();

	@SuppressWarnings("unused")
	private DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
			DateFormat.SHORT, DateFormat.SHORT);

	/**
	 * Constructeur par défaut de la classe personne
	 */
	public Client() {
		this.DECOUVERT_AUTORISE = 0.0;
	}

	/**
	 * Constructeur de la classe personne
	 * 
	 * @param num
	 *            : numéro de la personne
	 * @param nom
	 *            : nom de la personne
	 * @param prenom
	 *            : prénom de la personne
	 * @param age
	 *            : âge de la personne
	 * @param mail
	 *            : mail de la personne
	 */
	@SuppressWarnings("resource")
	public Client(String num, String nom, String prenom, int age, String mail,
			double decouv) {

		this.DECOUVERT_AUTORISE = decouv;
		this.nbCompte = 1;

		while (!verifFormatNumeroDeCompte(num)) {
			System.err.println("Numéro de compte non valide pour " + nom + " "
					+ prenom + " ! \n Format : GP.xxNNNNN");
			System.out.println("Saisir un numero de compte valide : ");
			Scanner sc = new Scanner(System.in);
			num = sc.next();
		}

		this.numero = num;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = mail;
	}

	/**
	 * Fonction permettant de savoir si un caractère est en minuscule en se
	 * basant sur les caractères acsii
	 * 
	 * @param c
	 *            : le caractère à vérifier
	 * @return Vrai si c'est une minuscule, et faux sinon
	 */
	public static boolean estMinusculeCaractere(char c) {
		if (c < 123 && c > 96) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Fonction permettant de savoir si un caractère est un chiffre
	 * 
	 * @param c
	 *            : le caractère à vérifier
	 * @return Vrai si c'est un chiffre, faux sinon
	 */
	public static boolean estMinusculeChiffre(char c) {
		if (c < 58 && c > 47) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Fonction permettant de vérifier le format d'un numéro de compte.
	 * 
	 * @param num
	 *            : le numéro de compte a vérifier
	 * @return Vrai si le numéro à le bon format (GP.fd12345), faux sinon
	 */
	public static boolean verifFormatNumeroDeCompte(String num)
			throws IllegalArgumentException {
		if (num.length() == 10) {
			if (num.charAt(0) == 'G' && num.charAt(1) == 'P'
					&& num.charAt(2) == '.') {
				if (estMinusculeCaractere(num.charAt(3))
						&& estMinusculeCaractere(num.charAt(4))) {
					if (estMinusculeChiffre(num.charAt(5))
							&& estMinusculeChiffre(num.charAt(6))
							&& estMinusculeChiffre(num.charAt(7))
							&& estMinusculeChiffre(num.charAt(8))
							&& estMinusculeChiffre(num.charAt(9))) {
						return true;

					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Procédure permettant d'ajouter un compte bancaire à la liste des compte
	 * de la personne
	 * 
	 * @param cb
	 *            : le compte bancaire à ajouter
	 */
	public void addCompteBancaire(Compte cb) {
		this.compteBancaires.add(cb);
		this.nbCompte++;
	}

	/**
	 * Procédure permettant de créer un nouveau compte bancaire par défaut (avec
	 * un montant = 100€)
	 * 
	 * @param n
	 *            : numéro du compte bancaire à créer
	 */
	public void nouveauCompte(String n) {
		Compte cb = new Compte(100.0, n, new Date());
		addCompteBancaire(cb);
	}

	/**
	 * Procédure permettant de créer un nouveau compte bancaire
	 * 
	 * @param solde
	 *            : solde du compte bancaire
	 * @param n
	 *            : numéro du compte bancaire
	 */
	public void nouveauCompte(Double solde, String n) {
		Compte cb = new Compte(solde, n, new Date());
		addCompteBancaire(cb);
	}

	/**
	 * Procédure permettant de visualiser l'ensembre des comptes bancaires de la
	 * personne
	 */
	public void visualiserCompte() {
		System.out.println("\t Visualisation des comptes de " + this.prenom
				+ " " + this.nom);
		Iterator<Compte> listeCompte = this.getCompteBancaires().iterator();
		while (listeCompte.hasNext()) {
			Compte cb = listeCompte.next();
			System.out.println(cb);
		}
	}

	/**
	 * Getter permettant de connaitre le nombre de compte bancaire
	 * 
	 * @return le nombre de compte bancaire d'une personne
	 */
	public int getNbCompte() {
		return nbCompte;
	}

	/**
	 * Setter du nombre de compte bancaire
	 * 
	 * @param nbCompte
	 *            : le nombre de compte que possède la personne
	 */
	public void setNbCompte(int nbCompte) {
		this.nbCompte = nbCompte;
	}

	/**
	 * Getter permettant de connaitre le nom de la personne
	 * 
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter perttant de définir le nom de la personne
	 * 
	 * @param nom
	 *            : nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter permettant de connaitre le prï¿½nom de la personne
	 * 
	 * @return le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter permettant de définir le prénom de la personne
	 * 
	 * @param prenom
	 *            : prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter permettant de connaitre le l'âge de la personne
	 * 
	 * @return l'âge de la personne
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter permettant de dâfinir l'âge de la personne
	 * 
	 * @param age
	 *            : l'âge de la personne
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter permettant de connaitre la liste ds compte bancaire de la personne
	 * 
	 * @return la liste des compte bancaire de la personne
	 */
	public ArrayList<Compte> getCompteBancaires() {
		return compteBancaires;
	}

	/**
	 * Setter permettant de définir la liste des comptes bancaire de la personne
	 * 
	 * @param compteBancaires
	 *            : liste des compte bancaire de la personne de la personne
	 */

	public void setCompteBancaires(ArrayList<Compte> compteBancaires) {

		this.compteBancaires = compteBancaires;
	}

	/**
	 * Getter permettant de connaitre le numéro de la personne
	 * 
	 * @return le numéro de la personne
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Setter permettant de définir le numï¿½ro de la personne
	 * 
	 * @param numero
	 *            : numéro de la personne
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Getter permettant de connaitre l'email de la personne
	 * 
	 * @return l'email de la personne
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter permettant de définir l'email de la personne
	 * 
	 * @param email
	 *            : email de la personne
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.numero + " - " + this.nom + " " + this.prenom + " - "
				+ this.age + " ans - " + this.email;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (age != other.age)
			return false;
		if (compteBancaires == null) {
			if (other.compteBancaires != null)
				return false;
		} else if (!compteBancaires.equals(other.compteBancaires))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nbCompte != other.nbCompte)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	/**
	 * @return the dECOUVERT_AUTORISE
	 */
	public double getDECOUVERT_AUTORISE() {
		return DECOUVERT_AUTORISE;
	}
	
	public abstract double getMontantAbonnement();

}
