
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
import Modele.Plateau;
import Modele.Bateau.Bateau;
import Modele.Tactique.TactiqueAleatoire;
import Modele.Tactique.TactiqueCroix;

/**
 * Classe de tests pour tester les différents cas des tactiques
 * @author Mathieu
 *
 */
public class TactiquesTests {

	private Plateau plateauIA;
	private Plateau plateauJ;
	
	@Before
	public void setUp() throws IOException {
		Case[][] carte = new Case[2][2];
		Parametre p = new Parametre(2, 2, true, Modes.Normal);
		ArrayList<Bateau> listBoat = new ArrayList<Bateau>();
		Bateau b1 = new Bateau(2, false);
		ArrayList<CaseBateau> cb = new ArrayList<CaseBateau>();
		CaseBateau cb1 = new CaseBateau(0, 0);
		CaseBateau cb2 = new CaseBateau(0, 1);
		cb.add(cb1);
		cb.add(cb2);
		b1.setEmplacement(cb);

		Bateau b2 = new Bateau(2, false);
		ArrayList<CaseBateau> cbb = new ArrayList<CaseBateau>();
		CaseBateau cb11 = new CaseBateau(1, 0);
		CaseBateau cb22 = new CaseBateau(1, 1);
		cbb.add(cb11);
		cbb.add(cb22);
		b2.setEmplacement(cbb);

		listBoat.add(b1);
		listBoat.add(b2);

		ArrayList<Bateau> listBoatJ = new ArrayList<Bateau>();

		Bateau bj = new Bateau(2, true);
		ArrayList<CaseBateau> cbj = new ArrayList<CaseBateau>();
		CaseBateau cb1j = new CaseBateau(0, 0);
		CaseBateau cb2j = new CaseBateau(1, 0);
		cb1j.setCibler(true);
		cb2j.setCibler(true);
		cbj.add(cb1j);
		cbj.add(cb2j);

		bj.setEmplacement(cbj);

		Bateau b2j = new Bateau(2, true);
		ArrayList<CaseBateau> cbbj = new ArrayList<CaseBateau>();
		CaseBateau cb11j = new CaseBateau(0, 1);
		CaseBateau cb22j = new CaseBateau(1, 1);
		cb11j.setCibler(true);
		cb22j.setCibler(true);
		cbbj.add(cb11j);
		cbbj.add(cb22j);
		b2j.setEmplacement(cbbj);

		listBoatJ.add(bj);
		listBoatJ.add(b2j);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				carte[i][j] = new CaseEau(i, j);
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (Bateau bat : listBoatJ) {
					for (CaseBateau caseBateau : bat.getEmplacement()) {
						if (i == caseBateau.getX() && j == caseBateau.getY()) {
							carte[i][j] = caseBateau;
						}
					}
				}
			}
		}

		plateauIA = new Plateau(Parametre.getLargeurPlateau(), Parametre.getHauteurPlateau());
		plateauIA.setBateau(listBoat);
		plateauIA.setCarte(carte);
		Case[][] carte2 = new Case[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				carte2[i][j] = new CaseEau(i, j);
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (Bateau bat : listBoatJ) {
					for (CaseBateau caseBateau : bat.getEmplacement()) {
						if (i == caseBateau.getX() && j == caseBateau.getY()) {
							carte2[i][j] = caseBateau;
						}
					}
				}
			}
		}

		plateauJ = new Plateau(Parametre.getLargeurPlateau(), Parametre.getHauteurPlateau());
		plateauJ.setBateau(listBoatJ);
		plateauJ.setCarte(carte2);
	}

	/**
	 * Test qui va générer deux Plateaux avec leurs bateaux
	 * Les cases du plateau du joueur sont tous déjà touché
	 * Et je regarde si la méthode retourne bien un tir NULL
	 * -> Elle m'a permet de découvrir la présence d'érreur de type NullPointerException, 
	 * Par conséquent, j'ai du ajouter des condition dans la classe TactiqueCroix
	 * @throws IOException
	 */
	@Test
	public void testTactiqueCroixRetourneNull() throws IOException {
		
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}

	/**
	 * Test qui va générer deux Plateaux avec leurs bateaux
	 * Les cases du plateau du joueur sont tous déjà touché
	 * Et je regarde si la méthode retourne bien un tir NULL
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireRetourneNull() throws IOException {
		
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueAleatoire si on lui passe un/ des plateau(x) vide(s)
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireParametrePlateauNull() throws IOException {
		
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(null, null);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueCroix si on lui passe un/ des plateau(x) vide(s)
	 * @throws IOException
	 */
	@Test
	public void testTactiqueCroixParametrePlateauNull() throws IOException {
		
		Case c = TactiqueCroix.getInstance().appliquerTactique(null, null);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueAleatoire si on lui passe un/ des plateau(x) initialisé(s) mais sans liste de bateaux
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireParametreListeBateauNull() throws IOException {
		plateauIA.setBateau(null);
		plateauJ.setBateau(null);
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueCroix si on lui passe un/ des plateau(x) initialisé(s) mais sans liste de bateaux
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireCroixListeBateauNull() throws IOException {
		plateauIA.setBateau(null);
		plateauJ.setBateau(null);
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueAleatoire si on lui passe un/ des plateau(x) initialisé(s) mais sans carte
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireParametreCarteNull() throws IOException {
		plateauIA.setCarte(null);
		plateauJ.setCarte(null);
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueCroix si on lui passe un/ des plateau(x) initialisé(s) mais sans carte
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireCroixCarteNull() throws IOException {
		plateauIA.setCarte(null);
		plateauJ.setCarte(null);
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
}