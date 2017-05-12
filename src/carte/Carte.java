package carte;

import java.security.InvalidParameterException;

/**
 * Classe abstraite mod�lisant une carte en g�n�ral (tout jeu de plateau confondu)
 * 
 * 
 * 
 */

public abstract class Carte {
        private String descr;
        protected String nom;
        
        public String getDescr() {
                return descr;
        }

        public void setDescr(String descr) throws InvalidParameterException {
                if (descr==null)
                        throw new InvalidParameterException("La carte n'est pas d�crite");
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
        
        public void action(){
        	
        }
}