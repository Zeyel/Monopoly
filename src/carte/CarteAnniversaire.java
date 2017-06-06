package carte;

import donneesPrincipales.Joueur;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Carte spéciale : Carte Anniversaire
 * 
 * Prend 10€ à chaque joueur pour le donner au joueur tombant sur la carte
 * @author timbr
 *
 */
public class CarteAnniversaire extends Carte{
	private int montant;
	
	// CONSTRUCTEUR
	/**
	 * Constructeur de la Carte Anniversaire
	 * @param descr
	 * @param nom
	 * @param montant
	 */
	public CarteAnniversaire (String descr, String nom, int montant) {
		super.setDescr(descr);
		super.setNom(nom);
		this.setMontant(montant);
	}
	// GETTER
	/**
	 * Renvoie le montant pris aux joueurs
	 * @return
	 */
	public int getMontant (){
		return this.montant;
}
	// SETTER
	/**
	 * Initialise le montant pris aux joueurs
	 * @param montant
	 */
	private void setMontant(int montant){
		this.montant = montant;
	}
	
	// METHODES
	/**
	 * Action de la Carte Anniversaire
	 * @param joueur
	 * @param joueurs
	 */
	public void action(Joueur joueur, ArrayList<Joueur> joueurs) {
		System.out.println(this.getDescr());
		joueur.setArgent(joueur.getArgent()+joueurs.size()*this.montant);
		for (Joueur j : joueurs){
			j.setArgent(j.getArgent()-this.montant);
		}
			
	}
}