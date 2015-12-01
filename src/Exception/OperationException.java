package Exception;

/**
 * Classe permettant de g�rer le cas ou le solde du compte est n�gatif
 * 
 * @author Quentin
 * 
 */
public class OperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653601094305522393L;

	/**
	 * Constructeur par d�faut de la classe OperationException
	 */
	public OperationException() {
		super();
	}

	/**
	 * Constructeur de la classe OperationException
	 * 
	 * @param s
	 *            : chaine contenant l'erreur
	 */
	public OperationException(String s) {
		System.err.println(s);
	}
}
