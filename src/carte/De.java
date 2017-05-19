package carte;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;

public class De {
	
	/**
	 * Classe pour les composantes d'un de
	 * 
	 * 
	 */
	ArrayList<Integer> de = new ArrayList<Integer>();
	
	// CONSTRUCTEURS
	
	public De(){							// CREER UN D6 PAR DEFAUT
		for (int i = 1; i<=6; i++)
			this.de.add(i);
	}
	public De(int min, int max) throws InvalidParameterException {			// CREER UN DE PARAMETRABLE
		if (min > max)
			throw new InvalidParameterException("Le minimum doit etre inferieur au maximum");
		else if (max > min + 100)
			throw new InvalidParameterException("N'abusons pas, un de ne peux pas avoir plus de 100 faces.");
		else
			for (int i= min; i <= max; i++)
				this.de.add(i);
	}
	
	// GETTERS
	
	public ArrayList<Integer> getDe(){
		return this.de;
	}
	public int getJet(){	// PERMET DE RECUPERER LE JET DU DERNIER DE LANCE
		return this.de.get(0);
	}
	
	// SETTERS
	
	
	// METHODES
	
	public int JetDe(){
		Collections.shuffle(this.de);
		return this.de.get(0);
	}
	public String toString(){
		return("De de minimum " + Collections.min(this.de) + " et de maximum " + Collections.max(this.de));
	}

}