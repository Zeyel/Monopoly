package carte;

import donneesPrincipales.Joueur;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CarteAnniversaire extends Carte{
	private int montant;
	
	// CONSTRUCTEUR
	public CarteAnniversaire (String descr, String nom, int montant) {
		super.setDescr(descr);
		super.setNom(nom);
		this.setMontant(montant);
	}
	// GETTER
	public int getMontant (){
		return this.montant;
}
	// SETTER
	private void setMontant(int montant){
		this.montant = montant;
	}
	
	// METHODES
	public void action(Joueur joueur, ArrayList<Joueur> joueurs) {
		joueur.setArgent(joueur.getArgent()+joueurs.size()*this.montant);
		for (Joueur j : joueurs){
			j.setArgent(j.getArgent()-this.montant);
		}
			
	}
}