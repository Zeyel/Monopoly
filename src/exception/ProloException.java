package exception;

/**
 * Classe servant à chaque fois qu'un joueur paie quelque chose, si il ne peut pas payer
 * l'exception est lancée avec le montant qu'il a a payer
 * @author timbr
 *
 */
public class ProloException extends Exception{
	private int montant;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'exception avec le montant
	 * @param montant
	 */
	public ProloException (int montant) {
		super();
		this.setMontant(montant);
	}
	// GETTERS
	
	/**
	 * Renvoie le montant de la dette du joueur
	 * @return
	 */
	public int getMontant(){
		return this.montant;
	}
	
	// SETTERS
	/**
	 * Initialise le montant de la dette du joueur
	 * @param montant
	 */
	public void setMontant(int montant) {
		this.montant=montant;
	}

	public ProloException (String msg) {
		super(msg);
	}
}
