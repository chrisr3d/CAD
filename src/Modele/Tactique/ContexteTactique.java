package Modele.Tactique;

public class ContexteTactique {

	private static TactiqueIAStrategie currentTactique = new TactiqueCroix();

	public static void choisirTactiqueCroix(){
		currentTactique = new TactiqueCroix();
	}
	
	public static void choisirTactiqueAleatoire() {
		currentTactique = new TactiqueAleatoire();
	}

	public static TactiqueIAStrategie getTactique() {
		return currentTactique;
	}
	
}
