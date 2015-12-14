package modele;

/**
 * Class association
 * 
 * @author Quentin
 *
 */
public class Association extends Client {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4733030780710580947L;
	private String libelle;

	/**
	 * Constructeur de la class Association
	 * 
	 * @param libelle
	 *            : nom de l'association
	 */
	public Association(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public double getMontantAbonnement() {
		int nombreCompte = 0;
		int nombreCompteMontant15000 = 0;

		for (Compte c : super.getCompteBancaires()) {
			if (c.getSolde() > 15000.0) {
				nombreCompteMontant15000++;
			} else {
				nombreCompte++;
			}
		}
		return (nombreCompte * 10.0) + (nombreCompteMontant15000 * 22.0);

	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
