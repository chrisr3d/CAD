package DAO;
/**
 * 
 * @author Mathieu
 * aid� du site : 
 * http://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/
 */
public class XMLDAOFactory extends AbstractDAOFactory{

	public DAO getPartieDAO() {
		return new XMLParametreDAO();
	}
	public DAO getEpoqueDAO() {
		return new XMLEpoqueDAO();
	}
	
}
