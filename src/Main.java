import java.util.ArrayList;
import java.util.Scanner;

import donneesPrincipales.Joueur;
import donneesPrincipales.Partie;

import carte.De;



public class Main {
	
	public static void main (String[] args){
		// CREATION DES JOUEURS
		Scanner sc = new Scanner(System.in);
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
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
			joueurs.add(joueur);
		}
		for (Joueur j : joueurs){
			System.out.println(j.getNom());
		}
		sc.close();
		
		// CREATION DES DE
		De de1 = new De();
		De de2 = new De();
		
		// CREATION DU PLATEAU
		
		Partie partie = new Partie();
		
		for (Joueur j : joueurs){
		System.out.println("Le joueur " + j.getNom() + " tire un premier de et fait un " + de1.JetDe() + " et un second qui fait " + de2.JetDe() + ", " + j.getNom() + " avance donc de " + (de1.getJet()+de2.getJet()) + " cases."); 
		}
	}
}
