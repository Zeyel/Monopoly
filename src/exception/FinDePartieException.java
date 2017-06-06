package exception;

import donneesPrincipales.Joueur;

/**
 * Si il reste plus qu'un joueur en jeu, renvoie ce joueur avec l'exception
 * @author timbr
 *
 */
public class FinDePartieException extends Exception{
	private Joueur j;

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la FinDePartieException, renvoyant le joueur gagnant
	 * @param j
	 */
	public FinDePartieException (Joueur j) {
		super();
		this.setJoueur(j);
	}
	// GETTERS
	
	/**
	 * Renvoie le joueur
	 * @return
	 */
	public Joueur getJoueur(){
		return this.j;
	}
	
	// SETTERS
	/**
	 * Initialise le joueur
	 * @param j
	 */
	public void setJoueur(Joueur j) {
		this.j = j;
	}

	/**
	 * Constructeur avec message uniquement
	 * @param msg
	 */
	public FinDePartieException (String msg) {
		super(msg);
	}
}

