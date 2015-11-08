package Exception;

public class SoldeNegatifException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653601094305522393L;

	public SoldeNegatifException() {
		super();
	}

	public SoldeNegatifException(String s) {
		System.err.println(s);
	}
}
