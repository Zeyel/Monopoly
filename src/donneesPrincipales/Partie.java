package donneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import carte.De;
import carte.Paquet;
import plateau.Cases;

/**
 * Classe englobant les informations de jeu
 * 
 * 
 */

public class Partie {
	private ArrayList<Cases> cases = new ArrayList<Cases>();
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private ArrayList<De> de = new ArrayList<De>();
	private Paquet chance;
	private Paquet communaute;
	
	
			//CONSTRUCTEURS
	public Partie(){
		this.cases = new ArrayList<Cases>();
		this.joueurs = new ArrayList<Joueur>();
		this.de = new ArrayList<De>();
		this.chance = null;
		this.communaute = null;
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
	
	public void addDe (De dice) {
		this.de.add(dice);
	}
	
	public void addCase (Cases c) {
		this.cases.add(c);
	}
	
	public void addJoueur (Joueur j) {
		this.joueurs.add(j);
	}
	public void setChance (Paquet c) {
		this.chance = c; 
	}
	public void setCommunaute (Paquet c) {
		this.communaute = c;
	}
			//METHODES
	

}
