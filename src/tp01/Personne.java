package tp01;

import java.util.ArrayList;
import java.util.Iterator;

public class Personne {

	private int nbCompte;
	private int numero;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private ArrayList<CompteBancaire> compteBancaires = new ArrayList<CompteBancaire>();

	public Personne() {

	}

	public Personne(int num, String nom, String prenom, int age, String mail) {
		this.nbCompte = 1;
		this.numero = num;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = mail;
	}

	public void addCompteBancaire(CompteBancaire cb) {
		this.compteBancaires.add(cb);
		this.nbCompte++;
	}

	public int getNbCompte() {
		return nbCompte;
	}

	public void setNbCompte(int nbCompte) {
		this.nbCompte = nbCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<CompteBancaire> getCompteBancaires() {
		return compteBancaires;
	}

	public void setCompteBancaires(ArrayList<CompteBancaire> compteBancaires) {
		this.compteBancaires = compteBancaires;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void nouveauCompte(String n) {
		CompteBancaire cb = new CompteBancaire(100.0, n);
		addCompteBancaire(cb);
	}

	public void nouveauCompte(Double solde, String n) {
		CompteBancaire cb = new CompteBancaire(solde, n);
		addCompteBancaire(cb);
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((compteBancaires == null) ? 0 : compteBancaires.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + nbCompte;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numero;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
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
