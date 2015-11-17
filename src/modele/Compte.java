package modele;

import java.util.Date;

import Exception.SoldeNegatifException;

public class Compte {

	private final Double soldeDeBase = 100.00;
	private String numeroDeCompte;
	private Double solde;
	private Date dateCréation;

	/**
	 * Constructeur par défaut de la classe Compte
	 */
	public Compte() {

	}

	/**
	 * Constructeur de la classe CompteBancaire
	 * 
	 * @param montantInit
	 *            : montant initial du compte bancaire
	 * @param num
	 *            : numéro du compte bancaire
	 */

	public Compte(Double montantInit, String num, Date d) {
		if (montantInit < this.soldeDeBase) {
			this.solde = this.soldeDeBase;
		} else {
			this.solde = montantInit;
		}
		this.setNumeroDeCompte(num);
		this.setDateCréation(d);
	}

	/**
	 * Procédure permettant d'ajouter un montant à un compte bancaire
	 * 
	 * @param montant
	 *            : montant à ajouter (>=0)
	 */
	public void ajouterMontant(Double montant) {
		if (montant > 0) {
			this.solde += montant;
		}
	}

	/**
	 * Procédure permettant de retirer un montant à un compte bancaire
	 * 
	 * @param montant
	 *            : montant à retirer (>=0)
	 * @throws SoldeNegatifException
	 *             : exeception lancée si le solde à retirer est plus grand que
	 *             les fonds du compte
	 */
	public void RetirerMontant(Double montant) throws SoldeNegatifException {
		if (montant > this.solde) {
			throw new SoldeNegatifException(
					"Le montant Ã  retirer est trop important, les fonds ne sont pas suffisant ! ");
		} else {
			if (montant > 0.0) {
				this.solde -= montant;
			}
		}
	}

	/**
	 * Getter permettant de connaitre le solde du compte bancaire
	 * 
	 * @return le solde du compte
	 */
	public Double getSolde() {
		return this.solde;
	}

	/**
	 * Getter permettant de connaitre le numéro du compte bancaire
	 * 
	 * @return le numéro du compte bancaire
	 */
	public String getNumeroDeCompte() {
		return numeroDeCompte;
	}

	/**
	 * Setter permettant de définir le numéro du compte bancaire
	 * 
	 * @param numeroDeCompte
	 *            : numéro du compte bancaire à définir
	 */
	public void setNumeroDeCompte(String numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	@Override
	public String toString() {
		return "Le compte " + this.getNumeroDeCompte() + " a "
				+ this.getSolde() + " â‚¬";

	}

	/**
	 * Getter permettant de connaitre la date de création
	 * 
	 * @return the dateCréation
	 */
	public Date getDateCréation() {
		return dateCréation;
	}

	/**
	 * Setter permettant de définir la date de création
	 * 
	 * @param dateCréation
	 *            the dateCréation to set
	 */
	public void setDateCréation(Date dateCréation) {
		this.dateCréation = dateCréation;
	}

}
