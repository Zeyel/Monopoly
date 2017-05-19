<<<<<<< HEAD
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
=======
package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import donneesPrincipales.Joueur;
import exception.ProloException;

public abstract class Proprietes implements Cases {
	private String nom;
	private int prix;
	private Joueur proprietaire;
	private String couleur;
	private int nbMaisons;
	
	//CONSTRUCTEURS
	
	public Proprietes(){
		this.nom = null;
		this.setPrix(0);
		this.couleur = null;
		this.proprietaire = null;
		this.nbMaisons = 0;
	}
	
	public Proprietes(String nom, String couleur, int prix, Integer ... i){
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
	
	public int getNbMaisons() {
		return this.nbMaisons;
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
	
	public void setCouleur(String couleur) throws InvalidParameterException {
		if ((couleur!="rose")||
			(couleur!="ciel")||
			(couleur!="violet")||
			(couleur!="orange")||
			(couleur!="rouge")||
			(couleur!="jaune")||
			(couleur!="vert")||
			(couleur!="bleu")||
			(couleur!="noir")||
			(couleur!="blanc"))
			throw new InvalidParameterException("Famille de terrain inexistante");
		this.couleur = couleur;
	}
	
	public void setProprietaire(Joueur proprietaire) throws InvalidParameterException{
		if(nom==null)
			throw new InvalidParameterException("Le joueur n'existe pas");
		this.proprietaire = proprietaire;
	}
	
	public void setNbMaisons(int nbMaisons) throws InvalidParameterException{
		if((nbMaisons<0)||(nbMaisons>5))
			throw new InvalidParameterException("Nombre de maisons incorrect");
		if ((this.couleur!="blanc")||(this.couleur!="noir"))
			throw new InvalidParameterException("Une gare et/ou une compagnie ne peut avoir de maison");
		this.nbMaisons = nbMaisons;
	}
	
	// METHODES
	
	public String toString() throws InvalidParameterException {
		if (this.nom == null)
			throw new InvalidParameterException("Manque parametres, impossible d'afficher");
		else if (this.proprietaire == null)
			return ("Propriete[nom : " +this.getNom()+", prix : "+this.prix+", AUCUN PROPRIETAIRE");
		else
			return ("Propriete[nom : " +this.getNom()+", prix : "+this.prix+" proprietaire : "+this.proprietaire.getNom());
	}
	
	public boolean equals(Proprietes propriete) {
		return ((this.nom.equals(propriete.nom)) && (this.prix == propriete.prix) && (this.proprietaire.equals(propriete.proprietaire)));
	}
	
	public boolean hasFullColor(Joueur j, String couleur){
		int cpt = 0;
		for (Proprietes p : j.getProprietes()) {
			if(p.couleur.equals(couleur))
				cpt++;
		}
		if((((couleur=="bleu")||(couleur=="rose"))&&(cpt==2))||(cpt==3))
			return true;
		return false;
	}
	
	public void action (Joueur j) throws ProloException {};
}
>>>>>>> origin/master
