package carte;

import java.util.ArrayList;

import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

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
        
        public void tirerCarte(Joueur j) throws ChanceException, ProloException{
                if (this.pack==null)
                        throw new NullPointerException("Il n'y a plus de cartes dans le paquet");
                Carte e = this.pack.get(0);
                if (e.nom.equals("LibPrison"))
                	this.pack.remove(0);
                else { 
                	this.pack.add(e);
                	this.pack.remove(0);
                }
                e.action(j);
        }
}
