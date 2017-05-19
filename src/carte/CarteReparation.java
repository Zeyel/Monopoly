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
