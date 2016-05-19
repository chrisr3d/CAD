package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modele.Tactique.TactiqueAleatoire;
import Modele.Tactique.TactiqueCroix;
import Modele.Tactique.TactiqueIAStrategie;

/**
 * Classe qui permet la sauvegarder la récupération de la stratégie à appliquer à la partie 
 * @author Mathieu
 *
 */
public class XMLStrategieDAO extends DAO<TactiqueIAStrategie>{

	private volatile static XMLStrategieDAO unique = null;

	public static XMLStrategieDAO getInstance() {
		if (unique == null) {
			synchronized (XMLStrategieDAO.class) {
				if (unique == null) {
					unique = new XMLStrategieDAO();
				}
			}
		}
		return unique;
	}
	
	/**
	 * On retourne "NULL" ici car on applique directionement la stratégie 
	 */
	@Override
	public TactiqueIAStrategie find() {
		// TODO Auto-generated method stub
		BufferedReader fichier;
		try {
			fichier = new BufferedReader(new FileReader("save.xml"));
			String ligne;
			while ((ligne=fichier.readLine())!=null){
				//si on trouve une ligne qui commence par époque, on lit la suivante
				if(ligne.equals("<Strategie>")){
					ligne=fichier.readLine();
					if(ligne.equals("Aleatoire")){
						return TactiqueAleatoire.getInstance();
					}else if(ligne.equals("Croix")){
						return TactiqueCroix.getInstance();
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
	public void save(TactiqueIAStrategie contenu) {
		// TODO Auto-generated method stub
		BufferedWriter fichier;
		try {
			fichier = new BufferedWriter(new FileWriter("save.xml",true));
			fichier.write("<Strategie>");
			fichier.newLine();
			fichier.write(contenu.getNom());
			fichier.newLine();
			fichier.write("</Strategie>");
			fichier.newLine();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
