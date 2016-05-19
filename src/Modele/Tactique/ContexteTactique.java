package Modele.Tactique;

/**
 * @author Mathieu
 *
 */
public class ContexteTactique {

	private static TactiqueIAStrategie currentTactique = new TactiqueCroix();

	/**
	 * change la tactique � appliquer par la tactique en croix
	 */
	public static void choisirTactiqueCroix(){
		currentTactique = TactiqueCroix.getInstance();
	}
	
	/**
	 * change la tactique � appliquer par la tactique al�atoires
	 */
	public static void choisirTactiqueAleatoire() {
		currentTactique = TactiqueAleatoire.getInstance();
	}

	/**
	 * @return la tactique courrante
	 */
	public static TactiqueIAStrategie getTactique() {
		return currentTactique;
	}
	
}
