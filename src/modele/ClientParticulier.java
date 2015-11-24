package modele;

public class ClientParticulier extends Client {

	private final static double DECOUVERT_AUTORISE = 500.00;

	public ClientParticulier() {
		super();
	}

	public ClientParticulier(String num, String nom, String prenom, int age,
			String mail) {
		super(num, nom, prenom, age, mail, DECOUVERT_AUTORISE);

		System.out.println("Client " + nom + " " + prenom + " créé ! ");
	}

	/**
	 * @return the dECOUVERT_AUTORISE
	 */
	public double getDECOUVERT_AUTORISE() {
		return DECOUVERT_AUTORISE;
	}

	public double getMontantAbonnement() {
		int nombreCompte = 0;

		for (Compte c : super.getCompteBancaires()) {
			nombreCompte++;
		}
		if(nombreCompte < 2){
			return  (nombreCompte * 22.0);
		}else{
			return  (nombreCompte * 20.0);
		}
		
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + getMontantAbonnement();
	}
}
