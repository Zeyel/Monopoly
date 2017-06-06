import java.util.Scanner;

import donneesPrincipales.*;
import exception.ChanceException;
import exception.FinDePartieException;
import carte.*;
import plateau.*;



/**
 * main du Monopoly
 * @author timbr
 *
 */
public class Main {
	
	/**
	 * Initialisation de la partie pour une partie normale
	 * @param partie
	 */
	public static void initialisation(Partie partie){
		// CREATION DES JOUEURS ET AJOUT DES JOUEURS DANS LE PLATEAU
		Scanner sc = new Scanner(System.in);
		int nb;
		do {
			System.out.println("De combien de joueurs se compose la partie ?");
			nb = sc.nextInt();
			
		if ((nb > 4) || (nb<0))
			System.out.println("Le nombre de joueurs doit être compris entre 2 et 4");
		} while ((nb > 4) || (nb < 2));
		for (int i = 0; i<nb+1 ; i++){
			String nom = sc.nextLine();
			if (i != nb)
				System.out.println("Quel sera le nom du Joueur " + (i+1) + " ?");
			Joueur joueur = new Joueur(nom);
			partie.addJoueur(joueur);
		}
			partie.bidouillage();
		sc.close();
		
	// CREATION DES DE ET AJOUT DES DES
		De de1 = new De();
		De de2 = new De();
		partie.addDe(de1);
		partie.addDe(de2);
		
	// CREATION DES PAQUETS
		Paquet communaute = new Paquet();
		Paquet chance = new Paquet();
		
	// CREATION DES CARTES
		// PAQUET COMMUNAUTE
		communaute.addCarte(new CarteGain("|Payez votre police d'assurance s'élevant à 50€", "assurance", -50)); 		//Communaute : 0
		communaute.addCarte(new CarteGain("|Erreur de la Banque en votre faveur. Recevez 200€", "errBanque", 200)); 		//Communaute : 1
		communaute.addCarte(new CarteGain("|Payez à l'Hopital 100€.", "hopital", -100)); 								//Communaute : 2
		communaute.addCarte(new CarteGain("|Les contributions vous remboursent la somme de 20€.", "contributions", 20)); //Communaute : 3
		communaute.addCarte(new CarteGain("|Recevez votre revenu annuel de 100€.", "annuel", 100));						//Communaute : 4
		communaute.addCarte(new CarteGain("|La vente de stock vous rapporte 50€.", "stock", 50)); 						//Communaute : 5
		communaute.addCarte(new CarteGain("|Vous avez gagné le deuxième Prix de beaute. Recevez 10€.", "beaute", 10)); 	//Communaute : 6
		communaute.addCarte(new CarteGain("|Recevez votre interet sur l'emprunt a 7%. 25€.", "interet", 25)); 			//Communaute : 7
		communaute.addCarte(new CarteGain("|Payez la note du medecin.", "medecin", -50)); 								//Communaute : 8
		communaute.addCarte(new CarteGain("|Vous heritez de 100€.", "heritage", 100)); 									//Communaute : 9
		communaute.addCarte(new CarteGain("|Payez une amende de 10€ ou bien tirez une carte \"Chance\"", "amOuCh", -10));//Communaute : 10
		communaute.addCarte(new CarteDeplacement("|Avancez jusqu'a la case depart.", "depart", 0)); 						//Communaute : 11
		communaute.addCarte(new CarteDeplacement("|Allez en prison, ne passez pas par la case depart.", "goPrison", 10)); //Communaute : 12
		communaute.addCarte(new CarteDeplacement("|Retournez a Belleville.", "belleville", 1)); 							//Communaute : 13
		communaute.addCarte(new CarteAnniversaire("|C'est votre anniversaire, recevez 10€ de tous les joueurs.", "anniversaire", 10)); //Communaute : 14
		communaute.addCarte(new LibPrison("|Vous etes liberez de prison. Cette carte est conservee jusqu'a utilisation", "libPrisonCommu")); // Communaute : 15
		// PAQUET CHANCE
		chance.addCarte(new CarteDeplacement("|Avancez jusqu'a la case depart.", "depart", 0)); 												//Chance 0
		chance.addCarte(new CarteDeplacement("|Allez en prison, ne passez pas par la case depart.", "goPrison", 10)); 						//Chance : 1
		chance.addCarte(new LibPrison("|Vous etes liberez de prison. Cette carte est conservee jusqu'a utilisation", "libPrisonChance")); 	//Chance : 2  
		chance.addCarte(new CarteGain("|Vous avez gagné le prix de mots croises. Recevez 100€", "croises", 100)); 							//Chance : 3
		chance.addCarte(new CarteGain("|Votre immeuble et votre pret rapportent. Vous touchez 150€", "transfert", 150)); 					//Chance : 4
		chance.addCarte(new CarteGain("|Payez pour les frais de scolarité 150€", "scolarite", -150)); 										//Chance : 5
		chance.addCarte(new CarteReparation("|Vous etes impose pour des reparations de voirie a raison de 40€ par maisons et de 115€ par hotel", "voirie", 40, 115)); //Chance : 6
		chance.addCarte(new CarteReparation("|Faites des reparations dans toutes vos maisons. Versez 25€ pour chaque maison et 100€ par hotel", "reparation", 25, 100)); //Chance : 7
		chance.addCarte(new CarteGain("|La Banque vous verse un dividende de 50€", "dividende", 50)); 										//Chance : 8
		chance.addCarte(new CarteGain("|Amende pour ivresse : 20€", "ivresse", 20)); 														//Chance : 9
		chance.addCarte(new CarteGain("|Amende pour exces de vitesse : 15€", "vitesse", 15)); 												//Chance : 10
		chance.addCarte(new CarteDeplacement("|Rendez vous a l'Avenue Henri-Martin. Si vous passez par la case depart, recevez 200€", "henri", 24)); //Chance : 11
		chance.addCarte(new CarteDeplacement("|Rendez vous a la Rue de la Paix", "ggwp", 39)); 												//Chance : 12
		chance.addCarte(new CarteDeplacement("|Avancez au Boulevard de la Villette, si vous passez par la case depart, recevez 200€", "villette", 11)); //Chance : 13
		chance.addCarte(new CarteDeplacement("|Allez a la gare de Lyon, si vous passez par la case depart, recevez 200€", "lyon", 15)); 		//Chance : 14
		chance.addCarte(new CarteDeplacement("|Reculez de trois cases", "reculer", 0)); 														//Chance : 15
		// AJOUT DES PAQUETS AU PLATEAU
		partie.setChance(chance);
		partie.setCommunaute(communaute);
		Parc parc  = new Parc();
		// CREATION DU PLATEAU
		partie.addCase(new Depart());																						// Case 0
		partie.addCase(new Terrain("Boulevard de Belleville", "rose", 60, 2, 10, 30, 90, 160, 250));						// Case 1
		partie.addCase(new Tirer(communaute)); 																				// Case 2
		partie.addCase(new Terrain("Rue Lecourbe", "rose", 60, 4, 20, 60, 180, 320, 450)); 									// Case 3
		partie.addCase(new Taxes(200, parc));																				// Case 4
		partie.addCase(new Gare("Gare Montparnasse", "noir", 200, 25, 50, 100, 200));										// Case 5
		partie.addCase(new Terrain("Rue de Vaugirard", "ciel", 100, 6, 30, 90, 270, 400, 550)); 							// Case 6
		partie.addCase(new Tirer(chance));																					// Case 7
		partie.addCase(new Terrain("Rue de Courcelles", "ciel", 100, 6, 30, 90, 270, 400, 550));							// Case 8
		partie.addCase(new Terrain("Avenue de la Republique", "ciel", 120, 8, 40, 100, 300, 450, 600));						// Case 9
		partie.addCase(new Prison());																						// Case 10
		partie.addCase(new Terrain("Boulevard de la Villette", "rose", 140, 10, 50, 150, 450, 625, 700));					// Case 11
		partie.addCase(new Compagnie("Compagnie de Distribution de l'electricite", "blanc", 150, de1, de2));				// Case 12
		partie.addCase(new Terrain("Avenue de Neuilly", "rose", 140, 10, 50, 150, 450, 625, 750));							// Case 13
		partie.addCase(new Terrain("Rue de Paradis", "rose", 160, 12, 60, 180, 500, 700, 900));								// Case 14
		partie.addCase(new Gare("Gare de Lyon", "noir", 200, 25, 50, 100, 200));											// Case 15
		partie.addCase(new Terrain("Avenue Mozart", "orange", 180, 14, 70, 200, 550, 750, 950));							// Case 16
		partie.addCase(new Tirer(communaute));																				// Case 17
		partie.addCase(new Terrain("Boulevard Saint-Michel", "orange", 180, 14, 70, 200, 550, 750, 950));					// Case 18
		partie.addCase(new Terrain("Place Pigalle", "orange", 200, 16, 80, 220, 600, 800, 1000));							// Case 19
		partie.addCase(parc);																								// Case 20
		partie.addCase(new Terrain("Avenue Matignon", "rouge", 220, 18, 90, 250, 700, 875, 1050));							// Case 21
		partie.addCase(new Tirer(chance));																					// Case 22
		partie.addCase(new Terrain("Boulevard Malesherbes", "rouge", 220, 18, 90, 250, 700, 875, 1050));					// Case 23
		partie.addCase(new Terrain("Avenue Henri-Martin", "rouge", 240, 20, 100, 300, 750, 925, 1100));					// Case 24
		partie.addCase(new Gare("Gare du Nord", "noir", 200, 25, 50, 100, 200));											// Case 25
		partie.addCase(new Terrain("Faubourg Saint-Honore", "jaune", 260, 22, 110, 330, 800, 975, 1150));					// Case 26
		partie.addCase(new Terrain("Place de la bourse", "jaune", 260, 22, 110, 330, 800, 975, 1150));						// Case 27
		partie.addCase(new Compagnie("Compagnie de distribution des eaux", "blanc", 150, de1, de2));						// Case 28
		partie.addCase(new Terrain("Rue La Fayette", "jaune", 280, 24, 120, 360, 850, 1025, 1200));							// Case 29
		partie.addCase(new AllerPrison());																					// Case 30
		partie.addCase(new Terrain("Avenue de Breteuil", "vert", 300, 26, 130, 390, 900, 1100, 1275));						// Case 31
		partie.addCase(new Terrain("Avenue Foch", "vert", 300, 26, 130, 390, 900, 1100, 1275));								// Case 32
		partie.addCase(new Tirer(communaute));																				// Case 33
		partie.addCase(new Terrain("Boulevard des Capucines", "vert", 320, 28, 150, 450, 1000, 1200, 1400));				// Case 34
		partie.addCase(new Gare("Gare Saint-Lazare", "noir", 200, 25, 50, 100, 200));										// Case 35
		partie.addCase(new Tirer(chance));																					// Case 36
		partie.addCase(new Terrain("Avenue des Champs-Elysees", "bleu", 350, 35, 175, 500, 1100, 1300, 1500)); 				// Case 37
		partie.addCase(new Taxes(100, parc));																				// Case 38
		partie.addCase(new Terrain("Rue de la Paix", "bleu", 400, 50, 200, 600, 1400, 1700, 2000));							// Case 39

	}
	
