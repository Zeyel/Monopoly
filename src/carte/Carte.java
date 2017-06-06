package carte;

import java.security.InvalidParameterException;

import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;


/**
 * Classe abstraite contenant les données membres communes à toutes les cartes
 * @author timbr
 *
 */
public abstract class Carte {
        private String descr;
        protected String nom;
        
        // GETTERS
        /**
         * Renvoie la description de la carte
         * @return
         */
        public String getDescr() {
                return descr;
        }

        /**
         * Initialise la description de la carte
         * @param descr
         * @throws InvalidParameterException
         */
        public void setDescr(String descr) throws InvalidParameterException {
                if (descr==null)
                        throw new InvalidParameterException("La carte n'est pas décrite");
                this.descr = descr;
        }

        /**
         * Renvoie le nom de la carte
         * @return
         */
        public String getNom() {
                return nom;
        }

        /**
         * Initialise le nom de la carte
         * @param nom
         * @throws InvalidParameterException
         */
        public void setNom(String nom) throws InvalidParameterException {
                if (nom == null)
                        throw new InvalidParameterException("Le nom de la carte est vide");
                this.nom = nom;
        }
        
        /**
         * Action de la carte, définie dans les sous-classes
         */
        public void action(){}

		/**
		 * Action de la carte, définie dans les sous-classes
		 * @param j
		 * @throws ProloException
		 * @throws ChanceException
		 */
		public void action(Joueur j) throws ProloException, ChanceException{
			
		}
}
