package plateau;

import java.security.InvalidParameterException;

import donneesPrincipales.Joueur;

public class Taxes implements Cases {
	private int montant;
	
	
	// CONSTRUCTEUR
	public Taxes(){
		this.setMontant(0);
	}
	
	public Taxes(int i){
		this.setMontant(i);
	}
	//GETTER
	public int montant(){
		return this.montant;
	}
	
	//SETTER
	public void setMontant(int montant) throws InvalidParameterException{
		if (montant < 0)
			throw new InvalidParameterException("Le montant de la taxe ne peut pas etre negatif.");
		else if (montant==0)
			throw new InvalidParameterException("Une taxe, gratuite ? On veut de l'argent ! Vous allez me faire le plaisir de rentrer un gros nombre plutot.");
		else
			this.montant=montant;
	}
	//METHODES

	public void action(Joueur joueur) {
		System.out.println("Vous devez verser "+this.montant+" €, desole c'est pas moi qui le veut c'est l'etat.");
		joueur.setArgent(joueur.getArgent()-this.montant);
		
	}
	public void ajoutParc(Parc parc) {
		parc.setJackpot(parc.getJackpot()+this.montant);
	}

}
