package plateau;

import donneesPrincipales.Joueur;

/**
 * Classe symbolisant la carte AllerPrison
 * Si le joueur tombe dessus, il va automatiquement en prison (case 10) et son EtatPrison passe à 0
 * @author timbr
 *
 */
public class AllerPrison implements Cases{

	public void action(Joueur joueur) {
	System.out.println("|Eh ! Vous la ! Vous etes en etat d'arrestation !");
	joueur.setPos(10);
	joueur.setEtatPrison(0);
	System.out.println("|Vous aurez 3 tours pour reflechir a ce que vous avez fait !");
	}

}
