import java.util.ArrayList;
import java.util.Scanner;

import donneesPrincipales.*;
import carte.*;



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
		communaute.addCarte(c); //0
		c = new CarteGain("Erreur de la Banque en votre faveur. Recevez 200€", "errBanque", 200);
		communaute.addCarte(c); //1
		c = new CarteGain("Payez à l'Hopital 100€.", "hopital", -100);
		communaute.addCarte(c); //2
		c = new CarteGain("Les contributions vous remboursent la somme de 20€.", "contributions", 20);
		communaute.addCarte(c); //3
		c = new CarteGain("Recevez votre revenu annuel de 100€.", "annuel", 100);
		communaute.addCarte(c); //4
		c = new CarteGain("La vente de stock vous rapporte 50€.", "stock", 50);
		communaute.addCarte(c); //5
		c = new CarteGain("Vous avez gagné le deuxième Prix de beaute. Recevez 10€.", "beaute", 10);
		communaute.addCarte(c); //6
		c = new CarteGain("Recevez votre interet sur l'emprunt a 7%. 25€.", "interet", 25);
		communaute.addCarte(c); //7
		c = new CarteGain("Payez la note du medecin.", "medecin", -50);
		communaute.addCarte(c); //8
		c = new CarteGain("Vous heritez de 100€.", "heritage", 100);
		communaute.addCarte(c); //9
		c = new CarteGain("Payez une amende de 10€ ou bien tirez une carte \"Chance\"", "amOuCh", -10);
		communaute.addCarte(c); //10
		c = new CarteDeplacement("Avancez jusqu'a la case depart.", "depart", 0);
		communaute.addCarte(c); //11
		c = new CarteDeplacement("Allez en prison, ne passez pas par la case depart.", "goPrison", 9);
		communaute.addCarte(c); //12
		c = new CarteDeplacement("Retournez a Belleville.", "belleville", 1);
		communaute.addCarte(c); //13
		c = new CarteAnniversaire("C'est votre anniversaire, recevez 10€ de tous les joueurs.", "anniversaire", 10);
		communaute.addCarte(c); //14
		c = new LibPrison("Vous etes liberez de prison. Cette carte est conservee jusqu'a utilisation", "libPrisonCommu");
		communaute.addCarte(c);
		
		
		
		for (Joueur j : partie.joueurs){
		System.out.println("Le joueur " + j.getNom() + " tire un premier de et fait un " + de1.JetDe() + " et un second qui fait " + de2.JetDe() + ", " + j.getNom() + " avance donc de " + (de1.getJet()+de2.getJet()) + " cases."); 
		}
	}
}
