package Modele.Epoque;



public class FabriqueEpoque {

	private static Epoque currentEpoque = new EpoqueModerne();

	public static void choisirEpoqueModerne(){
		currentEpoque = new EpoqueModerne();
	}
	
	public static void ajouterTactiqueAleatoire() {
		currentEpoque = new EpoqueRenaissance();
	}

	public static Epoque getEpoque() {
		return currentEpoque;
	}
	
}
