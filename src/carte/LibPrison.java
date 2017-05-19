package carte;

import donneesPrincipales.Joueur;

public class LibPrison extends Carte {
	// CONSTRUCTEUR
	
	public LibPrison(String descr, String nom) {
		super.setDescr(descr);
		super.setNom(nom);
	}
	// METHODES
	
	public void action(Joueur j) {
		j.addCarteLib(this);
	}
	

}
