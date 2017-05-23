package plateau;

import carte.Paquet;
import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

public class Tirer implements Cases{

	public void action(Joueur joueur, Paquet p) throws ProloException, ChanceException {
		p.tirerCarte(joueur);
		
	}

	public void action(Joueur joueur) throws ProloException {
		// TODO Auto-generated method stub
		
	}
	
}