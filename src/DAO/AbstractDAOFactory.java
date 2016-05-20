package DAO;

/**
 * 
 * @author Mathieu aide du site :
 *         http://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-
 *         donnees-avec-pattern-dao/
 */
public abstract class AbstractDAOFactory {

	public abstract DAO getPartieDAO();

	public abstract DAO getEpoqueDAO();

	public abstract DAO getParametreDAO();

	/**
	 * Methode nous permettant de recuperer une factory de DAO
	 * 
	 * @param type
	 * @return AbstractDAOFactory
	 */
	public static AbstractDAOFactory getFactory(FactoryTypeDAO type) {

		if (type != null) {
			if (type.equals(type.XML_DAO_Factory)) {
				return new XMLDAOFactory();
			}
		}

		return null;
	}

}
