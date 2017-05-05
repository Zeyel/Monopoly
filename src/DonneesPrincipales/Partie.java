package DonneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Classe englobant les informations de jeu
 * 
 * 
 * @author Geoffrey
 * @version 1.0
 */

public class Partie {
	private ArrayList<Integer> cases = new ArrayList<Integer>();
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private ArrayList<De> = new ArrayList<De>();
	private Paquet chance;
	private Paquet communaute;
	
	
			//CONSTRUCTEURS
	public Partie (Integer... cases) throws InvalidParameterException {
		if (cases == null)
			throw new InvalidParameterException("Il n'y a pas de cases sur le plateau");
		for(Integer cas:cases) {
			this.cases.add(cas);
		}
			
	}
	public Partie (Joueur... joueurs) throws InvalidParameterException {
		if (joueurs == null)
			throw new InvalidParameterException("Il n'y a pas de joueurs dans la partie");
		for(Joueur joueur:joueurs) {
			this.joueurs.add(joueur);
		}
	}
			
			//GETTERS
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}
		
			//SETTERS
	public void setJoueurs(ArrayList<Joueur> joueurs) throws InvalidParameterException {
		if (joueurs == null)
			throw new InvalidParameterException("Il n'y a pas de joueurs en paramètres");
		else
			this.joueurs = joueurs;
	}

			//METHODES
	

}
