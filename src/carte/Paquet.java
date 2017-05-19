<<<<<<< HEAD
package carte;

import java.util.ArrayList;

/**
 * Classe définissant un paquet de carte (communauté, chance)
 * 
 * 
 *
 */

public class Paquet {
        private ArrayList<Carte> pack = new ArrayList<Carte>();

        //CONSTRUCTEUR
        public Paquet() {
        	this.pack = null;
        }
        
        // GETTER
        public ArrayList<Carte> getPack () {
        	return this.pack;
        }
        // SETTER
        public void addCarte (Carte carte){
        	this.pack.add(carte);
        }
        
        public void tirerCarte(){
                if (this.pack==null)
                        throw new NullPointerException("Il n'y a plus de cartes dans le paquet");
                Carte e = this.pack.get(0);
                this.pack.add(e);
                this.pack.remove(0);
                e.action();
        }
}
=======
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
>>>>>>> origin/master
