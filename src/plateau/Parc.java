package plateau;

import donneesPrincipales.Joueur;

/**
 * Classe simulant le parc gratuit, si le joueur s'y arrête, il en récupère son contenu
 * @author timbr
 *
 */
public class Parc implements Cases{
	private int jackpot;
	
	
	// CONSTRUCTEUR
	
	/**
	 * Constructeur par défaut d'un parc
	 */
	public Parc(){
		this.setJackpot(0);
	}
	
	// GETTER
	
	/**
	 * Renvoie le montant du jackpot
	 * @return
	 */
	public int getJackpot(){
		return this.jackpot;
	}
	
	// SETTER
	
	/**
	 * Initialise le montant du jackpot
	 * @param i
	 */
	public void setJackpot(int i) {
		this.jackpot = i;
	}
	
	// METHODES
	
	/* (non-Javadoc)
	 * Action de la case Parc
	 * @see plateau.Cases#action(donneesPrincipales.Joueur)
	 */
	public void action(Joueur joueur) {
		System.out.println("|Vous etes tombe sur le parc gratuit ! JACKPOT !!");
		if (this.jackpot==0)
			System.out.println("|Oh mais attendez, le parc ne contient pas d'argent... Dommage, reessayez plus tard !");
		else {
			joueur.setArgent(joueur.getArgent()+this.jackpot);
			System.out.println("|Vous avez gagne la somme de "+this.jackpot+" ! Votre nouveau solde est de "+joueur.getArgent());
			this.setJackpot(0);
		}
	}
	
}
