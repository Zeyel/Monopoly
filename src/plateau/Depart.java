package plateau;

import donneesPrincipales.Joueur;

/**
 * Classe simulant la case départ, tout joueur s'y arrêtant reçoit 200€ supplémentaire à ceux qu'ils reçoient déjà lors du déplacement
 * @author timbr
 *
 */
public class Depart implements Cases{
	public void action(Joueur joueur){
		System.out.println("|Vous arrivez sur la case départ, recevez 400€");
		joueur.setArgent(joueur.getArgent()+ 200);
	}
}
