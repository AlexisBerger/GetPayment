package tp01;

public class CompteBancaire {

	private final Double soldeDeBase = 100.00;
	private String numeroDeCompte;
	private Double solde;

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

	public void RetirerMontant(Double montant) {
		if (montant > this.solde) {
			System.err.println("Le montant à retirer est trop important, les fonds ne sont pas suffisant ! ");
		} else {
			if (montant > 0) {
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
