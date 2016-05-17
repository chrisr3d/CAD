import DAO.XMLEpoqueDAO;
import DAO.XMLStrategieDAO;
import Modele.Partie;
import Modele.Epoque.Epoque;
import Modele.Tactique.TactiqueCroix;
import Modele.Tactique.TactiqueIAStrategie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		XMLStrategieDAO s = XMLStrategieDAO.getInstance();
		XMLEpoqueDAO e = XMLEpoqueDAO.getInstance();
		Partie pp = new Partie(null);
		pp.SauvegarderPartie();
		s.save("Croix");
		e.save("Futur");
		Epoque ep = e.find();
		TactiqueIAStrategie p = s.find();
		
	}

}
