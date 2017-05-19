package donneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import carte.De;
import carte.Paquet;

/**
 * Classe englobant les informations de jeu
 * 
 * 
 */

public class Partie {
	private ArrayList<Integer> cases = new ArrayList<Integer>();
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private ArrayList<De> de = new ArrayList<De>();
	private Paquet chance;
	private Paquet communaute;
	
	
			//CONSTRUCTEURS
	public Partie(){
		this.cases = new ArrayList<Integer>();
		this.joueurs = new ArrayList<Joueur>();
		this.de = new ArrayList<De>();
		this.chance.nom = null;
		this.communaute.nom = null;
	}
		
	public Partie (Integer... cases) throws InvalidParameterException {
		if (cases == null)
			throw new InvalidParameterException("Il n'y a pas de cases sur le plateau");
		for(Integer cas : cases) {
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
	
	public Partie(De... de) {
		for(De des:de)
			this.de.add(des);
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
