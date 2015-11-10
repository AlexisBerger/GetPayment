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

	public Personne(){
		
	}
	
	public Personne(int num, String nom, String prenom, int age, String mail) {
		this.nbCompte = 1;
		this.numero = num;
		this.nom = nom; 
		this.prenom = prenom; 
		this.age = age;
		this.email = mail;
	}
	
	
	public void addCompteBancaire(CompteBancaire cb){
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
	
	public void nouveauCompte(String n) {
		CompteBancaire cb = new CompteBancaire(100.0, n);
		addCompteBancaire(cb);
	}

	public void nouveauCompte(Double solde, String n) {
		CompteBancaire cb = new CompteBancaire(solde, n);
		addCompteBancaire(cb);
	}
	
	public void visualiserCompte(){
		System.out.println("\t Visualisation des comptes de "+this.prenom+" "+this.nom);
		Iterator<CompteBancaire> listeCompte = this.getCompteBancaires().iterator();
		while(listeCompte.hasNext()){
			CompteBancaire cb = listeCompte.next();
			System.out.println(cb);
		}
	}
	
	@Override
	public String toString(){
		return this.nom;
		
	}
	
	

}
