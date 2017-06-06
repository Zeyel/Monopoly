package plateau;

import java.security.InvalidParameterException;

import donneesPrincipales.Joueur;
import exception.ProloException;

public class Taxes implements Cases {
	private int montant;
	private Parc parc;
	
	
	// CONSTRUCTEUR
	public Taxes(){
		this.setMontant(0);
	}
	
	public Taxes(int i){
		this.setMontant(i);
	}
	public Taxes(int i, Parc parc) {
		this.setMontant(i);
		this.setParc(parc);
	}

	private void setParc(Parc parc) {
		this.parc= parc;

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
		System.out.println("|Vous devez verser "+this.montant+" €.");	
		try {
			joueur.payerParc(this.montant, this.parc);
		} catch (ProloException e) {
			joueur.setGameOver();
		}	
		if (!(joueur.getGameOver()))
			System.out.println("|Votre nouveau solde est de "+ joueur.getArgent() + "€.");
	}
}
