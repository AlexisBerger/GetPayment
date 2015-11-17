package Exception;

/**
 * Classe permettant de g�rer le cas ou on veut retirer plus d'argent que l'on
 * en poss�de
 * 
 * @author Quentin
 * 
 */
public class NombreDeCompteTropEleveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4451742915794364853L;

	/**
	 * Constructeur par d�faut de la classe NombreDeCompteTropEleveException
	 */
	public NombreDeCompteTropEleveException() {
		super();
	}

	/**
	 * Constructeur par d�faut de la classe NombreDeCompteTropEleveException
	 * 
	 * @param s
	 *            : chaine contenant l'erreur
	 */
	public NombreDeCompteTropEleveException(String s) {
		System.err.println(s);
	}
}
