package carte;

import java.util.ArrayList;

import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

/**
 * Classe contenant le paquet de cartes sous forme d'ArrayList
 * @author timbr
 *
 */
public class Paquet {
        private ArrayList<Carte> pack;

        //CONSTRUCTEUR
        /**
         * Constructeur du Paquet
         */
        public Paquet() {
        	this.pack = new ArrayList<Carte>();
        }
        
        // GETTER
        /**
         * Renvoie le paquet de cartes
         * @return
         */
        public ArrayList<Carte> getPack () {
        	return this.pack;
        }
        // SETTER
        /**
         * Ajoute une carte au paquet
         * @param carte
         */
        public void addCarte (Carte carte){
        	this.pack.add(carte);
        }
        
        /**
         * Tire une carte du paquet et lance son action
         * @param j
         * @throws ChanceException
         * @throws ProloException
         */
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
