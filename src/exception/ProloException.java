package exception;

public class ProloException extends Exception{
	private int montant;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProloException (int montant) {
		super();
		this.setMontant(montant);
	}
	// GETTERS
	
	public int getMontant(){
		return this.montant;
	}
	
	// SETTERS
	public void setMontant(int montant) {
		this.montant=montant;
	}

	public ProloException (String msg) {
		super(msg);
	}
}
