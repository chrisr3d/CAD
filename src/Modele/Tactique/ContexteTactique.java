package Modele.Tactique;

public class ContexteTactique {

	private static TactiqueIAStrategie currentTactique = new TactiqueCroix();

	public static void choisirTactiqueCroix(){
		currentTactique = TactiqueCroix.getInstance();
	}
	
	public static void choisirTactiqueAleatoire() {
		currentTactique = TactiqueAleatoire.getInstance();
	}

	public static TactiqueIAStrategie getTactique() {
		return currentTactique;
	}
	
}