	/**
	 * Initialisation de la partie sur 16 cases. Exception normale car absence de 40 cases
	 * @param partie
	 */
	public static void initialisation3(Partie partie) {
		partie.addJoueur(new Joueur("Tim"));
		partie.addJoueur(new Joueur("Jeff"));
		
		partie.addDe(new De(1, 1));
		partie.addDe(new De(0, 0));
		Parc parc = new Parc();
		partie.addCase(new Depart());
		partie.addCase(new Taxes(100, parc));
		partie.addCase(new Terrain ("Boulevard de Belleville", "rose", 60, 2, 10, 30, 90, 160, 250));
		partie.addCase(new Terrain ("Rue Lecourbe", "rose", 60, 4, 20, 60, 180, 360, 450));
		partie.addCase(new Taxes(200, parc));
		partie.addCase(parc);
		partie.addCase(new Taxes(1000, parc));
		partie.addCase(new Terrain ("Rue de la Paix", "bleu", 400, 50, 200, 600, 1400, 1700, 2000));
		partie.addCase(new Depart());
		partie.addCase(new Gare ("Gare de Lyon", "noir", 200, 25, 50, 100, 200));
		partie.addCase(new Gare ("Gare du nord", "noir", 200, 25, 50, 100, 200));
		partie.addCase(new Gare ("Gare de l'est", "noir", 200, 25, 50, 100, 200));
		partie.addCase(new Depart());
		partie.addCase(new Depart());
		partie.addCase(new Compagnie("Compagnie de distribution de l'electricite","blanc", 150, partie.getDe(0), partie.getDe(1)));
		partie.addCase(new Compagnie("Compagnie de distribution de l'eau","blanc", 150, partie.getDe(0), partie.getDe(1)));
	}
	
	public static void main (String[] args) throws ChanceException{
		
	// CREATION DU PLATEAU
		Partie partie = new Partie();
		initialisation(partie);
		while (partie.getNbGameOver() != partie.joueurs.size()-1) {
		for (Joueur j : partie.joueurs) {
			System.out.println("----------------------------------------------------");
			if (!(j.getGameOver())){
				System.out.println("| C'est au tour du joueur "+ j.getNom() + "(Solde : "+ j.getArgent()+"€), Position : "+j.getPos());
				partie.tourJoueur(j);
				System.out.println("| \n");
				}
			System.out.println("|\n");
			System.out.println("----------------------------------------------------");
			}
		}
		try {
			partie.finDePartie();
		} catch (FinDePartieException e) {
			System.out.print("Le joueur " + e.getJoueur().getNom() + " a gagné ! Bravo à lui !");
		}
	}
}
