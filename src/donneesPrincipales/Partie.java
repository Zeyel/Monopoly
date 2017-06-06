package donneesPrincipales;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

import carte.De;
import carte.Paquet;
import exception.ChanceException;
import exception.FinDePartieException;
import exception.ProloException;
import plateau.Cases;
import plateau.Proprietes;

/**
 * Classe englobant les informations de jeu
 * 
 * 
 */

public class Partie {
	private ArrayList<Cases> cases = new ArrayList<Cases>();
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private ArrayList<De> de = new ArrayList<De>();
	private Paquet chance;
	private Paquet communaute;

	// CONSTRUCTEURS
	public Partie() {
		this.cases = new ArrayList<Cases>();
		this.joueurs = new ArrayList<Joueur>();
		this.de = new ArrayList<De>();
		this.chance = null;
		this.communaute = null;
	}

	// GETTERS
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public int getNbJoueurs() {
		return this.joueurs.size();
	}

	public De getDe(int index) {
		return this.de.get(index);
	}

	public int getNbGameOver() {
		int cpt = 0;
		for (Joueur j : this.joueurs) {
			if (j.getGameOver())
				cpt++;
		}
		return cpt;
	}

	// SETTERS
	public void setJoueurs(ArrayList<Joueur> joueurs) throws InvalidParameterException {
		if (joueurs == null)
			throw new InvalidParameterException("Il n'y a pas de joueurs en paramètres");
		else
			this.joueurs = joueurs;
	}

	public void addDe(De dice) {
		this.de.add(dice);
	}

	public void addCase(Cases c) {
		this.cases.add(c);
	}

	public void addJoueur(Joueur j) {
		this.joueurs.add(j);
	}

	public void bidouillage() {
		this.joueurs.remove(0);
	}

	public void setChance(Paquet c) {
		this.chance = c;
	}

	public void setCommunaute(Paquet c) {
		this.communaute = c;
	}

	// METHODES
	public void finDePartie() throws FinDePartieException {
		if (this.getNbGameOver() == (this.getNbJoueurs() - 1)) {
			for (Joueur j : this.joueurs) {
				if (!(j.getGameOver()))
					throw new FinDePartieException(j);
			}
		}
		System.out.println("|La partie continue, il reste plus d'un joueur dans la partie !");
		for (Joueur j : this.joueurs) {
			if (j.getGameOver())
				System.out.println("|Le joueur " + j.getNom() + " a perdu.");

		}

	}
	public void tourJoueur(Joueur j) throws ChanceException{
		if (j.getEtatPrison() != -1)
			tourPrison(j, this);
		else {
		this.de.get(0).JetDe();	// Tir du premier dé
		this.de.get(1).JetDe();	// Tir du second dé
		System.out.println("|Le joueur " + j.getNom() + " tire un premier de et fait un " + this.getDe(0).JetDe() + " et un second qui fait " + this.getDe(1).JetDe() + ", " + j.getNom() + " avance donc de " + (this.getDe(0).getJet() + this.getDe(1).getJet()) + " cases.");
		j.deplacement(this.de.get(0).getJet() + this.de.get(1).getJet());
		System.out.println("|\n");
			try {
				this.cases.get(j.getPos()).action(j);
			} catch (ProloException e) {
				j.GameOver(e.getMontant());
				j.reset();
			}
			for (Proprietes p : j.getProprietes()){
				if ((p.getCouleur() != "blanc") || (p.getCouleur() !="noir"))
					if (p.hasFullColor(j, p.getCouleur())) {
						achatMaison(p.getCouleur());		
					}
			}
		 try{
			 Thread.sleep(10);
			 }
		 catch(InterruptedException e){
			 System.out.println(e);
		 }  
		}
	}
	private void tourPrison(Joueur j, Partie p) {
		System.out.println("|Vous êtes en prison depuis " + j.getEtatPrison() +" tours");
		if (j.getEtatPrison() == 3){
			try {
				System.out.println("|Payez la caution de 50€ pour sortir de prison");
				j.payer(50);
			} catch (ProloException e) {
				j.GameOver(e.getMontant());
				j.reset();
			}
			j.setEtatPrison(-1);
		}
		else {
			Scanner sc = new Scanner(System.in);
			String answer;
			do {
				System.out.println("|Entrez o/O pour payer l'amende, n/N pour ne pas la payer et attendre un tour de plus");
			answer = "n";
			} while (answer != "o" && answer != "O" && answer != "n" && answer != "N");
			if (answer == "o" || answer == "O"){
				try {
					j.payer(50);
				} catch (ProloException e) {
					j.GameOver(e.getMontant());
					j.reset();
				}
				j.setEtatPrison(-1);
			}
			j.setEtatPrison(j.getEtatPrison()+1);
			sc.close();
		}
			
	}
	public void achatMaison(String couleur) {
		
	}
}
