package carte;


import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.Scanner;

import donneesPrincipales.Joueur;
import exception.*;

/**
 * Classe spéciale : Carte Gain
 * 
 * Donne ou prend le montant de la classe au joueur
 * @author timbr
 *
 */
public class CarteGain extends Carte {
        private int gain;
        
        // CONSTRUCTEUR
        /**
         * Constructeur de la Carte Gain
         * @param descr
         * @param nom
         * @param g
         */
        public CarteGain(String descr, String nom, int g) {
                this.setDescr(descr);
                this.setNom(nom);
                this.setGain(g);
        }
        // SETTER
        
        /**
         * Initialise le montant du gain / de la perte
         * @param g
         */
        public void setGain(int g) {
                this.gain = g;
        }
        // GETTER
        
        /**
         * Renvoie le montant du gain / de la perte
         * @return
         */
        public int getGain() {
                return this.gain;
        }
        
        /* (non-Javadoc)
         * Action de la carte Gain
         * @see carte.Carte#action(donneesPrincipales.Joueur)
         */
        public void action(Joueur joueur) throws ProloException, ChanceException {
        	System.out.println(getDescr());
   			if (this.nom == "amOuCh") {
       			System.out.println("Souhaitez vous payer l'amende ? (o pour oui / n pour non)");
       			String answer;
       			do {
       				answer = "o";
       				if ((answer != "o") && (answer != "n") && (answer != "O") && (answer != "N") || (joueur.getArgent()-(gain)<0))
       					System.out.println("Saisir uniquement o/n/O/N ou vous n'avez pas assez d'argent pour payer l'amende");
       				
   			} while ((answer != "o") && (answer != "n") && (answer != "O") && (answer != "N")  || (joueur.getArgent()-(gain)<0));
       		if ((answer == "o") || (answer == "O"))
       			joueur.setArgent(joueur.getArgent() + gain);
       		else
       			throw new ChanceException();
   			}	
   			else  if ((joueur.getArgent()+(gain))<0)
                   throw new ProloException(gain);
                joueur.setArgent(joueur.getArgent() + gain);
                System.out.println("|Nouveau solde : "+ joueur.getArgent()+"€");
        }

}