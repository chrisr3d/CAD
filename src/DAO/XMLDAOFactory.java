package DAO;


/**
 * 
 * @author Mathieu
 * aide du site : 
 * http://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/
 */
public class XMLDAOFactory extends AbstractDAOFactory{

	public XMLPartieDAO getPartieDAO() {
		return XMLPartieDAO.getInstance();
	}
	public XMLParametreDAO getParametreDAO() {
		return XMLParametreDAO.getInstance();
	}
	public XMLEpoqueDAO getEpoqueDAO() {
		return XMLEpoqueDAO.getInstance();
	}
	public XMLStrategieDAO getStrategie(){
		return XMLStrategieDAO.getInstance();
	}
	
}
