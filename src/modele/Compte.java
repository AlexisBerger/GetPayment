package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import Exception.OperationException;
import application.Operation;
import application.TypeOperation;

/**
 * Class permettan de cr�er un compte bancaire
 * 
 * @author Quentin
 * 
 */
public class Compte implements Serializable{

	private final Double soldeDeBase = 100.00;
	private String numeroDeCompte;
	private Double solde;
	private Date dateCreation;
	private Double decouvert = 0.0;
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
			ajouterOperation(new Operation(new Date(), montant,
					TypeOperation.CREDITE));
		}
	}

	/**
	 * operation a ajouter a l'historique
	 * 
	 * @param operation
	 *            a ajouter
	 */
	public void ajouterOperation(Operation operation) {
		tabOperations.add(operation);
	}

	/**
	 * Proc�dure permettant de retirer un montant � un compte bancaire
	 * 
	 * @param montant
	 *            : montant � retirer (>=0)
	 * @throws OperationException
	 *             : exeception lanc�e si le solde � retirer est plus grand
	 *             que les fonds du compte
	 */
	public void RetirerMontant(double montant, double decouvert_autorise)
			throws OperationException {
		if (montant > this.solde + decouvert_autorise) {
			throw new OperationException(
					"Le montant � retirer est trop important, les fonds ne sont pas suffisant ! ");
		} else {
			if (montant > this.solde) {
				this.decouvert = montant - this.solde;
				this.solde = 0.0;
				System.err.println("Attention vous avez un d�couvert");
				ajouterOperation(new Operation(new Date(), montant,
						TypeOperation.DEBITE));

			} else {
				if (montant > 0.0) {
					this.solde -= montant;
					ajouterOperation(new Operation(new Date(), montant,
							TypeOperation.DEBITE));
				}
			}

		}
	}

	/**
	 * Fonction permettant de connaitre le nombre d'op�ration effectu�es sur un
	 * compte
	 * 
	 * @return le nombre d'op�ration sur un compte
	 */
	public int getNbOperation() {
		return this.tabOperations.size();
	}

	/**
	 * Permet d'afficher l'historique
	 */
	public void visualiserHistorique() {
		Iterator<Operation> it = tabOperations.iterator();
		while (it.hasNext()) {
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
				+ this.getSolde() + " � | D�couvert : " + this.decouvert + " �";

	}

	/**
	 * Getter permettant de connaitre la date de cr�ation
	 * 
	 * @return the dateCreation
	 */

	public Date getDateCreation() {

		return dateCreation;
	}

	/**
	 * Setter permettant de d�finir la date de cr�ation
	 * 
	 * @param dateCreation
	 *            the dateCreation to set
	 */

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;

	}

}
