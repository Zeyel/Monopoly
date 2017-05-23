package carte;

import donneesPrincipales.Joueur;

import java.security.InvalidParameterException;

/**
 * Classe définissant une carte de déplacement des paquets chance et communaute
 * 
 * 
 */

public class CarteDeplacement extends Carte{
        private int caseArrivee;
        
        public CarteDeplacement(String descr, String nom, int caseArrivee) {
                this.setDescr(descr);
                this.setNom(nom);
                this.setCaseArrivee(caseArrivee);
        }

        private void setCaseArrivee(int caseArrivee) {
                this.caseArrivee = caseArrivee;
        }
        
        private int getCaseArrivee() {
                return this.caseArrivee;
        }
        
        public void action(Joueur joueur)        throws InvalidParameterException {
        	if (joueur == null)
                throw new InvalidParameterException("Le joueur n'existe pas");
        	switch (this.nom) {
            	case "goPrison" : 
                    joueur.setPos(10);
                    joueur.setEtatPrison(0);
            	case "belleville" :
            		joueur.setPos(1);
            	case "reculer" :
            		joueur.setPos(joueur.getPos()-3);
            	default :
            		if (joueur.getPos()> caseArrivee)
                		joueur.setArgent(joueur.getArgent()+200);
                joueur.setPos(caseArrivee);
        	}
        }
}