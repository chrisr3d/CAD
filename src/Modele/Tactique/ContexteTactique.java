package Modele.Tactique;

/**
 * @author Mathieu
 *
 */
public class ContexteTactique {

	private static TactiqueIAStrategie currentTactique = new TactiqueCroix();

	/**
	 * change la tactique a appliquer par la tactique en croix
	 */
	public static void choisirTactiqueCroix(){
		currentTactique = TactiqueCroix.getInstance();
	}
	
	/**
	 * change la tactique a appliquer par la tactique aleatoires
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
