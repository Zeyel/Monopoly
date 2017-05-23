import java.util.ArrayList;
import java.util.Scanner;

import donneesPrincipales.*;
import carte.*;
import plateau.*;



public class Main {
	
	public static void main (String[] args){
		
	// CREATION DU PLATEAU
		Partie partie = new Partie();
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
		for (Joueur j : partie.joueurs){
			System.out.println(j.getNom());
		}
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
		
		Carte c = new CarteGain("Payez votre police d'assurance s'élevant à 50€", "assurance", -50);
		communaute.addCarte(c); //Communaute : 0
		c = new CarteGain("Erreur de la Banque en votre faveur. Recevez 200€", "errBanque", 200);
		communaute.addCarte(c); //Communaute : 1
		c = new CarteGain("Payez à l'Hopital 100€.", "hopital", -100);
		communaute.addCarte(c); //Communaute : 2
		c = new CarteGain("Les contributions vous remboursent la somme de 20€.", "contributions", 20);
		communaute.addCarte(c); //Communaute : 3
		c = new CarteGain("Recevez votre revenu annuel de 100€.", "annuel", 100);
		communaute.addCarte(c); //Communaute : 4
		c = new CarteGain("La vente de stock vous rapporte 50€.", "stock", 50);
		communaute.addCarte(c); //Communaute : 5
		c = new CarteGain("Vous avez gagné le deuxième Prix de beaute. Recevez 10€.", "beaute", 10);
		communaute.addCarte(c); //Communaute : 6
		c = new CarteGain("Recevez votre interet sur l'emprunt a 7%. 25€.", "interet", 25);
		communaute.addCarte(c); //Communaute : 7
		c = new CarteGain("Payez la note du medecin.", "medecin", -50);
		communaute.addCarte(c); //Communaute : 8
		c = new CarteGain("Vous heritez de 100€.", "heritage", 100);
		communaute.addCarte(c); //Communaute : 9
		c = new CarteGain("Payez une amende de 10€ ou bien tirez une carte \"Chance\"", "amOuCh", -10);
		communaute.addCarte(c); //Communaute : 10
		c = new CarteDeplacement("Avancez jusqu'a la case depart.", "depart", 0);
		communaute.addCarte(c); //Communaute : 11
		chance.addCarte(c); // Chance 0
		c = new CarteDeplacement("Allez en prison, ne passez pas par la case depart.", "goPrison", 9);
		communaute.addCarte(c); //Communaute : 12
		chance.addCarte(c); //Chance : 1
		c = new CarteDeplacement("Retournez a Belleville.", "belleville", 1);
		communaute.addCarte(c); //Communaute : 13
		c = new CarteAnniversaire("C'est votre anniversaire, recevez 10€ de tous les joueurs.", "anniversaire", 10);
		communaute.addCarte(c); //Communaute : 14
		c = new LibPrison("Vous etes liberez de prison. Cette carte est conservee jusqu'a utilisation", "libPrisonCommu");
		communaute.addCarte(c); // Communaute : 15
		chance.addCarte(c); //Chance : 2  
		c = new CarteGain("Vous avez gagné le prix de mots croises. Recevez 100€", "croises", 100);
		chance.addCarte(c); //Chance : 3
		c = new CarteGain("Votre immeuble et votre pret rapportent. Vous touchez 150€", "transfert", 150);
		chance.addCarte(c); //Chance : 4
		c = new CarteGain("Payez pour les frais de scolarité 150€", "scolarite", -150);
		chance.addCarte(c); //Chance : 5
		c = new CarteReparation("Vous etes impose pour des reparations de voirie a raison de 40€ par maisons et de 115€ par hotel", "voirie", 40, 115);
		chance.addCarte(c); //Chance : 6
		c = new CarteReparation("Faites des reparations dans toutes vos maisons. Versez 25€ pour chaque maison et 100€ par hotel", "reparatiion", 25, 100);
		chance.addCarte(c); //Chance : 7
		c = new CarteGain("La Banque vous verse un dividende de 50€", "dividende", 50);
		chance.addCarte(c); //Chance : 8
		c = new CarteGain("Amende pour ivresse : 20€", "ivresse", 20);
		chance.addCarte(c); //Chance : 9
		c = new CarteGain("Amende pour exces de vitesse : 15€", "vitesse", 15);
		chance.addCarte(c); //Chance : 10
		c = new CarteDeplacement("Rendez vous a l'Avenue Henri-Martin. Si vous passez par la case depart, recevez 200€", "henri", 24);
		chance.addCarte(c); //Chance : 11
		c = new CarteDeplacement("Rendez vous a la Rue de la Paix", "ggwp", 39);
		chance.addCarte(c); //Chance : 12
		c = new CarteDeplacement("Avancez au Boulevard de la Villette, si vous passez par la case depart, recevez 200€", "villette", 11);
		chance.addCarte(c); //Chance : 13
		c = new CarteDeplacement("Allez a la gare de Lyon, si vous passez par la case depart, recevez 200€", "lyon", 15);
		chance.addCarte(c); //Chance : 14
		c = new CarteDeplacement("Reculez de trois cases", "reculer", 0);
		chance.addCarte(c); //Chance : 15
		partie.setChance(chance);
		partie.setCommunaute(communaute);
		// CREATION DU PLATEAU
		
		Cases p = new Terrain("Rue de la Paix", "bleu", 400, 50, 200, 600, 1400, 1700, 2000);
		partie.addCase(p);	// Case 39
		p = new Taxes(100);
		partie.addCase(p);	// Case 38
		p = new Terrain("Avenue des Champs-Elysees", "bleu", 350, 35, 175, 500, 1100, 1300, 1500);
		partie.addCase(p); 	// Case 37
		p = new Tirer()
		
		
		
		
		for (Joueur j : partie.joueurs){
		System.out.println("Le joueur " + j.getNom() + " tire un premier de et fait un " + de1.JetDe() + " et un second qui fait " + de2.JetDe() + ", " + j.getNom() + " avance donc de " + (de1.getJet()+de2.getJet()) + " cases."); 
		}
	}
}
