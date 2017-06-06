package plateau;

import donneesPrincipales.Joueur;

/**
 * Classe simulant la case d�part, tout joueur s'y arr�tant re�oit 200� suppl�mentaire � ceux qu'ils re�oient d�j� lors du d�placement
 * @author timbr
 *
 */
public class Depart implements Cases{
	public void action(Joueur joueur){
		System.out.println("|Vous arrivez sur la case d�part, recevez 400�");
		joueur.setArgent(joueur.getArgent()+ 200);
	}
}
