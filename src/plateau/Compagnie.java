package plateau;

import java.security.InvalidParameterException;
import java.util.Scanner;

import carte.De;
import donneesPrincipales.Joueur;
import exception.ProloException;

/**
 * Classe simulant les Compagnie
 * Si elle n'a pas de propriétaire : Le joueur peut l'acheter en tombant dessus
 * Si elle en a un : Si c'est le joueur s'y arrêtant, il ne se passe rien.
 * Si elle ne lui appartien pas, le joueur lui doit JetDe * 4 si il en possède une, JetDe * 10 si il possède les deux
 * @author timbr
 *
 */
public class Compagnie extends Proprietes {
	private De de1;
	private De de2;
	// CONSTRUCTEUR
	/**
	 * Constructeur de Compagnie
	 * @param nom
	 * @param couleur
	 * @param prix
	 * @param de1
	 * @param de2
	 */
	public Compagnie(String nom, String couleur, int prix, De de1, De de2) {
		this.setNom(nom);
		this.setPrix(prix);
		this.setCouleur(couleur);
		this.setDe1(de1);
		this.setDe2(de2);
		
	}
	/**
	 * Initialise le dé n°1
	 * @param de1
	 */
	private void setDe1(De de1) {
		this.de1 = de1;
		
	}
	/**
	 * Initialise le dé n°2
	 * @param de2
	 */
	private void setDe2(De de2) {
		this.de2 = de2;
		
	}
	// METHODES

	/* (non-Javadoc)
	 * Action de la Compagnie
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
