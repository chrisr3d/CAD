

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.AbstractDAOFactory;
import DAO.FactoryTypeDAO;
import DAO.XMLDAOFactory;
import DAO.XMLEpoqueDAO;
import DAO.XMLParametreDAO;
import DAO.XMLPartieDAO;
import DAO.XMLStrategieDAO;
import Modele.CaseBateau;
import Modele.Partie;
import Modele.Bateau.Bateau;
import Modele.Epoque.EpoqueFutur;
import Modele.Epoque.FabriqueEpoque;
import Modele.Tactique.ContexteTactique;

/**
 * Classe de tests qui va me permettre de tester les classes liés au DAO
 * @author Mathieu
 *
 */
public class DaoTests {

	@Before
	public void setUp() throws IOException{
	}

	/**
	 * Test la méthode getFactory avec un parametre null
	 * Elle retourne bien null
	 */
	@Test
	public void testDAOFactoryTpeNull() {
		assertEquals(AbstractDAOFactory.getFactory(null),null);
	}
	
	/**
	 * On va passer null pour chacun des contenus à écrire dans le fichier XML et on va vérifier à la fin que la taille du fichier est égal à 0
	 * QU'il n'y a donc pas eu insertion à cause des paramètres
	 */
	@Test
	public void testSauvegardeDAOContenuNull() {
		File file = new File("save.xml");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XMLDAOFactory  a = (XMLDAOFactory) AbstractDAOFactory.getFactory(FactoryTypeDAO.XML_DAO_Factory);
		
		XMLStrategieDAO strategie = a.getStrategie();
		XMLParametreDAO parametre = a.getParametreDAO();
		XMLEpoqueDAO epoque = a.getEpoqueDAO();
		XMLPartieDAO partie = a.getPartieDAO();
		epoque.save(null);
		strategie.save(null);
		parametre.save(null);
		partie.save(null);
		assertEquals(file.length(),0);
	}

}
