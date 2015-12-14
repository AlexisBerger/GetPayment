package Exception;

/**
 * Class permettant de lever une exception si le format du fichier � charger n'est pas le bon 
 */
public class FormatFichierOperation extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5700907174655442137L;

	/**
	 * Constructeur par d�faut de la classe FormatFichierOperation
	 */
	public FormatFichierOperation() {
		super();
	}

	/**
	 * Constructeur par d�faut de la classe FormatFichierOperation
	 * 
	 * @param s
	 *            : chaine contenant l'erreur
	 */
	public FormatFichierOperation(String s) {
		System.err.println(s);
	}
}
