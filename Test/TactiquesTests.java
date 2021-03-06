
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
 * Classe de tests pour tester les diff�rents cas des tactiques
 * @author Mathieu
 *
 */
public class TactiquesTests {

	private Plateau plateauIA;
	private Plateau plateauJ;
	
	@Before
	public void setUp()  {
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
	 * Test qui va g�n�rer deux Plateaux avec leurs bateaux
	 * Les cases du plateau du joueur sont tous d�j� touch�
	 * Et je regarde si la m�thode retourne bien un tir NULL
	 * -> Elle m'a permet de d�couvrir la pr�sence d'�rreur de type NullPointerException, 
	 * Par cons�quent, j'ai du ajouter des condition dans la classe TactiqueCroix
	 * @throws IOException
	 */
	@Test
	public void testTactiqueCroixRetourneNull() {
		
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}

	/**
	 * Test qui va g�n�rer deux Plateaux avec leurs bateaux
	 * Les cases du plateau du joueur sont tous d�j� touch�
	 * Et je regarde si la m�thode retourne bien un tir NULL
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireRetourneNull()  {
		
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueAleatoire si on lui passe un/ des plateau(x) vide(s)
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireParametrePlateauNull()  {
		
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(null, null);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueCroix si on lui passe un/ des plateau(x) vide(s)
	 * @throws IOException
	 */
	@Test
	public void testTactiqueCroixParametrePlateauNull() {
		
		Case c = TactiqueCroix.getInstance().appliquerTactique(null, null);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueAleatoire si on lui passe un/ des plateau(x) initialis�(s) mais sans liste de bateaux
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireParametreListeBateauNull() {
		plateauIA.setBateau(null);
		plateauJ.setBateau(null);
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueCroix si on lui passe un/ des plateau(x) initialis�(s) mais sans liste de bateaux
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireCroixListeBateauNull()  {
		plateauIA.setBateau(null);
		plateauJ.setBateau(null);
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueAleatoire si on lui passe un/ des plateau(x) initialis�(s) mais sans carte
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireParametreCarteNull() {
		plateauIA.setCarte(null);
		plateauJ.setCarte(null);
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test pour savoir comment se comporte la tactiqueCroix si on lui passe un/ des plateau(x) initialis�(s) mais sans carte
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireCroixCarteNull()  {
		plateauIA.setCarte(null);
		plateauJ.setCarte(null);
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		assertEquals(c, null);
	}
	
	/**
	 * Test normal pour savoir si la tactique al�atoire tir bien au seul endroit possible
	 * @throws IOException
	 */
	@Test
	public void testTactiqueAleatoireNormal() {
		//De base les parametres de cette classe me donne un plateau sur lequel il n'y a plus de case sur laquelle tirer
		//Je change une case pour que l'on puisse tirer dessus
		plateauJ.getCarte()[1][1].setCibler(false);
		Case c = TactiqueAleatoire.getInstance().appliquerTactique(plateauIA, plateauJ);

		//on doit tirer sur la case que j'ai chang� juste au dessus
		assertEquals(c.getX(), plateauJ.getCarte()[1][1].getX());
		assertEquals(c.getY(), plateauJ.getCarte()[1][1].getY());
	}
	
	/**
	 * Test normal pour savoir si la tactique croix tir bien au seul endroit possible
	 * @throws IOException
	 */
	@Test
	public void testTactiqueCroixNormal(){
		//De base les parametres de cette classe me donne un plateau sur lequel il n'y a plus de case sur laquelle tirer
		//Je change une case pour que l'on puisse tirer dessus
		plateauJ.getCarte()[1][1].setCibler(false);
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);

		//on doit tirer sur la case que j'ai chang� juste au dessus
		assertEquals(c.getX(), plateauJ.getCarte()[1][1].getX());
		assertEquals(c.getY(), plateauJ.getCarte()[1][1].getY());
	}
}