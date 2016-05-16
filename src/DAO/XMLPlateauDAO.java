package DAO;

import java.io.File;
import java.io.FileWriter;

import Modele.Plateau;

public class XMLPlateauDAO extends DAO<Plateau>{

	private volatile static XMLPlateauDAO unique = null;

	public static XMLPlateauDAO getInstance() {
		if (unique == null) {
			synchronized (XMLPlateauDAO.class) {
				if (unique == null) {
					unique = new XMLPlateauDAO();
				}
			}
		}
		return unique;
	}
	
	@Override
	public Plateau find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String contenu) {
		// TODO Auto-generated method stub
		
	}

}
