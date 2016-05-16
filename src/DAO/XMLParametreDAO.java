package DAO;

import java.io.File;
import java.io.FileWriter;

import Modele.Parametre;

public class XMLParametreDAO extends DAO<Parametre>{

	private volatile static XMLParametreDAO unique = null;

	public static XMLParametreDAO getInstance() {
		if (unique == null) {
			synchronized (XMLParametreDAO.class) {
				if (unique == null) {
					unique = new XMLParametreDAO();
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
