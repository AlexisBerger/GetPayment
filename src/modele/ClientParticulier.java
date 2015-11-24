package modele;

/**
 * Class permettant de cr�er un client "Particulier"
 * 
 * @author Quentin
 * 
 */
public class ClientParticulier extends Client {

	private final static double DECOUVERT_AUTORISE = 500.00;

	/**
	 * Constructeur par d�faut de la class ClientParticulier
	 */
	public ClientParticulier() {
		super();
	}

	/**
	 * Constructeur de la class ClientParticulier
	 * 
	 * @param num
	 *            : num�ro de client
	 * @param nom
	 *            : nom du client
	 * @param prenom
	 *            : pr�nom du client
	 * @param age
	 *            : �ge du client
	 * @param mail
	 *            : email du client
	 */
	public ClientParticulier(String num, String nom, String prenom, int age,
			String mail) {
		super(num, nom, prenom, age, mail, DECOUVERT_AUTORISE);

		System.out.println("Client " + nom + " " + prenom + " cr�� ! ");
	}

	/**
	 * Getter permettant de connaitre le d�couvert autoris� pour un client
	 * 
	 * @return le DECOUVERT_AUTORISE
	 */
	public double getDECOUVERT_AUTORISE() {
		return DECOUVERT_AUTORISE;
	}

	/**
	 * Fonction permettant de connaitre le co�t des comptes pour un client
	 * particulier
	 * 
	 * @return le co�t des comptes � un moment T
	 */
	public double getMontantAbonnement() {
		int nombreCompte = 0;

		for (Compte c : super.getCompteBancaires()) {
			nombreCompte++;
		}
		if (nombreCompte < 2) {
			return (nombreCompte * 22.0);
		} else {
			return (nombreCompte * 20.0);
		}

	}

	@Override
	public String toString() {
		return super.toString() + " - " + getMontantAbonnement();
	}
}
