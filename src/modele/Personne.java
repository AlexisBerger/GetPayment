package modele;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe permettant de créer une personne
 * 
 * @author Quentin
 * 
 */
public class Personne {

	private int nbCompte;
	private String numero;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private ArrayList<CompteBancaire> compteBancaires = new ArrayList<CompteBancaire>();

	/**
	 * Constructeur par défaut de la classe personne
	 */
	public Personne() {

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
	public Personne(String num, String nom, String prenom, int age, String mail) {
		this.nbCompte = 1;
		if(verifFormatNumeroDeCompte(num)){
			this.numero = num;
		}else{
			System.err.println("Numéro de compte non valide ! \n Format : GP.xxNNNNN");
		}
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = mail;
	}

	public static boolean estMinusculeCaractere(char c) {
		// Mettre les bonnes valeur ACSI
		if (c < 25 && c > 42) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean estMinusculeChiffre(char c) {
		// Mettre les bonnes valeur ACSI
		if (c < 25 && c > 42) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean verifFormatNumeroDeCompte(String num) {
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
	public void addCompteBancaire(CompteBancaire cb) {
		this.compteBancaires.add(cb);
		this.nbCompte++;
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
	 * Getter permettant de connaitre le prénom de la personne
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
	 * Setter permettant de définir l'âge de la personne
	 * 
	 * @param age
	 *            : âge de la personne
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter permettant de connaitre la liste ds compte bancaire de la personne
	 * 
	 * @return la liste des compte bancaire de la personne
	 */
	public ArrayList<CompteBancaire> getCompteBancaires() {
		return compteBancaires;
	}

	/**
	 * Setter permettant de définir la liste des comptes bancaire de la personne
	 * 
	 * @param compteBancaires
	 *            : liste des compte bancaire de la personne de la personne
	 */
	public void setCompteBancaires(ArrayList<CompteBancaire> compteBancaires) {
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
	 * Setter permettant de définir le numéro de la personne
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

	/**
	 * Procédure permettant de créer un nouveau compte bancaire par défaut (avec
	 * un montant = 100€)
	 * 
	 * @param n
	 *            : numéro du compte bancaire à créer
	 */
	public void nouveauCompte(String n) {
		CompteBancaire cb = new CompteBancaire(100.0, n);
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
		CompteBancaire cb = new CompteBancaire(solde, n);
		addCompteBancaire(cb);
	}

	/**
	 * Procédure permettant de visualiser l'ensembre des comptes bancaires de la
	 * personne Visualisation des comptes de Quentin Doucet Le compte A a 1000.0
	 * € Le compte B a 100.0 € Le compte C a 100.0 €
	 */
	public void visualiserCompte() {
		System.out.println("\t Visualisation des comptes de " + this.prenom
				+ " " + this.nom);
		Iterator<CompteBancaire> listeCompte = this.getCompteBancaires()
				.iterator();
		while (listeCompte.hasNext()) {
			CompteBancaire cb = listeCompte.next();
			System.out.println(cb);
		}
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
		Personne other = (Personne) obj;
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

}
