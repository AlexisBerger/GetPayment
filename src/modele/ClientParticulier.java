package modele;

public class ClientParticulier extends Client{

	private final static double DECOUVERT_AUTORISE = 500.00;
	
	public ClientParticulier(){
		super();
	}
	
	public ClientParticulier(String num, String nom, String prenom, int age, String mail){
		super(num, nom, prenom, age, mail, DECOUVERT_AUTORISE);

		System.out.println("Client " + nom + " " + prenom + " créé ! ");
	}

	/**
	 * @return the dECOUVERT_AUTORISE
	 */
	public double getDECOUVERT_AUTORISE() {
		return DECOUVERT_AUTORISE;
	}
}
