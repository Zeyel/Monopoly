package carte;


import java.security.InvalidParameterException;

import donneesPrincipales.Joueur;

/**
 * Classe définissant les cartes piochées ayant un impact direct sur l'argent du joueur
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
                if ((joueur.getArgent()+gain)<0)
                        joueur.GameOver(joueur.getArgent()+gain);
                joueur.setArgent(joueur.getArgent() + gain);
        }
}
