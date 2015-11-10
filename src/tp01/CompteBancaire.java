package tp01;

import Exception.SoldeNegatifException;

public class CompteBancaire {

	private final Double soldeDeBase = 100.00;
	private String numeroDeCompte;
	private Double solde;

	public CompteBancaire(){
		
	}
	
	public CompteBancaire(Double montantInit, String num) {
		if (montantInit < this.soldeDeBase) {
			this.solde = this.soldeDeBase;
		} else {
			this.solde = montantInit;
		}
		this.setNumeroDeCompte(num);
	}

	public void ajouterMontant(Double montant) {
		if (montant > 0) {
			this.solde += montant;
		}
	}

	public void RetirerMontant(Double montant)throws SoldeNegatifException {
		if (montant > this.solde) {
			throw new SoldeNegatifException("Le montant à retirer est trop important, les fonds ne sont pas suffisant ! ");
		} else {
			if (montant > 0.0) {
				this.solde -= montant;
			}
		}
	}

	public Double getSolde() {
		return this.solde;
	}

	public String getNumeroDeCompte() {
		return numeroDeCompte;
	}

	public void setNumeroDeCompte(String numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	@Override
	public String toString() {
		return "Le compte "+this.getNumeroDeCompte() + " a " + this.getSolde()+" €";

	}

}
