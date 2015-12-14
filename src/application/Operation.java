package application;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 * Classe permettant de gérer les différentes opérations
 * 
 * @author Quentin
 * 
 */
public class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7631545766176103232L;
	private String compte;
	private String client;
	private Date dateOperation;
	private double montant;
	private TypeOperation type;
	private DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

	/**
	 * Constructeur par défaut de la classe Operation
	 */
	public Operation() {

	}

	/**
	 * Constructeur de la classe Operation
	 * 
	 * @param dateOperation
	 *            : date de l'opération
	 * @param montant
	 *            : montant de l'opéartion
	 * @param type
	 *            : type de l'oprération
	 */
	public Operation(Date dateOperation, double montant, TypeOperation type) {
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
	}

	/**
	 * Constructeur de la classe Operation
	 * 
	 * @param dateOperation
	 *            : date de l'opération
	 * @param montant
	 *            : montant de l'opéartion
	 * @param type
	 *            : type de l'oprération
	 *
	 * @param compte
	 *            : compte du client
	 * 
	 * @param client
	 *            : client 
	 */
	public Operation(String compte, String client, Date dateOperation, double montant, TypeOperation type) {
		this.setCompte(compte);
		this.setClient(client);
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
	}

	/**
	 * Getter permettant de connaitre la date de l'opération
	 * 
	 * @return la date de l'opération
	 */
	public Date getDateOperation() {
		return dateOperation;
	}

	/**
	 * Setter permettant de définir la date de l'opération
	 * 
	 * @param dateOperation
	 *            : date à définir
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * Getter permettant de connaitre le montant de l'opération
	 * 
	 * @return montant de l'opération
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter permettant de définir le montant de l'opération
	 * 
	 * @param montant
	 *            : montant à définir
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Getter permettant de connaitre le type de l'opération
	 * 
	 * @return le type de l'opération
	 */
	public TypeOperation getType() {
		return type;
	}

	/**
	 * Setter permettant de définir le type de l'opération
	 * 
	 * @param type
	 *            : type à définir
	 */
	public void setType(TypeOperation type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return shortDateFormat.format(this.dateOperation) + " ; " + this.montant + " ; " + this.type;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the compte
	 */
	public String getCompte() {
		return compte;
	}

	/**
	 * @param compte
	 *            the compte to set
	 */
	public void setCompte(String compte) {
		this.compte = compte;
	}

}
