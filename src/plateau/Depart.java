package plateau;

import donneesPrincipales.Joueur;

public class Depart implements Cases{
	public void action(Joueur joueur){
		joueur.setArgent(joueur.getArgent()+ 200);
	}
}
