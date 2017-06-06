package exception;

import donneesPrincipales.Joueur;

public class FinDePartieException extends Exception{
	private Joueur j;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinDePartieException (Joueur j) {
		super();
		this.setJoueur(j);
	}
	// GETTERS
	
	public Joueur getJoueur(){
		return this.j;
	}
	
	// SETTERS
	public void setJoueur(Joueur j) {
		this.j = j;
	}

	public FinDePartieException (String msg) {
		super(msg);
	}
}

