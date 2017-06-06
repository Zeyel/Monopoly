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
 * Classe contenant les éléments pour faire une partie et la jouer
 * @author timbr
 *
 */
public class Partie {
	private ArrayList<Cases> cases = new ArrayList<Cases>();
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private ArrayList<De> de = new ArrayList<De>();
	private Paquet chance;
	private Paquet communaute;

	// CONSTRUCTEURS
	/**
	 * Constructeur par défaut de la partie
	 * 
	 */
	public Partie() {
		this.cases = new ArrayList<Cases>();
		this.joueurs = new ArrayList<Joueur>();
		this.de = new ArrayList<De>();
		this.chance = null;
		this.communaute = null;
	}

	// GETTERS
	/**
	 * Renvoie l'ArrayList de Joueurs
	 * @return
	 */
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	/**
	 * Renvoie le nombre de joueurs dans la partie
	 * @return
	 */
	public int getNbJoueurs() {
		return this.joueurs.size();
	}

	/**
	 * Renvoie le dé n° index
	 * @param index
	 * @return
	 */
	public De getDe(int index) {
		return this.de.get(index);
	}

	/**
	 * Renvoie le nombre de joueurs en gameOver
	 * @return
	 */
	public int getNbGameOver() {
		int cpt = 0;
		for (Joueur j : this.joueurs) {
			if (j.getGameOver())
				cpt++;
		}
		return cpt;
	}

	// SETTERS
	/**
	 * Initialise l'ArrayList de joueurs avec une ArrayList de joueurs, inutilisée je crois
	 * @param joueurs
	 * @throws InvalidParameterException
	 */
	public void setJoueurs(ArrayList<Joueur> joueurs) throws InvalidParameterException {
		if (joueurs == null)
			throw new InvalidParameterException("Il n'y a pas de joueurs en paramètres");
		else
			this.joueurs = joueurs;
	}

	/**
	 * Ajoute le dé dice à l'ArrayList de dé
	 * @param dice
	 */
	public void addDe(De dice) {
		this.de.add(dice);
	}

	/**
	 * Ajoute la case c à l'ArrayList de Cases
	 * @param c
	 */
	public void addCase(Cases c) {
		this.cases.add(c);
	}

	/**
	 * Ajoute le joueur j à l'ArrayList joueurs
	 * @param j
	 */
	public void addJoueur(Joueur j) {
		this.joueurs.add(j);
	}

	/**
	 * Fonction pour parer le Scanner récalcitrant
	 * 
	 */
	public void bidouillage() {
		this.joueurs.remove(0);
	}

	/**
	 * Ajoute le paquet c à partie.chance
	 * @param c
	 */
	public void setChance(Paquet c) {
		this.chance = c;
	}

	/**
	 * Ajoute le paquet c à partie.communaute
	 * @param c
	 */
	public void setCommunaute(Paquet c) {
		this.communaute = c;
	}

	// METHODES
	/**
	 * Si il reste plus qu'un joueur en jeu, renvoie FinDePartieException, sinon continue la partie
	 * @throws FinDePartieException
	 */
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
	/**
	 * Méthode qui simule le tour d'un joueur
	 * @param j
	 * @throws ChanceException
	 */
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
	/**
	 * Méthode qui simule un tour de joueur en prison
	 * @param j
	 * @param p
	 */
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
	/**
	 * Méthode qui propose à l'utilisateur d'acheter des maisosn si il le peut
	 * @param couleur
	 */
	public void achatMaison(String couleur) {
		
	}
}
