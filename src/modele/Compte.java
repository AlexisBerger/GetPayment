package modele;

import java.util.ArrayList;
import java.util.Date;

import Exception.SoldeNegatifException;
import application.Operation;
import application.TypeOperation;

public class Compte {

	private final Double soldeDeBase = 100.00;
	private String numeroDeCompte;
	private Double solde;
	private Date dateCreation;
	private ArrayList<Operation> tabOperations;
	/**
	 * Constructeur par d�faut de la classe Compte
	 */
	public Compte() {

	}

	/**
	 * Constructeur de la classe CompteBancaire
	 * 
	 * @param montantInit
	 *            : montant initial du compte bancaire
	 * @param num
	 *            : num�ro du compte bancaire
	 */

	public Compte(Double montantInit, String num, Date d) {
		if (montantInit < this.soldeDeBase) {
			this.solde = this.soldeDeBase;
		} else {
			this.solde = montantInit;
		}
		this.setNumeroDeCompte(num);
		this.setDateCreation(d);
		this.tabOperations = new ArrayList<Operation>();
	}

	/**
	 * Proc�dure permettant d'ajouter un montant � un compte bancaire
	 * 
	 * @param montant
	 *            : montant � ajouter (>=0)
	 */
	public void ajouterMontant(Double montant) {
		if (montant > 0) {
			this.solde += montant;
            ajouterOperation(new Operation(new Date(),montant, TypeOperation.CREDITE));
		}
	}

    /**
     * operation a jouter a l'historique
     * @param operation a ajouter
     */
    public void ajouterOperation(Operation operation){
        tabOperations.add(operation);
    }

	/**
	 * Proc�dure permettant de retirer un montant � un compte bancaire
	 * 
	 * @param montant
	 *            : montant � retirer (>=0)
	 * @throws SoldeNegatifException
	 *             : exeception lanc�e si le solde � retirer est plus grand que
	 *             les fonds du compte
	 */
	public void RetirerMontant(Double montant) throws SoldeNegatifException {
		if (montant > this.solde) {
			throw new SoldeNegatifException(
					"Le montant à retirer est trop important, les fonds ne sont pas suffisant ! ");
		} else {
			if (montant > 0.0) {
				this.solde -= montant;
                ajouterOperation(new Operation(new Date(),montant, TypeOperation.DEBITE));

            }
		}
	}

    /**
     * Permet d'afficher l'historique
     */
    public void visualiserHistorique(){
        //TODO implementer
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
	 * Getter permettant de connaitre le num�ro du compte bancaire
	 * 
	 * @return le num�ro du compte bancaire
	 */
	public String getNumeroDeCompte() {
		return numeroDeCompte;
	}

	/**
	 * Setter permettant de d�finir le num�ro du compte bancaire
	 * 
	 * @param numeroDeCompte
	 *            : num�ro du compte bancaire � d�finir
	 */
	public void setNumeroDeCompte(String numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	@Override
	public String toString() {
		return "Le compte " + this.getNumeroDeCompte() + " a "
				+ this.getSolde() + " €";

	}

	/**
	 * Getter permettant de connaitre la date de cr�ation
	 * 
	 * @return the dateCr�ation
	 */

	public Date getDateCreation() {

		return dateCreation;
	}

	/**
	 * Setter permettant de d�finir la date de cr�ation
	 * 
	 * @param dateCreation
	 *            the dateCr�ation to set
	 */

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;

	}

}
