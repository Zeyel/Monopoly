package DonneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;


/**
 * Classe contenant toutes les informations sur le joueur
 * 
 * 
 * @author Tim
 * @version 1.0
 */

public class Joueur {
	private String nom;				// Nom du joueur lue sur l'entree standard en debut de programme
	private int argent;				// Argent que le joueur possede, si le joueur finit un tour avec cette valeur negative, alors il perd la partie
	private int pos;                // Position du joueur sur le plateau
	private int carteLibPris;		// Nombre de cartes "Vous etes libere de prison" du jour (0 a 2)
	private int etatPrison;			// -1 si le joueur n'est pas en prison, sinon de 0 a 3 pour definir le nombre de jours passes en prison
	private int jetDe;				// Stocke le jet de de du tour actuel
	private int nbCompagnie;		// Nombre de compagnies possedees par le joueur (0 a 2)
	private int nbGares;			// Nombre de gares possedees par le joueur (0 a 4) 
	private ArrayList<Integer> proprietes = new ArrayList<Integer>();	// liste des proprietes du joueurs qui sont stockees en donnant la position de la propriete
	private boolean gameOver;
	
			// CONSTRUCTEURS
	public Joueur (String nom) throws InvalidParameterException {
		setNom(nom);
		this.argent = 1500;
		this.pos= 0;
		this.carteLibPris = 0;
		this.etatPrison = -1;
		this.jetDe = 0;
		this.nbCompagnie = 0;
		this.nbGares = 0;
		this.proprietes.clear();
		this.gameOver = false;
		
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
	
	public int getCarteLib() {
		return carteLibPris;
	}
	
	public int getEtatPrison() {
		return etatPrison;
	}
	
	public int getJetDe() {
		return jetDe;
	}
	
	public int getNbCompagnie() {
		return nbCompagnie;
	}
	
	public int getNbGares() {
		return nbGares;
	}
	
	public ArrayList<Integer> getProprietes() {
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
	
	public void setCarteLib(int carteLibPris) throws InvalidParameterException {
		if(carteLibPris < 0 || carteLibPris > 2) 
			throw new InvalidParameterException("Joueur.setCarteLib() // Nombre de cartes de liberation invalide");
		this.carteLibPris = carteLibPris;
	}
	
	public void setEtatPrison(int etatPrison) throws InvalidParameterException {
		if(etatPrison < (-1) || etatPrison > 3) 
			throw new InvalidParameterException("Joueur.setEtatPrison() // Nombre de jours passes en prison non conformes");
		this.etatPrison = etatPrison;
	}
	
	public void setJetDe(int jetDe) throws InvalidParameterException {
		if(jetDe < 2 || jetDe > 12)
			throw new InvalidParameterException("Joueur.setJetDe() // Le jet de de est invalide car non compris entre 2 et 12");
		this.jetDe = jetDe;
	}
	
	public void setNbCompagnie(int nbCompagnie) throws InvalidParameterException {
		if(nbCompagnie < 0 || nbCompagnie > 2)
			throw new InvalidParameterException("Joueur.setNbCompagnie() // Le nombre de compagnies possedees par le joueur est inexact car non compris entre 0 et 2");
		this.nbCompagnie = nbCompagnie;
	}
	
	public void setNbGares(int nbGares) throws InvalidParameterException {
		if(nbGares < 0 || nbGares > 4)
			throw new InvalidParameterException("Joueur.setNbGares() // Le nombre de gares possedees par le joueur est inexact car non compris entre 0 et 4");
		this.nbGares = nbGares;
	}
	
	public void setProprietes(ArrayList<Integer> proprietes) throws InvalidParameterException {
		if(proprietes.size() > 28)
			throw new InvalidParameterException("Joueur.setProprietes() // Le nombre de proprietes possedees par le joueur depasse le nombre de proprietes existantes");
		this.proprietes = proprietes;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}
