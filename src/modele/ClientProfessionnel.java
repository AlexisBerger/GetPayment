package modele;

import java.util.Scanner;

public class ClientProfessionnel extends Client {

	private final static double DECOUVERT_AUTORISE = 0.00;
	private String societe;
	private int siren;

	public ClientProfessionnel() {
		super();
	}

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

	public boolean verifSiren(int siren) {
		int nb = Integer.toString(siren).length();
		if (nb == 7) {
			return true;
		} else {
			return false;
		}
	}

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
