

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
import Modele.Tactique.TactiqueCroix;

public class TactiquesTests {

	@Before
	public void setUp() throws IOException {
	}
	
	@Test
	public void testTactiqueCroixNull() throws IOException {
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
		

		Bateau b2 = new Bateau(2, true);
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
				for (Bateau bat : listBoat) {
					for (CaseBateau caseBateau : bat.getEmplacement()) {
						if(i == caseBateau.getX() && j == caseBateau.getY()){
							carte[i][j] = caseBateau;
						}else{
							carte[i][j] = new CaseEau(i, j);
						}
					}
				}
			}
		}
		
		Plateau plateauIA = new Plateau(Parametre.getLargeurPlateau(), Parametre.getHauteurPlateau());
		plateauIA.setBateau(listBoat);
		plateauIA.setCarte(carte);
		Case[][] carte2 = new Case[2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (Bateau bat : listBoatJ) {
					for (CaseBateau caseBateau : bat.getEmplacement()) {
						if(i == caseBateau.getX() && j == caseBateau.getY()){
							carte2[i][j] = caseBateau;
						}else{
							carte2[i][j] = new CaseEau(i, j);
						}
					}
				}
			}
		}

		
		Plateau plateauJ = new Plateau(Parametre.getLargeurPlateau(), Parametre.getHauteurPlateau());
		plateauJ.setBateau(listBoatJ);
		plateauJ.setCarte(carte2);
		Case c = TactiqueCroix.getInstance().appliquerTactique(plateauIA, plateauJ);
		
		assertEquals(c.getX(), null);
	}

}