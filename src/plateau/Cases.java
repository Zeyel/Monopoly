package plateau;
import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

/**
 * Interface pour toutes les cases du plateau
 *  @author timbr
 *
 */
public interface Cases {
	public void action(Joueur joueur) throws ProloException, ChanceException;
	
}

