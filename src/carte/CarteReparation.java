package carte;

import donneesPrincipales.Joueur;
import exception.ProloException;
import plateau.Parc;
import plateau.Proprietes;
import plateau.Terrain;

/**
 * Carte spéciale : Carte Reparation
 * 
 * Demande pour chaque maisons / hôtels un montant à payer
 * @author timbr
 *
 */
public class CarteReparation extends Carte{
	private int montantMaison;
	private int montantHotel;
	
	//CONSTRUCTEUR
	/**
	 * Constructeur de la Carte Reparation
	 * @param descr
	 * @param nom
	 * @param montantMaison
	 * @param montantHotel
	 */
	public CarteReparation (String descr, String nom, int montantMaison, int montantHotel) {
		super.setDescr(descr);
		super.setNom(nom);
		this.setMontantMaison(montantMaison);
		this.setMontantHotel(montantHotel);
	
	}
	
	// GETTER
	/**
	 * Renvoie le nombre de maisons
	 * @return
	 */
	private int getMontantMaison(){
		return this.montantMaison;
	}
	
	/**
	 * Renvoie le nombre d'hôtels
	 * @return
	 */
	private int getMontantHotel(){
		return this.montantHotel;
	}
	
	// SETTER
	/**
	 * Initialise le nombre de maisons
	 * @param montantMaison
	 */
	private void setMontantMaison(int montantMaison) {
		this.montantMaison = montantMaison;
	}

	/**
	 * Initialise le nombre d'hôtels
	 * @param montantHotel
	 */
	private void setMontantHotel(int montantHotel) {
		this.montantHotel = montantHotel;
	}
	
	// METHODES
	/**
	 * Action de la carte Reparation
	 * @param joueur
	 * @param parc
	 * @throws ProloException
	 */
	public void action(Joueur joueur, Parc parc) throws ProloException {
    	System.out.println(getDescr());
		int nbm = 0;
		int nbh = 0;
		for(Terrain P : joueur.getTerrain())
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
		}
	}
}
