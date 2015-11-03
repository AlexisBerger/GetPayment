package tp01;

import java.util.ArrayList;
import java.util.Iterator;

public class Personne {

	private int nbCompte;
	private String nom;
	private String prenom;
	private int age;
	private ArrayList<CompteBancaire> compteBancaires = new ArrayList<CompteBancaire>(); 

	public Personne(String nom, String prenom, int age) {
		this.nbCompte = 1;
		this.nom = nom; 
		this.prenom = prenom; 
		this.age = age;
	}
	
	public void addCompteBancaire(CompteBancaire cb){
		this.compteBancaires.add(cb);
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

	public void nouveauCompte(Double solde, String n) {
		CompteBancaire cb = new CompteBancaire(solde, n);
		addCompteBancaire(cb);
	}
	
	public void visualiserCompte(){
		Iterator<CompteBancaire> listeCompte = this.getCompteBancaires().iterator();
		while(listeCompte.hasNext()){
			CompteBancaire cb = listeCompte.next();
			System.out.println(cb);
		}
	}
	
	

}
