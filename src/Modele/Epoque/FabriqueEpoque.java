package Modele.Epoque;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

/**
 * Classe FabriqueEpoque qui va appliquer l'epoque que l'utilisateur a choisis 
 * @author Mathieu
 *
 */
public class FabriqueEpoque {

	private static Epoque currentEpoque=EpoqueFutur.getInstance();

	public static void choisirEpoqueFutur(ArrayList<Bateau> listBateau){
		currentEpoque.setEpoque(listBateau);
	}
	
	public static void choisirEpoqueActuelle(ArrayList<Bateau> listBateau) {
		currentEpoque.setEpoque(listBateau);
	}

	public static Epoque getEpoque() {
		return currentEpoque;
	}
	
	public static void setEpoqueActuelle(){
		currentEpoque = EpoqueActuelle.getInstance();
	}
	
	public static void setEpoqueFutur(){
		currentEpoque = EpoqueFutur.getInstance();
	}
	
}
