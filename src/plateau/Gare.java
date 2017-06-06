package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import carte.De;
import donneesPrincipales.Joueur;
import exception.ProloException;

/**
 * Classe simulant les gares
 * Si elle n'a pas de propriétaire : Le joueur s'y arrêtant peut l'acheter
 * Si elle en a un : Si c'est le joueur s'y arrêtant, il ne se passe rien.
 * Si c'est un autre joueur, le joueur lui doit 25* le nombre de gare du joueur
 * @author timbr
 *
 */
public class Gare extends Proprietes{
	private ArrayList<Integer> loyer;
	
	/**
	 * Constructeur de base d'une gare
	 * @param nom
	 * @param couleur
	 * @param prix
	 * @param i
	 */
	public Gare(String nom, String couleur, int prix, Integer ...i) {
		super.setNom(nom);
		super.setCouleur(couleur);
		super.setPrix(prix);
		this.loyer = new ArrayList<Integer>();
		for (int loy : i)
			this.loyer.add(loy);
	}
	
	// GETTERS
	
	/**
	 * Renvoie le loyer en ArrayList
	 * @return
	 * @throws InvalidParameterException
	 */
	public ArrayList<Integer> getLoyer() throws InvalidParameterException {
		if (this.loyer == null)
			throw new InvalidParameterException("La liste est vide");
		return this.loyer;
	}
	
	// METHODES
	
	/* (non-Javadoc)
	 * Action de la carte Gare
	 * @see plateau.Proprietes#action(donneesPrincipales.Joueur)
	 */
	public void action(Joueur j) throws ProloException {
		try{
			this.getProprietaire();
		} catch(InvalidParameterException e) {
			super.achat(j);
		}
		 if (this.proprietaire == null)
		 		System.out.println("|Vous passez simplement sur "+ this.getNom() +".");
			 else if((this.proprietaire!=null) && (this.proprietaire !=j))
				 paiement(j, this.proprietaire);
			 else if (this.proprietaire.equals(j))
				 System.out.println("|Bienvenue chez vous !("+this.getNom()+")");
	}
	
	/**
	 * Procédure de paiement du joueur perd vers le joueur gagn, renvoie ProloException si le paiement ne peut être effectué
	 * @param perd
	 * @param gagn
	 * @throws ProloException
	 */
	public void paiement(Joueur perd, Joueur gagn) throws ProloException {
			System.out.println("|Vous êtes sur la propriété de " + gagn.getNom() + ", vous devez donc payer le loyer (" + this.loyer.get(gagn.getNbProp("noir")-1) + "€)");
			int loy = (this.loyer.get(gagn.getNbProp("noir")-1));
			int dette = Math.abs(perd.getArgent()-this.loyer.get(gagn.getNbProp("noir")-1));
			try {
				perd.payerJoueur(this.getProprietaire(), loy);
			}catch (ProloException P){
				perd.GameOver(dette);
			}
		}
	}
