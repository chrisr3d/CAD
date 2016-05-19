import DAO.XMLParametreDAO;
import Modele.Modes;
import Modele.Parametre;
import Modele.Partie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		XMLParametreDAO para = XMLParametreDAO.getInstance();
		Parametre p = new Parametre(6, 6, true,Modes.Mosaique);
		Partie pp = new Partie(p);
		pp.SauvegarderPartie();
		para.save(p);
		Parametre p2 = para.find();
		System.out.println(p2.getHauteurPlateau() + p2.getLargeurPlateau() );
		System.out.println(p.getMode().name());
		
	}

}
