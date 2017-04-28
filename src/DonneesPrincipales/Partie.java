package DonneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Classe englobant les informatipons de jeu
 * 
 * 
 * @author Geoffrey
 * @version 1.0
 */

public class Partie {
	private ArrayList<Integer> cases = new ArrayList<Integer>();
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	
			//CONSTRUCTEURS
	public Partie (Integer... cases) throws InvalidParameterException {
		for(Integer cas:cases) {
			this.cases.add(cas);
		}
			
	}
	public Partie (Joueur... joueurs) throws InvalidParameterException {
		for(Joueur joueur:joueurs) {
			this.joueurs.add(joueur);
		}
	}
			
			//GETTERS
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}
		
			//SETTERS
	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
}
