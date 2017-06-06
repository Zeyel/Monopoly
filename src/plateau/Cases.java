package plateau;
import donneesPrincipales.Joueur;
import exception.ChanceException;
import exception.ProloException;

public interface Cases {
	public void action(Joueur joueur) throws ProloException, ChanceException;
	
}

