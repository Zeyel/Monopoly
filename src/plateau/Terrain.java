package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import donneesPrincipales.Joueur;
import exception.ProloException;

public class Terrain extends Proprietes{
	private ArrayList<Integer> loyer;
	private int nbMaisons;
	
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
	
	public ArrayList<Integer> getLoyer() throws InvalidParameterException {
		if (this.loyer == null)
			throw new InvalidParameterException("La liste est vide");
		return this.loyer;
	}
	
	public int getNbMaisons() {
		return this.nbMaisons;
	}
	// SETTERS
	public void setNbMaisons(int nbMaisons) throws InvalidParameterException{
		if((nbMaisons<0)||(nbMaisons>5))
			throw new InvalidParameterException("Une gare et/ou une compagnie ne peut avoir de maison");
		this.nbMaisons = nbMaisons;
	}
	
	// METHODES
	
	public void action(Joueur j) throws ProloException {
		if (this.getProprietaire() == null)
			super.achat(j);
		else if (this.getProprietaire().equals(j))
			System.out.println("Bienvenue chez vous !");
		else
			paiement(j, this.getProprietaire());
	}
	public void paiement(Joueur perd, Joueur gagn) throws ProloException {
		System.out.println("Vous êtes sur la propriété de " + gagn + ", vous devez donc payer le loyer (" + this.loyer.get(gagn.getNbProp(this.getCouleur())-1) + "€)");
		if (this.hasFullColor(gagn, this.getCouleur())){
			if (this.getNbMaisons() == 0)
				perd.payerJoueur(gagn, (this.loyer.get(0)*2));
			else
				perd.payerJoueur(gagn, this.loyer.get(this.nbMaisons));
		} else
			perd.payerJoueur(gagn,  this.loyer.get(0));
			
		}
	}
