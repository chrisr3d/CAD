package Modele.Epoque;

import Modele.Bateau.*;

import java.util.ArrayList;

/**
 * Interface Epoque qui permet d'appliquer a une liste de bateaux
 * @author Mathieu
 *
 */
public interface Epoque {

	public ArrayList<Bateau> setEpoque(ArrayList<Bateau> listBateau);
	
	public String getNomEpoque();
	
}
