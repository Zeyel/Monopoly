package carte;


import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.Scanner;

import donneesPrincipales.Joueur;
import exception.*;

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
        
        public void action(Joueur joueur) throws ProloException, ChanceException {
        	
   			if (this.nom == "amOuCh") {
       			Scanner sc = new Scanner(System.in);
       			System.out.println("Souhaitez vous payer l'amende ? (o pour oui / n pour non)");
       			String answer;
       			do {
       				answer = sc.nextLine();
       				if ((answer != "o") && (answer != "n") && (answer != "O") && (answer != "N") || (joueur.getArgent()-(gain)<0))
       					System.out.println("Saisir uniquement o/n/O/N ou vous n'avez pas assez d'argent pour payer l'amende");
       				
   			} while ((answer != "o") && (answer != "n") && (answer != "O") && (answer != "N")  || (joueur.getArgent()-(gain)<0));
       		sc.close();
       		if ((answer == "o") || (answer == "O"))
       			joueur.setArgent(joueur.getArgent() + gain);
       		else
       			throw new ChanceException();
   			}	
   			else  if ((joueur.getArgent()+(gain))<0)
                   throw new ProloException(gain);
                joueur.setArgent(joueur.getArgent() + gain);
        }

}