package Exception;

public class NombreDeCompteTropEleveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4451742915794364853L;

	public NombreDeCompteTropEleveException() {
		super();
	}

	public NombreDeCompteTropEleveException(String s) {
		System.err.println(s);
	}
}
