import java.util.ArrayList;
import java.util.Scanner;

import DonneesPrincipales.Joueur;
import DonneesPrincipales.Partie;
// import carte.Paquet;
// import carte.Carte;


public class Main {
	
	public static void main (String[] args){
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
	}
}
