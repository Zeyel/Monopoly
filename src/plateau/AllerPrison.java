package plateau;

import donneesPrincipales.Joueur;

public class AllerPrison implements Cases{

	public void action(Joueur joueur) {
	System.out.println("Eh ! Vous la ! Vous etes en etat d'arrestation !");
	joueur.setPos(9);
	joueur.setEtatPrison(0);
	System.out.println("Vous aurez 3 tours pour reflechir a ce que vous avez fait !");
	}

}
