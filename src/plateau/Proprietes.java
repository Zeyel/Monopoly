package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import donneesPrincipales.Joueur;

public abstract class Proprietes implements Cases {
	private String nom;
	private int prix;
	private Joueur proprietaire;
	private String couleur;
	
	//CONSTRUCTEURS
	
	public Proprietes(){
		this.nom=null;
		this.setPrix(0);
		this.proprietaire = null;
		this.couleur = null;
	}
	public Proprietes(String nom, int prix, String couleur){
		this.setNom(nom);
		this.setPrix(prix);
		this.setCouleur(couleur);
	}
	
	//GETTERS
	
	public String getNom() throws InvalidParameterException {
		if (this.nom == null)
			throw new InvalidParameterException("La carte n'a pas de nom");
		else
			return this.nom;
	}
	public int getPrix() {
		return this.prix;
	}
	public Joueur getProprietaire() throws InvalidParameterException {
		if (this.proprietaire == null)
			throw new InvalidParameterException("La propriete n'a pas de proprietaire");
		return this.proprietaire;
	}
	public String getCouleur() {
		return this.couleur;
	}
	public void setCouleur(String couleur) throws InvalidParameterException{
		if ((couleur != "rose") ||
			(couleur != "ciel") || 
			(couleur != "violet") || 
			(couleur != "orange") || 
			(couleur != "rouge") || 
			(couleur != "jaune") || 
			(couleur != "jaune") || 
			(couleur != "vert") || 
			(couleur != "bleu") || 
			(couleur != "noir") ||
			(couleur != "blanc"))
			throw new InvalidParameterException ("Couleur non conforme");
		this.couleur = couleur;
	}
	
	// SETTERS
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrix(int prix) throws InvalidParameterException {
		if (prix < 0)
			throw new InvalidParameterException ("Prix negatif impossible");
		this.prix = prix;
	}
	
	// METHODES
	
	public String toString() throws InvalidParameterException {
		if ( (this.nom == null) )
			throw new InvalidParameterException("Manque parametres, impossible d'afficher");
		else if (this.proprietaire == null)
			return ("Propriete[nom : " +this.getNom()+", prix : "+this.prix+", AUCUN PROPRIETAIRE]");
		else
			return ("Propriete[nom : " +this.getNom()+", prix : "+this.prix+" proprietaire : "+this.proprietaire.getNom()+"]");
	}
	
	public boolean equals(Proprietes propriete) {
		return ((this.nom.equals(propriete.nom)) && (this.prix == propriete.prix) && (this.proprietaire.equals(propriete.proprietaire)));
	}
	
	public void action (Joueur j) {
	}
}
