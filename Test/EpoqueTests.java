

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modele.CaseBateau;
import Modele.Bateau.Bateau;
import Modele.Epoque.EpoqueFutur;

/**
 * Classe de tests qui va me permettre de tester les classes li�s a l'�poque
 * @author Mathieu
 *
 */
public class EpoqueTests {

	@Before
	public void setUp() throws IOException{
	}

	@Test
	public void testEpoqueParamNull() {
		assertEquals(EpoqueFutur.getInstance().setEpoque(null),null);
	}

	/**
	 * On essaye de passer une liste vide de bateau pour �tre modifi�
	 * Il n'y a pas d'exception de cr��e
	 */
	@Test
	public void testEpoqueListBateauVide() {
		ArrayList<Bateau> listBoatJ = new ArrayList<Bateau>();
	}
	
	/**
	 * Si on passe une liste de caseVide ou null, l'�poque ne touchant pas � cette liste, il ne peut doit pas y avoir de probl�me
	 */
	@Test
	public void testEpoqueListCaseVide()  {
		Bateau b2j = new Bateau(2, true);
		ArrayList<Bateau> listBoatJ = new ArrayList<Bateau>();
		ArrayList<CaseBateau> cbbj = new ArrayList<CaseBateau>();
		b2j.setEmplacement(cbbj);
		listBoatJ.add(b2j);
		assertEquals(EpoqueFutur.getInstance().setEpoque(listBoatJ).get(0).getNom(),"Chasseur");
		assertEquals(EpoqueFutur.getInstance().setEpoque(listBoatJ).get(0).getPuissance(),6);
		assertEquals(EpoqueFutur.getInstance().setEpoque(listBoatJ).get(0).getTaille(),2);
	}
	
	/**
	 * Test un cas normal avec une liste de bateau initialis�e
	 */
	@Test
	public void testEpoqueCasNormal() {
		Bateau b2j = new Bateau(2, true);
		ArrayList<Bateau> listBoatJ = new ArrayList<Bateau>();
		ArrayList<CaseBateau> cbbj = new ArrayList<CaseBateau>();
		CaseBateau cb11j = new CaseBateau(0, 1);
		CaseBateau cb22j = new CaseBateau(1, 1);
		cb11j.setCibler(true);
		cb22j.setCibler(true);
		cbbj.add(cb11j);
		cbbj.add(cb22j);
		b2j.setEmplacement(cbbj);

		listBoatJ.add(b2j);
		assertEquals(EpoqueFutur.getInstance().setEpoque(listBoatJ).get(0).getNom(),"Chasseur");
		assertEquals(EpoqueFutur.getInstance().setEpoque(listBoatJ).get(0).getPuissance(),6);
		assertEquals(EpoqueFutur.getInstance().setEpoque(listBoatJ).get(0).getTaille(),2);
	}
}
