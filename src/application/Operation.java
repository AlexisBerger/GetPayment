package application;

import java.util.Date;

/**
 * Classe permettant de gérer les différentes opérations
 * 
 * @author Quentin
 * 
 */
public class Operation {

	private Date dateOperation;
	private double montant;
	private TypeOperation type;

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
		return this.dateOperation + " ; " + this.montant + " ; " + this.type;
	}

}
