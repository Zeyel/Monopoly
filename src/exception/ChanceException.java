package exception;

/**
 * ChanceException sert pour la carte "Amende ou chance", elle est envoyée si le joueur décide de piocher une carte
 * @author timbr
 *
 */
public class ChanceException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut de ChanceException
	 * 
	 */
	public ChanceException () {
		super();
	}

	/**
	 * Constructeur avec message de ChanceException
	 * @param msg
	 */
	public ChanceException (String msg) {
		super(msg);
	}
}
