package modele;

import java.util.Scanner;

/**
 * Class permettant de cr�er un client "Professionnel"
 * 
 * @author Quentin
 * 
 */
public class ClientProfessionnel extends Client {

	private final static double DECOUVERT_AUTORISE = 0.00;
	private String societe;
	private int siren;

	/**
	 * Constructeur par d�faut de la class ClientProfessionnel
	 */
	public ClientProfessionnel() {
		super();
	}

	/**
	 * Constructeur de la class ClientProfessionnel
	 * 
	 * @param num
	 *            : num�ro du client
	 * @param nom
	 *            : nom du client
	 * @param prenom
	 *            : pr�nom du client
	 * @param age
	 *            : �ge du client
	 * @param mail
	 *            : email du client
	 * @param societe
	 *            : soci�t� du client
	 * @param siren
	 *            : num�ro siren de la soci�t� du client
	 */
	public ClientProfessionnel(String num, String nom, String prenom, int age,
			String mail, String societe, int siren) {
		super(num, nom, prenom, age, mail, DECOUVERT_AUTORISE);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!verifSiren(siren)) {
			System.out.println("Saisir un nouveau num�ro de siren");
			if (sc.hasNextInt()) {
				siren = sc.nextInt();
			}
		}
		this.setSiren(siren);
		this.setSociete(societe);
		System.out.println("Client " + nom + " " + prenom + " cr�� ! ");
	}

	/**
	 * Fonction permettant de savoir si le num�ro de siren � le bon format
	 * 
	 * @param siren
	 *            : num�ro � v�rifier
	 * @return vrai si le num�ro � le bon format, faux sinon
	 */
	public boolean verifSiren(int siren) {
		int nb = Integer.toString(siren).length();
		if (nb == 9) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Fonction permettant de connaitre le co�t des compte pour un client
	 * Professionnel
	 * 
	 * @return le co�t des compte � un moment T
	 */
	public double getMontantAbonnement() {
		int nombreOperation = 0;
		int nombreCompte = 0;

		for (Compte c : super.getCompteBancaires()) {
			nombreOperation += c.getNbOperation();
			nombreCompte++;
		}
		return (nombreOperation * 0.1) + (nombreCompte * 30.0);
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.societe + " - " + this.siren
				+ " - " + getMontantAbonnement();
	}

	/**
	 * @return the societe
	 */
	public String getSociete() {
		return societe;
	}

	/**
	 * @param societe
	 *            the societe to set
	 */
	public void setSociete(String societe) {
		this.societe = societe;
	}

	/**
	 * @return the siren
	 */
	public int getSiren() {
		return siren;
	}

	/**
	 * @param siren
	 *            the siren to set
	 */
	public void setSiren(int siren) {
		this.siren = siren;
	}

}
