package donneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import carte.LibPrison;
import exception.ProloException;
import plateau.Parc;
import plateau.Proprietes;




/**
 * Classe contenant toutes les informations sur le joueur
 * 
 * 
 */

public class Joueur {
	private String nom;				// Nom du joueur lue sur l'entree standard en debut de programme
	private int argent;				// Argent que le joueur possede, si le joueur finit un tour avec cette valeur negative, alors il perd la partie
	private int pos;                // Position du joueur sur le plateau
	private ArrayList<LibPrison> cartePris;		// Nombre de cartes "Vous etes libere de prison" du joueur (0 a 2)
	private int etatPrison;			// -1 si le joueur n'est pas en prison, sinon de 0 a 3 pour definir le nombre de jours passes en prison
	private ArrayList<Proprietes> proprietes; 	// liste des proprietes du joueurs qui sont stockees en donnant la position de la propriete
	private boolean gameOver;
	private int dette;
	
			// CONSTRUCTEURS
	public Joueur (String nom) throws InvalidParameterException {
		setNom(nom);
		this.argent = 1500;
		this.pos= 0;
		this.cartePris = new ArrayList<LibPrison>();
		this.etatPrison = -1;
		this.proprietes = new ArrayList<Proprietes>();
		this.gameOver = false;
		this.dette = 0;
		
	}
			
			// GETTERS
	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	public int getPos() {
		return pos;
	}
	
	public LibPrison getCarteLib() {
		return cartePris.get(0);
	}
	
	public int getEtatPrison() {
		return etatPrison;
	}
	
	public ArrayList<Proprietes> getProprietes() {
		return proprietes;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
			
			// SETTERS
	
	private void setNom(String nom) throws InvalidParameterException {
		if(nom == null || nom == "")
			throw new InvalidParameterException("Joueur.setNom() // Nom vide");
		this.nom = nom;
	}
	
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public void setPos(int pos) throws InvalidParameterException {
		if(pos < 0)
			throw new InvalidParameterException("Joueur.setPos() // Position invalide");
		this.pos = pos;
	}
	
	public void addCarteLib(LibPrison carte) throws InvalidParameterException {
		if (carte == null)
			throw new InvalidParameterException("La carte n'est pas valide");
		this.cartePris.add(carte);
	}
	
	public void setEtatPrison(int etatPrison) throws InvalidParameterException {
		if(etatPrison < (-1) || etatPrison > 3) 
			throw new InvalidParameterException("Joueur.setEtatPrison() // Nombre de jours passes en prison non conformes");
		this.etatPrison = etatPrison;
	}
	
	public void setProprietes(ArrayList<Proprietes> proprietes) throws InvalidParameterException {
		if(proprietes.size() > 28)
			throw new InvalidParameterException("Le nombre de proprietes possedees par le joueur depasse le nombre de proprietes existantes");
		else
			this.proprietes = proprietes;
	}
	
	// METHODES
	
	public void gain (Joueur J, int add) {
		J.setArgent(getArgent() + add);
	}
	
	public void payerJoueur(Joueur j2, int montant) throws ProloException {
		if(this.getArgent()-montant<0)
			throw new ProloException("Vous n'avez pas assez d'argent!");
		this.setArgent(this.getArgent()-montant);
		j2.setArgent(j2.getArgent()+montant);
	}
	
	public void payerParc(int montant, Parc p) throws ProloException {
		if(this.getArgent()-montant<0)
			throw new ProloException("Vous n'avez pas assez d'argent!");
		this.setArgent(this.getArgent()-montant);
		p.setJackpot(p.getJackpot() + montant);
	}
	
	public void deplacement (Joueur J, int nb) {
		if ((J.getPos() + nb) / 40 == 1)
			J.setArgent(J.getArgent()+200);
		J.setPos((J.getPos() + nb) % 40);
	}
	
	public int getNbGares() {
		int nbGares = 0;
		for(Proprietes p : this.getProprietes())
			if(p.getCouleur()=="noir")
				nbGares++;
		return nbGares;
	}
	
	public int getNbCompagnies() {
		int nbCompagnies = 0;
		for(Proprietes p : this.getProprietes())
			if(p.getCouleur()=="blanc")
				nbCompagnies++;
		return nbCompagnies;
	}

	public void GameOver(int dette, Joueur j) {
		///TODO
	}
	
	public void GameOver(int dette) {
		///TODO
	}
	
	public String toString() {
		if (this.etatPrison==-1)
			return ("Joueur : "+this.nom+" / Argent : "+this.argent+" / Position : "+this.pos+" / Pas en prison / nombre de proprietes : "+this.proprietes.size());
		else
			return ("Joueur : "+this.nom+" / Argent : "+this.argent+" / Position : "+this.pos+" / en prison depuis "+this.etatPrison+" tours / nombre de proprietes : "+this.proprietes.size());
	}
	public boolean equals(Joueur joueur) {
		return (this.nom.equals(joueur.nom));
	}
}