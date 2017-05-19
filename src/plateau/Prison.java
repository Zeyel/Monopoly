package plateau;

import donneesPrincipales.Joueur;

public class Prison implements Cases {

	public void action(Joueur joueur) {
		if (joueur.getEtatPrison()==-1)
			System.out.println("Simple visite en prison ! Regardez les prisonniers avec mepris tant que vous n'en faites pas partie !");
		else if (joueur.getEtatPrison()==3)
			System.out.println("Vous serez oblig� de payer lors de votre prochain tour ! ");
		else
			System.out.println("Vous �tes en prison depuis "+joueur.getEtatPrison()+" tours ! Il vous sera propose de payer pour sortir au debut de votre prochain tour");
	}
	

}
