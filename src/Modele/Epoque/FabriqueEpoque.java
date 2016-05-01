package Modele.Epoque;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

public class FabriqueEpoque {

	private static Epoque currentEpoque = new EpoqueFutur();

	public static void choisirEpoqueFutur(ArrayList<Bateau> listBateau){
		currentEpoque = EpoqueFutur.getInstance();
		currentEpoque.setEpoque(listBateau);
	}
	
	public static void choisirEpoqueActuelle(ArrayList<Bateau> listBateau) {
		currentEpoque = EpoqueActuelle.getInstance();
		currentEpoque.setEpoque(listBateau);
	}

	public static Epoque getEpoque() {
		return currentEpoque;
	}
	
}
