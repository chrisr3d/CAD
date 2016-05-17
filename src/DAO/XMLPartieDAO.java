package DAO;

import java.io.File;

import Modele.Parametre;

public class XMLPartieDAO extends DAO<Modele.Parametre> {

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
	public Parametre find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String contenu) {
		// TODO Auto-generated method stub
		
	}

}
