package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Terrain extends Proprietes{
	private ArrayList<Integer> loyer;
	
	public Terrain (String nom, String couleur, int prix, Integer ...i){
		super.setNom(nom);
		super.setCouleur(couleur);
		super.setPrix(prix);
		this.loyer = new ArrayList<Integer>();
		for (int loy : i)
			this.loyer.add(loy);
	}
	
	// GETTERS
	
	public ArrayList<Integer> getLoyer() throws InvalidParameterException {
		if (this.loyer == null)
			throw new InvalidParameterException("La liste est vide");
		return this.loyer;
	}
}
