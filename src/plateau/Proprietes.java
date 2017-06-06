package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import donneesPrincipales.Joueur;
import exception.ProloException;

/**
 * Classe simulant une propriété, sous classe de Cases, super classe de Terrain, Gare et Compagnie
 * @author timbr
 *
 */
public abstract class Proprietes implements Cases {
	private String nom;
	private int prix;
	public Joueur proprietaire;
	private String couleur;
	
	//CONSTRUCTEURS
	
	/**
	 * Constructeur d'une Propriete par défaut
	 */
	public Proprietes(){
		this.nom = null;
		this.setPrix(0);
		this.couleur = null;
		this.proprietaire = null;
	}
	
	/**
	 * Constructeur d'une Propriete avec valeurs
	 * @param nom
	 * @param couleur
	 * @param prix
	 */
	public Proprietes(String nom, String couleur, int prix){
		this.setNom(nom);
		this.setPrix(prix);
		this.setCouleur(couleur);
			
	}
	
	//GETTERS
	
	/**
	 * Renvoie le nom de la case
	 * @return
	 * @throws InvalidParameterException
	 */
	public String getNom() throws InvalidParameterException {
		if (this.nom == null)
			throw new InvalidParameterException("La carte n'a pas de nom");
		else
			return this.nom;
	}
	/**
	 * Renvoie le prix de la case
	 * @return
	 */
	public int getPrix() {
		return this.prix;
	}

	/**
	 * Renvoie le propriétaire de la case
	 * @return
	 * @throws InvalidParameterException
	 */
	public Joueur getProprietaire() throws InvalidParameterException {
		if (this.proprietaire == null)
			throw new InvalidParameterException("La propriete n'a pas de proprietaire");
		return this.proprietaire;
	}
	
	/**
	 * Renvoie la famille de couleur de la case
	 * @return
	 */
	public String getCouleur() {
		return this.couleur;
	}
	
	// SETTERS
	
	/**
	 * Initialise le nom de la case
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Initialise le prix de la case
	 * @param prix
	 * @throws InvalidParameterException
	 */
	public void setPrix(int prix) throws InvalidParameterException {
		if (prix < 0)
			throw new InvalidParameterException ("Prix negatif impossible");
		this.prix = prix;
	}
	
	/**
	 * Initialise la famille de couleur de la case
	 * @param couleur
	 * @throws InvalidParameterException
	 */
	public void setCouleur(String couleur) throws InvalidParameterException {
		if ((couleur!="rose")&&
			(couleur!="ciel")&&
			(couleur!="violet")&&
			(couleur!="orange")&&
			(couleur!="rouge")&&
			(couleur!="jaune")&&
			(couleur!="vert")&&
			(couleur!="bleu")&&
			(couleur!="noir")&&
			(couleur!="blanc"))
			throw new InvalidParameterException("Famille de terrain inexistante");
		this.couleur = couleur;
	}
	
	/**
	 * Initialise le propriétaire de la case
	 * @param proprietaire
	 * @throws InvalidParameterException
	 */
	public void setProprietaire(Joueur proprietaire) throws InvalidParameterException{
		if(nom==null)
			throw new InvalidParameterException("Le joueur n'existe pas");
		this.proprietaire = proprietaire;
	}
	
	// METHODES
	
	/* (non-Javadoc)
	 * toString d'une Propriete
	 * @see java.lang.Object#toString()
	 */
	public String toString() throws InvalidParameterException {
		if (this.nom == null)
			throw new InvalidParameterException("Manque parametres, impossible d'afficher");
		else if (this.proprietaire == null)
			return ("Propriete[nom : " +this.getNom()+", prix : "+this.prix+", AUCUN PROPRIETAIRE");
		else
			return ("Propriete[nom : " +this.getNom()+", prix : "+this.prix+" proprietaire : "+this.proprietaire.getNom());
	}
	
	/**
	 * equals d'une Propriete
	 * @param propriete
	 * @return
	 */
	public boolean equals(Proprietes propriete) {
		return ((this.nom.equals(propriete.nom)) && (this.prix == propriete.prix) && (this.proprietaire.equals(propriete.proprietaire)));
	}
	
	/**
	 * Renvoie si le joueur j a toute la famille de couleur couleur
	 * @param j
	 * @param couleur
	 * @return
	 */
	public boolean hasFullColor(Joueur j, String couleur){
		int cpt = 0;
		for (Proprietes p : j.getProprietes()) {
			if(p.couleur.equals(couleur))
				cpt++;
		}
		switch (couleur) {
		case "blanc":
		case "bleu":
		case "rose":
			return (cpt == 2);
		case "noir" :
			return (cpt == 4);
		default :
			return (cpt == 3);
		}
	}
	
	/* (non-Javadoc)
	 * Action d'une proprietes, définie dans les sous classes
	 * @see plateau.Cases#action(donneesPrincipales.Joueur)
	 */
	public void action (Joueur j) throws ProloException {
		
	}
	
	/**
	 * Procédure d'achat d'une Propriete
	 * @param j
	 */
	public void achat(Joueur j) {
		String answer = null;
			if (j.getArgent() - this.getPrix() > 0) {
				System.out.println("|Voulez vous acheter " + this.getNom() + " ? (o pour oui/n pour non)");
				do {
					answer = "o";
					if ((answer != "O") && (answer != "o") && (answer != "N") && (answer != "n"))
						System.out.println("Veuillez entrer O/o pour oui ou N/n pour non\n");
				} while ((answer != "O") && (answer != "o") && (answer != "N") && (answer != "n"));
				if ((answer == "o") || (answer == "O")) {
					j.setArgent(j.getArgent() - this.getPrix());
					this.setProprietaire(j);
					j.getProprietes().add(this);
					System.out.println("|Vous venez d'acheter " + getNom() + ".\n " + "|Votre nouveau solde est de "
							+ j.getArgent() + "€.");
				} else {
					System.out.println("|Vous avez refusé d'acheter la propriété " + getNom());
				}
			} else
				System.out.println("|Vous n'avez pas assez d'argent pour acheter " + this.getNom() + " !");
		}
	/**
	 * Est sensé demandé à l'utilisateur si il veut acheter ou non la propriété
	 * @return
	 */
	public String demander() {
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		sc.close();
		return answer;
	}
}
