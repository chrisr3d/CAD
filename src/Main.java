import DAO.XMLParametreDAO;
import Modele.Parametre;
import Modele.Partie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		XMLParametreDAO para = XMLParametreDAO.getInstance();
		Parametre p = new Parametre(6, 6, true);
		Partie pp = new Partie(p);
		pp.SauvegarderPartie();
		para.save(p);
		Parametre p2 = para.find();
		System.out.println(p2.getHauteurPlateau() + p2.getLargeurPlateau() );
		//e.save("Futur");
		//Epoque ep = e.find();
		//TactiqueIAStrategie p = s.find();
		
	}

}
