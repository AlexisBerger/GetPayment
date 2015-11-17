package Exception;

/**
 * Classe permettant de gérer le cas ou le solde du compte est négatif
 * 
 * @author Quentin
 * 
 */
public class SoldeNegatifException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653601094305522393L;

	/**
	 * Constructeur par défaut de la classe SoldeNegatifException
	 */
	public SoldeNegatifException() {
		super();
	}

	/**
	 * Constructeur de la classe SoldeNegatifException
	 * 
	 * @param s
	 *            : chaine contenant l'erreur
	 */
	public SoldeNegatifException(String s) {
		System.err.println(s);
	}
}
