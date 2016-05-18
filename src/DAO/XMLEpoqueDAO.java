package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modele.Epoque.Epoque;
import Modele.Epoque.EpoqueActuelle;
import Modele.Epoque.EpoqueFutur;
import Modele.Epoque.FabriqueEpoque;

public class XMLEpoqueDAO extends DAO<Epoque>{

	private volatile static XMLEpoqueDAO unique = null;

	public static XMLEpoqueDAO getInstance() {
		if (unique == null) {
			synchronized (XMLEpoqueDAO.class) {
				if (unique == null) {
					unique = new XMLEpoqueDAO();
				}
			}
		}
		return unique;
	}
	
	/**
	 * Méthode qui peut retourner "null" si l'époque enregistrer ne fait pas partie des 
	 * époque existante
	 */
	@Override
	public Epoque find() {
		// TODO Auto-generated method stub
		BufferedReader fichier;
		try {
			fichier = new BufferedReader(new FileReader("save.xml"));
			String ligne;
			while ((ligne=fichier.readLine())!=null){
				//si on trouve une ligne qui commence par époque, on lit la suivante
				if(ligne.equals("<Epoque>")){
					ligne=fichier.readLine();
					if(ligne.equals("Futur")){
						return EpoqueFutur.getInstance();
					}else if(ligne.equals("Actuelle")){
						return EpoqueActuelle.getInstance();
					}
				}
			}
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Epoque contenu) {
		// TODO Auto-generated method stub
		BufferedWriter fichier;
		try {
			fichier = new BufferedWriter(new FileWriter("save.xml",true));
			fichier.write("<Epoque>");
			fichier.newLine();
			fichier.write(contenu.getNomEpoque());
			fichier.newLine();
			fichier.write("</Epoque>");
			fichier.newLine();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
