
	import static org.junit.Assert.*;

	import java.io.ByteArrayOutputStream;
	import java.io.IOException;
	import java.io.PrintStream;
	import java.util.ArrayList;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;

	import Modele.Case;
	import Modele.CaseBateau;
	import Modele.CaseEau;
	import Modele.Modes;
	import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;
	import Modele.Bateau.Bateau;
import Modele.Bateau.FabriqueBateau;
import Modele.Tactique.TactiqueAleatoire;
	import Modele.Tactique.TactiqueCroix;

	/**
	 * Classe de tests pour tester les differents cas de placement aleatoire
	 * @author Misternutz
	 *
	 */
public class PlacementAleatoireTests {
	Plateau joueur;
	Plateau adversaire;
	Bateau b;

	@Before
	public void setUp() throws IOException {
		joueur = new Plateau(5,5);
		adversaire = new Plateau(5,5);
		

	}
	
	@Test
public void testAjoutAleatoireBateau() throws IOException {
		int compteur = 0;
		joueur.placerAleatoireBateau(FabriqueBateau.getBateau(3));
		for(int i = 0; i<5;i++){
			for(int j =0; j< 5; j++){
				if(joueur.getCarte()[i][j] instanceof CaseBateau){
					compteur++;
				}
			}
		}
		assertEquals(compteur, 3);
		

		
	}
	
	
	

	
	
	

}

