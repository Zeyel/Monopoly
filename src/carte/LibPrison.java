package carte;

import donneesPrincipales.Joueur;

/**
 * Carte spéciale : Libérer de prison
 * 
 * Se met dans l'inventaire du joueur qui la pioche, celui-ci peut l'utiliser une fois en prison pour ens sortir
 * @author timbr
 *
 */
public class LibPrison extends Carte {
	// CONSTRUCTEUR
	
	/**
	 * Constructeur de la carte LibPrison
	 * @param descr
	 * @param nom
	 */
	public LibPrison(String descr, String nom) {
		super.setDescr(descr);
		super.setNom(nom);
	}
	// METHODES
	
	/* (non-Javadoc)
	 * Action de la carte LibPrison
	 * @see carte.Carte#action(donneesPrincipales.Joueur)
	 */
	public void action(Joueur j) {
    	System.out.println(getDescr());
		j.addCarteLib(this);
	}
	

}
