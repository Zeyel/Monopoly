package donneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import carte.LibPrison;
import exception.ProloException;
import plateau.Parc;
import plateau.Proprietes;
import plateau.Terrain;




/**
 * Classe contenant le joueur et toutes les informations propres au joueur
 * @author timbr
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
	/**
	 * Constructeur du joueur par défaut, seul le nom est modifié
	 * @param nom
	 * @throws InvalidParameterException
	 */
	public Joueur (String nom) throws InvalidParameterException {
		setNom(nom);
		this.setArgent(1500);
		this.setPos(0);
		this.cartePris = new ArrayList<LibPrison>();
		this.setEtatPrison(-1);
		this.proprietes = new ArrayList<Proprietes>();
		this.gameOver = false;
		this.dette = 0;
		
	}
	
	/**
	 * Constructeur uniquement pour le développeur pour tester diverses opérations sur le joueur
	 * @param nom
	 * @param pos
	 * @param arg
	 * @param etatPrison
	 * @param go
	 * @throws InvalidParameterException
	 */
	public Joueur (String nom, int pos, int arg, int etatPrison, boolean go) throws InvalidParameterException{
		setNom(nom);
		setPos(pos);
		setArgent(arg);
		setEtatPrison(etatPrison);
		if (go)
			setGameOver();
		else
			this.gameOver = false;
		this.proprietes = new ArrayList<Proprietes>();
		this.cartePris = new ArrayList<LibPrison>();
		this.dette = 0;
	}
			
			// GETTERS
	/**
	 * Renvoie le nom du joueur
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Renvoie le solde d'argent du joueur
	 * @return
	 */
	public int getArgent() {
		return argent;
	}
	
	/**
	 * Renvoie la position du joueur
	 * @return
	 */
	public int getPos() {
		return pos;
	}
	
	/**
	 * Renvoie la carte LibPrison
	 * @return
	 */
	public LibPrison getCarteLib() {
		return cartePris.get(0);
	}
	
	/**
	 * Renvoie l'état du joueur :
	 * - de 0 à 3 pour emprisonné
	 * - -1 pour libre 
	 * @return
	 */
	public int getEtatPrison() {
		return etatPrison;
	}
	
	/**
	 * Renvoie l'ArrayList de Proprietes
	 * @return
	 */
	public ArrayList<Proprietes> getProprietes() {
		return proprietes;
	}
	
	/**
	 * Renvoie l'ArrayList de Proprietes, mais uniquement les Terrain
	 * @return
	 */
	public ArrayList<Terrain> getTerrain() {
		ArrayList<Terrain> res = new ArrayList<Terrain>();
		for (Proprietes P : this.proprietes) {
			if (P.getClass().getName() == "Terrain")
				res.add((Terrain) P);
		}
		return res;
	}
	
	/**
	 * Renvoie le nombre de proprietes de couleur définie en paramètre que possède le joueur
	 * @param couleur
	 * @return
	 */
	public int getNbProp(String couleur){
		int cpt =0;
		for (Proprietes P : this.getProprietes()) {
			if (P.getCouleur() == couleur)
				cpt++;
		}
		return cpt;
	}
	
	/**
	 * Renvoie l'état du joueur
	 * - true pour gameOver
	 * - false si toujours en jeu
	 * @return
	 */
	public boolean getGameOver() {
		return gameOver;
	}
			
			// SETTERS
	
	/**
	 * Initialise le nom du joueur
	 * @param nom
	 * @throws InvalidParameterException
	 */
	private void setNom(String nom) throws InvalidParameterException {
		if(nom == null || nom == "")
			throw new InvalidParameterException("Joueur.setNom() // Nom vide");
		this.nom = nom;
	}
	
	/**
	 * Initialise l'argent du joueur
	 * @param argent
	 */
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	/**
	 * Initialise la position du joueur
	 * @param pos
	 * @throws InvalidParameterException
	 */
	public void setPos(int pos) throws InvalidParameterException {
		if(pos < 0)
			throw new InvalidParameterException("Position invalide");
		this.pos = pos;
	}
	
	/**
	 * Ajoute la carte LibPrison au joueur
	 * @param carte
	 * @throws InvalidParameterException
	 */
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
	/**
	 * Place le joueur en gameOver
	 */
	public void setGameOver() {
		this.gameOver = true;
	}
	
	// METHODES
	
	/**
	 * Reçoit de l'argent
	 * @param J
	 * @param add
	 */
	public void gain (Joueur J, int add) {
		J.setArgent(getArgent() + add);
	}
	
	/**
	 * Donne au j2 le montant indiqué en paramètre, place en gameOver si pas assez d'argent
	 * @param j2
	 * @param montant
	 * @throws ProloException
	 */
	public void payerJoueur(Joueur j2, int montant) throws ProloException {
		j2.setArgent(j2.getArgent()+montant);
		if(this.getArgent()-montant<0) {
			System.out.println("|Vous n'avez plus assez d'argent pour payer");
			throw new ProloException(montant);
		}
		this.setArgent(this.getArgent()-montant);
		System.out.println("|Nouveau solde : "+ this.getArgent()+"€");

	}
	
	/**
	 * Reduit l'argent du joueur du montant indiqué
	 * @param montant
	 * @throws ProloException
	 */
	public void payer(int montant) throws ProloException {
		if(this.getArgent()-montant<0){
			System.out.println("|Vous n'avez plus assez d'argent pour payer");
			throw new ProloException(montant);
		}
		this.setArgent(this.getArgent()-montant);
	}
	
	/**
	 * Donne au parc gratuit le montant indiqué
	 * @param montant
	 * @param p
	 * @throws ProloException
	 */
	public void payerParc(int montant, Parc p) throws ProloException {
		p.setJackpot(p.getJackpot() + montant);
		if(this.getArgent()-montant<0){
			System.out.println("|Vous n'avez plus assez d'argent pour payer");
			throw new ProloException(montant);
		}
		this.setArgent(this.getArgent()-montant);
		System.out.println("|Nouveau solde : "+ this.getArgent()+"€");

	}
	
	/**
	 * Déplace le joueur de nb cases
	 * @param nb
	 */
	public void deplacement (int nb) {
		if ((this.getPos() + nb) / 40 == 1)
			this.setArgent(this.getArgent()+200);
		this.setPos((this.getPos() + nb) % 40);
		System.out.println("|La nouvelle position du joueur " + this.getNom() + " est " + this.getPos() + ".");
	}
	
	/**
	 * Methode non faite, sensée lancer une procédure dans lequel le joueur 
	 * est obligé de trouver l'argent pour payer sa dette en vendant ses maisons / hôtels ou en hypothéquant
	 * @param dette
	 */
	public void GameOver(int dette) {
		this.setGameOver();
		//TODO
	}
	
	/**
	 * Réinitialise toutes les propriétés du joueur
	 */
	public void reset() {
		for (Proprietes p : this.getProprietes()) {
			p.setProprietaire(null);
		}
	}
	/* (non-Javadoc)
	 * toString du joueur
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (this.etatPrison==-1)
			return ("Joueur : "+this.nom+" / Argent : "+this.argent+" / Position : "+this.pos+" / Pas en prison / nombre de proprietes : "+this.proprietes.size());
		else
			return ("Joueur : "+this.nom+" / Argent : "+this.argent+" / Position : "+this.pos+" / en prison depuis "+this.etatPrison+" tours / nombre de proprietes : "+this.proprietes.size());
	}
	/**
	 * equels du joueur
	 * @param joueur
	 * @return
	 */
	public boolean equals(Joueur joueur) {
		return (this.nom.equals(joueur.nom));
	}
}