package plateau;

import donneesPrincipales.Joueur;

/**
 * Classe simulant la prison
 * Si l'EtatPrison est de -1 quand il y passe, c'est une simple visite
 * Si l'EtatPrison est de 0 à 2, le joueur est en prison, il peut payer l'amende pour sortir plus tôt
 * Si l'EtatPrison est de 3, le joueur sera obligé de payer l'amende pour sortir
 * @author timbr
 *
 */
public class Prison implements Cases {

	
	/* (non-Javadoc)
	 * Action de la case Prison
	 * @see plateau.Cases#action(donneesPrincipales.Joueur)
	 */
	public void action(Joueur joueur) {
		if (joueur.getEtatPrison()==-1)
			System.out.println("|Simple visite en prison ! Regardez les prisonniers avec mepris tant que vous n'en faites pas partie !");
		else if (joueur.getEtatPrison()==2)
			System.out.println("|Vous serez obligé de payer lors de votre prochain tour ! ");
		else
			System.out.println("|Vous êtes en prison depuis "+joueur.getEtatPrison()+" tours !");
	}
	
}
