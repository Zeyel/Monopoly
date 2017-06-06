package plateau;

import donneesPrincipales.Joueur;

public class Prison implements Cases {

	public void action(Joueur joueur) {
		if (joueur.getEtatPrison()==-1)
			System.out.println("|Simple visite en prison ! Regardez les prisonniers avec mepris tant que vous n'en faites pas partie !");
		else if (joueur.getEtatPrison()==2)
			System.out.println("|Vous serez obligé de payer lors de votre prochain tour ! ");
		else
			System.out.println("|Vous êtes en prison depuis "+joueur.getEtatPrison()+" tours !");
	}
	
}
