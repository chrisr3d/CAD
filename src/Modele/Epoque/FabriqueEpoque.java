package Modele.Epoque;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

public class FabriqueEpoque {

	private static Epoque currentEpoque = new EpoqueFutur();

	public static void choisirEpoqueModerne(ArrayList<Bateau> listBateau){
		currentEpoque = new EpoqueFutur();
		currentEpoque.setEpoque(listBateau);
	}
	
	public static void choisirEpoqueRenaissane(ArrayList<Bateau> listBateau) {
		currentEpoque = new EpoqueRenaissance();
		currentEpoque.setEpoque(listBateau);
	}

	public static Epoque getEpoque() {
		return currentEpoque;
	}
	
}
