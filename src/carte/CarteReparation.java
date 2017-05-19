<<<<<<< HEAD
package carte;

import donneesPrincipales.Joueur;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CarteReparation extends Carte{
	private int montantMaison;
	private int montantHotel;
	public CarteReparation (String descr, String nom, int montantMaison, int montantHotel) {
		super.setDescr(descr);
		super.setNom(nom);
		this.setMontantMaison(montantMaison);
		this.setMontantHotel(montantHotel);
	
	}
	
	// GETTER
	private int getMontantMaison(){
		return this.montantMaison;
	}
	
	private int getMontantHotel(){
		return this.montantHotel;
	}
	
	// SETTER
	private void setMontantMaison(int montantMaison) {
		this.montantMaison = montantMaison;
	}

	private void setMontantHotel(int montantHotel) {
		this.montantHotel = montantHotel;
	}
	
	// METHODES
	private void action(Joueur joueur, ArrayList<Integer> proprietes) {
			
	}
}
=======
package carte;

import donneesPrincipales.Joueur;
import exception.ProloException;
import plateau.Parc;
import plateau.Proprietes;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CarteReparation extends Carte{
	private int montantMaison;
	private int montantHotel;
	public CarteReparation (String descr, String nom, int montantMaison, int montantHotel) {
		super.setDescr(descr);
		super.setNom(nom);
		this.setMontantMaison(montantMaison);
		this.setMontantHotel(montantHotel);
	
	}
	
	// GETTER
	private int getMontantMaison(){
		return this.montantMaison;
	}
	
	private int getMontantHotel(){
		return this.montantHotel;
	}
	
	// SETTER
	private void setMontantMaison(int montantMaison) {
		this.montantMaison = montantMaison;
	}

	private void setMontantHotel(int montantHotel) {
		this.montantHotel = montantHotel;
	}
	
	// METHODES
	private void action(Joueur joueur, Parc parc) throws ProloException {
		int nbm = 0;
		int nbh = 0;
		for(Proprietes P : joueur.getProprietes())
			if (P.getNbMaisons() == 5) {
				nbh += 1;
			}
			else {
				nbm += P.getNbMaisons();
			}
		try {
			int loy = (nbm*getMontantMaison())+(nbh*getMontantHotel());
			joueur.payerParc(loy, parc);
		} catch (ProloException p) {
			joueur.GameOver(joueur.getArgent()-((nbm*getMontantMaison())+(nbh*getMontantHotel())));
		};
	}
}
>>>>>>> origin/master