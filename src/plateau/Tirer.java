package plateau;

import java.security.InvalidParameterException;

import carte.Paquet;
import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

public class Tirer implements Cases{
	private Paquet paquet;
	
	// CONSTRUCTEUR
	public Tirer(Paquet pack){
		this.setPaquet(pack);
	}
	
	// SETTER
	
	public void setPaquet(Paquet pack) {
		this.paquet = pack;
	}
	
	// METHODES
	
	public void action(Joueur joueur) throws ProloException, ChanceException {
		this.paquet.tirerCarte(joueur);
	}
	
}