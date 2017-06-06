package plateau;

import java.security.InvalidParameterException;
import java.util.Scanner;

import carte.De;
import donneesPrincipales.Joueur;
import exception.ProloException;

public class Compagnie extends Proprietes {
	private De de1;
	private De de2;
	// CONSTRUCTEUR
	public Compagnie(String nom, String couleur, int prix, De de1, De de2) {
		this.setNom(nom);
		this.setPrix(prix);
		this.setCouleur(couleur);
		this.setDe1(de1);
		this.setDe2(de2);
		
	}
	private void setDe1(De de1) {
		this.de1 = de1;
		
	}
	private void setDe2(De de2) {
		this.de2 = de2;
		
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
		
		if (this.hasFullColor(gagn, "blanc")) {
			System.out.println("|Vous êtes sur la propriété de " + gagn.getNom() + ", vous devez donc payer le loyer (" + ((this.de1.getJet() + this.de2.getJet()) * 10) + "€)");
			int mont = ((this.de1.getJet() + this.de2.getJet()) * 10);
			gagn.setArgent(gagn.getArgent() + mont);
			if (perd.getArgent() - mont < 0)
				throw new ProloException(mont);
			perd.setArgent(perd.getArgent() - mont);
		 } else {
			 System.out.println("|Vous êtes sur la propriété de " + gagn.getNom() + ", vous devez donc payer le loyer (" + ((this.de1.getJet() + this.de2.getJet()) * 4) + "€)");
			int mont = (this.de1.getJet() + this.de2.getJet() * 4);
			gagn.setArgent((gagn.getArgent() + mont));
			if (perd.getArgent() - mont < 0)
				throw new ProloException(mont);
			perd.setArgent(perd.getArgent() - mont);
		}
	}
}
