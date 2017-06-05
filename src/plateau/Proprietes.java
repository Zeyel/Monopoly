package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import donneesPrincipales.Joueur;
import exception.ProloException;

public abstract class Proprietes implements Cases {
	private String nom;
	private int prix;
	private Joueur proprietaire;
	private String couleur;
	
	//CONSTRUCTEURS
	
	public Proprietes(){
		this.nom = null;
		this.setPrix(0);
		this.couleur = null;
		this.proprietaire = null;
	}
	
	public Proprietes(String nom, String couleur, int prix){
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
	
	public void setProprietaire(Joueur proprietaire) throws InvalidParameterException{
		if(nom==null)
			throw new InvalidParameterException("Le joueur n'existe pas");
		this.proprietaire = proprietaire;
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
	
	public void action (Joueur j) throws ProloException {
		
	}
	
	public void achat(Joueur j) {
		Scanner sc = new Scanner(System.in);
		int answer;
			if (j.getArgent() - this.getPrix() > 0) {
				System.out.println("Voulez vous acheter " + this.getNom() + " ? (o pour oui/n pour non)");
				do {
					answer = sc.next().charAt(0);
					if ((answer != 'O') || (answer != 'o') || (answer != 'N') || (answer != 'n'))
						System.out.println("Veuillez entrer O/o pour oui ou N/n pour non\n");
				} while ((answer != 'O') || (answer != 'o') || (answer != 'N') || (answer != 'n'));
				if ((answer == 'o') || (answer == 'O')) {
					j.setArgent(j.getArgent() - this.getPrix());
					this.setProprietaire(j);
					j.getProprietes().add(this);
					System.out.println("Vous venez d'acheter " + getNom() + ".\n " + "Votre nouveau solde est de "
							+ j.getArgent() + "€.");
				} else {
					System.out.println("Vous avez refusé d'acheter la propriété " + getNom()
							+ ".\nVous passez peut-être à côté d'une opportunité.");
				}
			} else
				System.out.println("Vous n'avez pas assez d'argent pour acheter " + this.getNom() + " !");
			sc.close();
		}
}
