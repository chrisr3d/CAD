package Modele.Tactique;

import Modele.Case;
import Modele.Plateau;

public interface TactiqueIAStrategie {

	public String getNom();
	public Case appliquerTactique(Plateau platIA, Plateau joueur);
	
}
