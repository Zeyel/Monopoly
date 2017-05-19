package plateau;

import donneesPrincipales.Joueur;

public class Parc implements Cases{
	private int jackpot;
	
	
	// CONSTRUCTEUR
	
	public Parc(){
		this.setJackpot(0);
	}
	
	// GETTER
	
	public int getJackpot(){
		return this.jackpot;
	}
	
	// SETTER
	
	public void setJackpot(int i) {
		this.jackpot = i;
	}
	
	// METHODES
	
	public void action(Joueur joueur) {
		System.out.println("Vous etes tombe sur le parc gratuit ! JACKPOT !!");
		if (this.jackpot==0)
			System.out.println("Oh mais attendez, le parc ne contient pas d'argent... Dommage, reessayez plus tard !");
		else {
			joueur.setArgent(joueur.getArgent()+this.jackpot);
			System.out.println("Vous avez gagne la somme de "+this.jackpot+" ! Votre nouveau solde est de "+joueur.getArgent());
			this.setJackpot(0);
		}
	}
	
}
