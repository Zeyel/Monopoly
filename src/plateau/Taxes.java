package plateau;

import java.security.InvalidParameterException;

import donneesPrincipales.Joueur;
import exception.ProloException;

/**
 * Classe simulant les taxes d'un plateau de monopoly
 * @author timbr
 *
 */
public class Taxes implements Cases {
	private int montant;
	private Parc parc;
	
	
	// CONSTRUCTEUR
	/**
	 * Constructeur par défaut d'un Taxes
	 */
	public Taxes(){
		this.setMontant(0);
	}
	
	/**
	 * Constructeur avec montant d'un Taxes
	 * @param i
	 */
	public Taxes(int i){
		this.setMontant(i);
	}
	/**
	 * Constructeur avec montant et Parc d'un Taxes
	 * @param i
	 * @param parc
	 */
	public Taxes(int i, Parc parc) {
		this.setMontant(i);
		this.setParc(parc);
	}
		// SETTER
	/**
	 * Initialsie le parc
	 * @param parc
	 */
	private void setParc(Parc parc) {
		this.parc= parc;

	}

	//GETTER
	/**
	 * Renvoie le montant à payer d'une taxe
	 * @return
	 */
	public int montant(){
		return this.montant;
	}
	
	//SETTER
	/**
	 * Initialise le montant à payer d'une taxe
	 * @param montant
	 * @throws InvalidParameterException
	 */
	public void setMontant(int montant) throws InvalidParameterException{
		if (montant < 0)
			throw new InvalidParameterException("Le montant de la taxe ne peut pas etre negatif.");
		else if (montant==0)
			throw new InvalidParameterException("Une taxe, gratuite ? On veut de l'argent ! Vous allez me faire le plaisir de rentrer un gros nombre plutot.");
		else
			this.montant=montant;
	}
	//METHODES

	/* (non-Javadoc)
	 * Action de la case Taxes
	 * @see plateau.Cases#action(donneesPrincipales.Joueur)
	 */
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
