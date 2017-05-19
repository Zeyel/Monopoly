package plateau;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import donneesPrincipales.Joueur;
import exception.ProloException;

public class Gare extends Proprietes{
	private ArrayList<Integer> loyer;
	
	public Gare(String nom, String couleur, int prix, Integer ...i) {
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
	
	// METHODES
	
	public void action(Joueur j) throws ProloException {
		this.toString();
		Scanner sc = new Scanner(System.in);
		int answer;
		if(this.getProprietaire().equals(null)) {
			if(j.getArgent()-this.getPrix()<0)
				System.out.println("Voulez vous acheter " + this.getNom() + " ? (o pour oui/n pour non)");
				do{
					answer = sc.nextInt();
					if((answer!='O')||(answer!='o')||(answer!='N')||(answer!='n'))
						System.out.println("Veuillez entrer O/o pour oui ou N/n pour non\n");
				}while((answer!='O')||(answer!='o')||(answer!='N')||(answer!='n'));
				if((answer=='o')||(answer=='O')) {
					j.setArgent(j.getArgent()-super.getPrix());
					super.setProprietaire(j);
					j.getProprietes().add(this);
					System.out.println("Vous venez d'acheter "+ getNom() + ".\n " +
							  		   "Votre nouveau solde est de " + j.getArgent() +"€.");
				}
				else {
					System.out.println("Vous avez refusé d'acheter la propriété " + getNom() + ".\nVous passez peut-être à côté d'une opportunité.");
				}
			sc.close();	
		}
		else {
			System.out.println("Vous êtes sur la propriété de " + this.getProprietaire() + ", vous devez donc payer le loyer (" + this.loyer.get(this.getProprietaire().getNbGares()-1) + "€)");
			int loy = (this.loyer.get(this.getProprietaire().getNbGares()-1));
			int dette = Math.abs(j.getArgent()-this.loyer.get(this.getProprietaire().getNbGares()-1));
			try {
				j.payerJoueur(this.getProprietaire(), loy);
			}catch (ProloException P){
				j.GameOver(dette, this.getProprietaire());
			};
		}
	}
}
