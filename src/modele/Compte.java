package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
	 * Constructeur par dï¿½faut de la classe Compte
	 */
	public Compte() {

	}

	/**
	 * Constructeur de la classe CompteBancaire
	 * 
	 * @param montantInit
	 *            : montant initial du compte bancaire
	 * @param num
	 *            : numï¿½ro du compte bancaire
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
	 * Procï¿½dure permettant d'ajouter un montant ï¿½ un compte bancaire
	 * 
	 * @param montant
	 *            : montant ï¿½ ajouter (>=0)
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
	 * Procï¿½dure permettant de retirer un montant ï¿½ un compte bancaire
	 * 
	 * @param montant
	 *            : montant ï¿½ retirer (>=0)
	 * @throws SoldeNegatifException
	 *             : exeception lancï¿½e si le solde ï¿½ retirer est plus grand que
	 *             les fonds du compte
	 */
	public void RetirerMontant(Double montant) throws SoldeNegatifException {
		if (montant > this.solde) {
			throw new SoldeNegatifException(
					"Le montant Ã  retirer est trop important, les fonds ne sont pas suffisant ! ");
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
        Iterator<Operation> it = tabOperations.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
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
	 * Getter permettant de connaitre le numï¿½ro du compte bancaire
	 * 
	 * @return le numï¿½ro du compte bancaire
	 */
	public String getNumeroDeCompte() {
		return numeroDeCompte;
	}

	/**
	 * Setter permettant de dï¿½finir le numï¿½ro du compte bancaire
	 * 
	 * @param numeroDeCompte
	 *            : numï¿½ro du compte bancaire ï¿½ dï¿½finir
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
	 * Getter permettant de connaitre la date de crï¿½ation
	 * 
	 * @return the dateCrï¿½ation
	 */

	public Date getDateCreation() {

		return dateCreation;
	}

	/**
	 * Setter permettant de dï¿½finir la date de crï¿½ation
	 * 
	 * @param dateCreation
	 *            the dateCrï¿½ation to set
	 */

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;

	}

}
