package DAO;

import Modele.Parametre;
import Modele.Partie;
import Modele.Epoque.Epoque;

/**
 * 
 * @author Mathieu
 * aid� du site : 
 * http://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/
 */
public class XMLDAOFactory extends AbstractDAOFactory{

	
	public DAO getPartieDAO() {
		return XMLPartieDAO.getInstance();
	}
	public DAO getParametreDAO() {
		return XMLParametreDAO.getInstance();
	}
	public DAO getEpoqueDAO() {
		return XMLEpoqueDAO.getInstance();
	}
	
}
