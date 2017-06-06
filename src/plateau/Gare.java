package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import carte.De;
import donneesPrincipales.Joueur;
import exception.ProloException;

public class Gare extends Proprietes{
	private ArrayList<Integer> loyer;
	
	public Gare(String nom, String couleur, int prix, Integer ...i) {
		super.setNom(nom);
		super.setCouleur(couleur);
		super.setPrix(prix);
		this.loyer = new ArrayList<Integer>();
		for (int loy : i)
			this.loyer.add(loy);
	}
	
	// GETTERS
	
	public ArrayList<Integer> getLoyer() throws InvalidParameterException {
		if (this.loyer == null)
			throw new InvalidParameterException("La liste est vide");
		return this.loyer;
	}
	
	// METHODES
	
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
