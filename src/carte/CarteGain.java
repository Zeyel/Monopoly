package carte;


import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.Scanner;

import donneesPrincipales.Joueur;

/**
 * Classe définissant les cartes piochées ayant un impact direct sur l'argent du joueur
 * 
 * 
 */

public class CarteGain extends Carte {
        private int gain;
        
        public CarteGain(String descr, String nom, int g) {
                this.setDescr(descr);
                this.setNom(nom);
                this.setGain(g);
        }

        public void setGain(int g) {
                this.gain = g;
        }
        
        public int getGain() {
                return this.gain;
        }
        
        public void action(Joueur joueur) {
        	
   			if (this.nom == "amOuCh") {
       			Scanner sc = new Scanner(System.in);
       			System.out.println("Souhaitez vous payer l'amende ? (o pour oui / n pour non)");
       			String answer;
       			do {
       				answer = sc.nextLine();
       				if ((answer != "o") && (answer != "n") && (answer != "O") && (answer != "N"))
       					System.out.println("Saisir uniquement o/n/O/N");
       				
   			} while ((answer != "o") && (answer != "n") && (answer != "O") && (answer != "N"));
        	
       			
       			// TODO URGENT
                if ((joueur.getArgent()-(gain))<0)
                   //     joueur.setGameOver(true);
                joueur.setArgent(joueur.getArgent() + gain);
        }

        }
}