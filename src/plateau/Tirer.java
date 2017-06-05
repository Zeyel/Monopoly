package plateau;

import java.security.InvalidParameterException;

import carte.Paquet;
import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

public class Tirer implements Cases{
	private String paquet;
	
	// CONSTRUCTEUR
	public Tirer(String s) throws InvalidParameterException {
		if ((s == null) || ((s !="chance") && (s !="communaute")))
			throw new InvalidParameterException("La chaine n'est pas correcte");
		this.paquet = s;
		
	}

	public void action(Joueur joueur, Paquet p) throws ProloException, ChanceException {
		p.tirerCarte(joueur);
		
	}

	public void action(Joueur joueur) throws ProloException {
		// TODO Auto-generated method stub
		
	}
	
}