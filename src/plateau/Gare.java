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
		if (this.getProprietaire() == null)
			super.achat(j);
		else if (this.getProprietaire().equals(j))
			System.out.println("Bienvenue chez vous !");
		else
			paiement(j, this.getProprietaire());
	}
	
	public void paiement(Joueur perd, Joueur gagn) throws ProloException {
			System.out.println("Vous �tes sur la propri�t� de " + gagn + ", vous devez donc payer le loyer (" + this.loyer.get(gagn.getNbProp("noir")-1) + "�)");
			int loy = (this.loyer.get(gagn.getNbProp("noir")-1));
			int dette = Math.abs(perd.getArgent()-this.loyer.get(gagn.getNbProp("noir")-1));
			try {
				perd.payerJoueur(this.getProprietaire(), loy);
			}catch (ProloException P){
				perd.GameOver(dette);
			}
		}
	}
