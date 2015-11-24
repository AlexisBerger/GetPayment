package modele;

import java.util.Scanner;

/**
 * Class permettant de créer un client "Professionnel"
 * 
 * @author Quentin
 * 
 */
public class ClientProfessionnel extends Client {

	private final static double DECOUVERT_AUTORISE = 0.00;
	private String societe;
	private int siren;

	/**
	 * Constructeur par défaut de la class ClientProfessionnel
	 */
	public ClientProfessionnel() {
		super();
	}

	/**
	 * Constructeur de la class ClientProfessionnel
	 * 
	 * @param num
	 *            : numéro du client
	 * @param nom
	 *            : nom du client
	 * @param prenom
	 *            : prénom du client
	 * @param age
	 *            : âge du client
	 * @param mail
	 *            : email du client
	 * @param societe
	 *            : société du client
	 * @param siren
	 *            : numéro siren de la société du client
	 */
	public ClientProfessionnel(String num, String nom, String prenom, int age,
			String mail, String societe, int siren) {
		super(num, nom, prenom, age, mail, DECOUVERT_AUTORISE);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (!verifSiren(siren)) {
			System.out.println("Saisir un nouveau numéro de siren");
			if (sc.hasNextInt()) {
				siren = sc.nextInt();
			}
		}
		this.setSiren(siren);
		this.setSociete(societe);
		System.out.println("Client " + nom + " " + prenom + " créé ! ");
	}

	/**
	 * Fonction permettant de savoir si le numéro de siren à le bon format
	 * 
	 * @param siren
	 *            : numéro à vérifier
	 * @return vrai si le numéro à le bon format, faux sinon
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
	 * Fonction permettant de connaitre le coût des compte pour un client
	 * Professionnel
	 * 
	 * @return le coût des compte à un moment T
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
