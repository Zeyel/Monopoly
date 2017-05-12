package carte;

import java.util.ArrayList;

/**
 * Classe définissant un paquet de carte (communauté, chance)
 * 
 * 
 *
 */

public class Paquet {
        public ArrayList<Carte> nom = new ArrayList<Carte>();

        //CONSTRUCTEUR
        public Paquet() {
                this.nom.clear();
        }
        
        public void tirerCarte(){
                if (this.nom==null)
                        throw new NullPointerException("Il n'y a plus de cartes dans le paquet");
                Carte e = this.nom.get(0);
                this.nom.add(e);
                this.nom.remove(0);
                e.action();
        }
}
