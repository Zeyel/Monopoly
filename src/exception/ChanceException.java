package exception;

/**
 * ChanceException sert pour la carte "Amende ou chance", elle est envoy�e si le joueur d�cide de piocher une carte
 * @author timbr
 *
 */
public class ChanceException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par d�faut de ChanceException
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
