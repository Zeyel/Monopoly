package plateau;

import java.security.InvalidParameterException;

import carte.Paquet;
import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

/**
 * Classe simulant la case pour piocher les différents paquets
 * @author timbr
 *
 */
public class Tirer implements Cases{
	private Paquet paquet;
	
	// CONSTRUCTEUR
	/**
	 * Constructeur de base d'un Tirer
	 * @param pack
	 */
	public Tirer(Paquet pack){
		this.setPaquet(pack);
	}
	
	// SETTER
	
	/**
	 * Initialise le paquet pack
	 * @param pack
	 */
	public void setPaquet(Paquet pack) {
		this.paquet = pack;
	}
	
	// METHODES
	
	/* (non-Javadoc)
	 * Action de la case Tirer
	 * @see plateau.Cases#action(donneesPrincipales.Joueur)
	 */
	public void action(Joueur joueur) throws ProloException, ChanceException {
		this.paquet.tirerCarte(joueur);
	}
	
}