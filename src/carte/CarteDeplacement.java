package carte;

import donneesPrincipales.Joueur;

import java.security.InvalidParameterException;


/**
 * Classe spéciale : Carte de déplacement
 * 
 * Déplace le joueur à la case prévue par la carte
 * @author timbr
 *
 */
public class CarteDeplacement extends Carte{
        private int caseArrivee;
        
        // CONSTRUCTEUR
        /**
         * Constructeur de la Carte Deplacement
         * @param descr
         * @param nom
         * @param caseArrivee
         */
        public CarteDeplacement(String descr, String nom, int caseArrivee) {
                this.setDescr(descr);
                this.setNom(nom);
                this.setCaseArrivee(caseArrivee);
        }
        
        // SETTER

        /**
         * Initialise la case d'arrivée de la carte Deplacement
         * @param caseArrivee
         */
        private void setCaseArrivee(int caseArrivee) {
                this.caseArrivee = caseArrivee;
        }
        
        /**
         * Renvoie la case d'arrivée de la carte Deplacement
         * @return
         */
        private int getCaseArrivee() {
                return this.caseArrivee;
        }
        
        /* (non-Javadoc)
         * Action de la carte Deplacement
         * @see carte.Carte#action(donneesPrincipales.Joueur)
         */
        public void action(Joueur joueur)   {
        	System.out.println(this.getDescr());
        	switch (this.nom) {
            	case "goPrison" : 
                    joueur.setPos(10);
                    joueur.setEtatPrison(0);
                    break;
            	case "belleville" :
            		joueur.setPos(1);
            		break;
            	case "reculer" :
            		joueur.setPos((joueur.getPos()-3));
            		break;
            	default :
            		if (joueur.getPos()> caseArrivee)
                		joueur.setArgent(joueur.getArgent()+200);
                joueur.setPos(caseArrivee);
                break;
        	}
    		System.out.println("La nouvelle position du joueur " + joueur.getNom() + " est " + joueur.getPos() + ".");
        }
}