package Modele.Tactique;

import Modele.Case;
import Modele.Plateau;

/**
 * Intergace TactiqueIAStrategie 
 * @author Mathieu
 *
 */
public interface TactiqueIAStrategie {

	public String getNom();
	public Case appliquerTactique(Plateau platIA, Plateau joueur);
	
}
