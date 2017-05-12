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
                if (this.nom == "Emprisonnement")
                        joueur.setPos(10);
                        joueur.setEtatPrison(0);
                if (this.nom == "Belleville")
                        joueur.setPos(1);
                if (this.nom == "Reculer")
                        joueur.setPos(joueur.getPos()-3);
                joueur.deplacement(joueur, caseArrivee);
        }
}
