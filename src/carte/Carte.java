package carte;

import java.security.InvalidParameterException;

import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

/**
 * Classe abstraite modélisant une carte en général (tout jeu de plateau confondu)
 * 
 * 
 * 
 */

public abstract class Carte {
        private String descr;
        protected String nom;
        
        // GETTERS
        public String getDescr() {
                return descr;
        }

        public void setDescr(String descr) throws InvalidParameterException {
                if (descr==null)
                        throw new InvalidParameterException("La carte n'est pas décrite");
                this.descr = descr;
        }

        public String getNom() {
                return nom;
        }

        public void setNom(String nom) throws InvalidParameterException {
                if (nom == null)
                        throw new InvalidParameterException("Le nom de la carte est vide");
                this.nom = nom;
        }
        
        public void action(){}

		public void action(Joueur j) throws ProloException, ChanceException{
			
		}
}
