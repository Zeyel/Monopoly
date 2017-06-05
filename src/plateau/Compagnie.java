package plateau;

import java.util.Scanner;

import carte.De;
import donneesPrincipales.Joueur;
import exception.ProloException;

public class Compagnie extends Proprietes {
	// CONSTRUCTEUR
	public Compagnie(String nom, String couleur, int prix) {
		this.setNom(nom);
		this.setPrix(prix);
		this.setCouleur(couleur);
	}
	// METHODES

	public void action(Joueur j, De de1, De de2) throws ProloException {
		if (this.getProprietaire() == null)
			super.achat(j);
		else if (this.getProprietaire().equals(j))
			System.out.println("Bienvenue chez vous !");
		else
			paiement(j, this.getProprietaire(), de1, de2);
	}

	public void paiement(Joueur perd, Joueur gagn, De dice1, De dice2) throws ProloException {
		if (this.hasFullColor(gagn, "blanc")) {
			int mont = (dice1.getJet() + dice2.getJet() * 10);
			gagn.setArgent(gagn.getArgent() + mont);
			if (perd.getArgent() - mont < 0)
				throw new ProloException(mont);
			perd.setArgent(perd.getArgent() - mont);
		 } else {
			int mont = (dice1.getJet() + dice2.getJet() * 4);
			gagn.setArgent((gagn.getArgent() + mont));
			if (perd.getArgent() - mont < 0)
				throw new ProloException(mont);
			perd.setArgent(perd.getArgent() - mont);
		}
	}
}
