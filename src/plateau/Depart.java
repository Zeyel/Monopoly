package plateau;

import donneesPrincipales.Joueur;

public class Depart implements Cases{
	public void action(Joueur joueur){
		System.out.println("Vous arrivez sur la case départ, recevez 400€");
		joueur.setArgent(joueur.getArgent()+ 200);
	}
}
