package DAO;

import Modele.Partie;

public class XMLPartieDAO extends DAO<Partie> {

	private volatile static XMLPartieDAO unique = null;

	public static XMLPartieDAO getInstance() {
		if (unique == null) {
			synchronized (XMLPartieDAO.class) {
				if (unique == null) {
					unique = new XMLPartieDAO();
				}
			}
		}
		return unique;
	}
	
	@Override
	public Partie find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Partie contenu) {
		// TODO Auto-generated method stub
		
	}

}
