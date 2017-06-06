package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import donneesPrincipales.Joueur;
import exception.ProloException;

/**
 * Classe simulant un Terrain du plateau de jeu, hérite de Proprietes
 * @author timbr
 *
 */
public class Terrain extends Proprietes{
	private ArrayList<Integer> loyer;
	private int nbMaisons;
	
	/**
	 * Constructeur d'un terrain
	 * @param nom
	 * @param couleur
	 * @param prix
	 * @param i
	 */
	public Terrain (String nom, String couleur, int prix, Integer ...i){
		super.setNom(nom);
		super.setCouleur(couleur);
		super.setPrix(prix);
		this.loyer = new ArrayList<Integer>();
		this.nbMaisons = 0;
		for (int loy : i)
			this.loyer.add(loy);
	}
	
	// GETTERS
	
	/**
	 * Renvoie sous forme d'ArrayList le loyer du Terrain
	 * @return
	 * @throws InvalidParameterException
	 */
	public ArrayList<Integer> getLoyer() throws InvalidParameterException {
		if (this.loyer == null)
			throw new InvalidParameterException("La liste est vide");
		return this.loyer;
	}
	
	/**
	 * Renvoie le nombre de maisons de la case
	 * @return
	 */
	public int getNbMaisons() {
		return this.nbMaisons;
	}
	// SETTERS
	/**
	 * Initialise le nombre de maisons
	 * @param nbMaisons
	 * @throws InvalidParameterException
	 */
	public void setNbMaisons(int nbMaisons) throws InvalidParameterException{
		if((nbMaisons<0)||(nbMaisons>5))
			throw new InvalidParameterException("Une gare et/ou une compagnie ne peut avoir de maison");
		this.nbMaisons = nbMaisons;
	}
	
	// METHODES
	
	/* (non-Javadoc)
	 * Action de la case Terrain
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
		System.out.println("|Vous êtes sur la propriété de " + gagn.getNom() + ", vous devez donc payer le loyer (" + this.loyer.get(gagn.getNbProp(this.getCouleur())-1) + "€)");
		if (this.hasFullColor(gagn, this.getCouleur())){
			if (this.getNbMaisons() == 0)
				perd.payerJoueur(gagn, (this.loyer.get(0)*2));
			else
				perd.payerJoueur(gagn, this.loyer.get(this.nbMaisons));
		} else
			perd.payerJoueur(gagn, this.loyer.get(0));
			
		}
	}
