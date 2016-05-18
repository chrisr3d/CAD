package Modele.Epoque;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

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
	
	/**
	 * Cette méthode sera appelée lors de l'appel de la méthode find pour le dao
	 * Elle permet de fixer l'époque que nous aviosn sauvegarder
	 */
	
	public static void setEpoqueActuelle(){
		currentEpoque = EpoqueActuelle.getInstance();
	}
	
	public static void setEpoqueFutur(){
		currentEpoque = EpoqueFutur.getInstance();
	}
	
}
