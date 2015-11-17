package application;

import java.util.Date;

/**
 * Classe permettant de g�rer les diff�rentes op�rations
 * 
 * @author Quentin
 * 
 */
public class Operation {

	private Date dateOperation;
	private double montant;
	private TypeOperation type;

	/**
	 * Constructeur par d�faut de la classe Operation
	 */
	public Operation() {

	}

	/**
	 * Constructeur de la classe Operation
	 * 
	 * @param dateOperation
	 *            : date de l'op�ration
	 * @param montant
	 *            : montant de l'op�artion
	 * @param type
	 *            : type de l'opr�ration
	 */
	public Operation(Date dateOperation, double montant, TypeOperation type) {
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
	}

	/**
	 * Getter permettant de connaitre la date de l'op�ration
	 * 
	 * @return la date de l'op�ration
	 */
	public Date getDateOperation() {
		return dateOperation;
	}

	/**
	 * Setter permettant de d�finir la date de l'op�ration
	 * 
	 * @param dateOperation
	 *            : date � d�finir
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * Getter permettant de connaitre le montant de l'op�ration
	 * 
	 * @return montant de l'op�ration
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter permettant de d�finir le montant de l'op�ration
	 * 
	 * @param montant
	 *            : montant � d�finir
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Getter permettant de connaitre le type de l'op�ration
	 * 
	 * @return le type de l'op�ration
	 */
	public TypeOperation getType() {
		return type;
	}

	/**
	 * Setter permettant de d�finir le type de l'op�ration
	 * 
	 * @param type
	 *            : type � d�finir
	 */
	public void setType(TypeOperation type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.dateOperation + " ; " + this.montant + " ; " + this.type;
	}

}