package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modele.Parametre;
import Modele.Epoque.Epoque;
import Modele.Epoque.EpoqueActuelle;
import Modele.Epoque.EpoqueFutur;

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
	
	/**
	 * Cette méthode peut retourner null 
	 * Elle peut également déclencher une EXCEPTION si parametre ne contient pas tout les paramètres nécessaires.
	 */
	public Parametre find() {
		// TODO Auto-generated method stub
		BufferedReader fichier;
		Parametre p = null;
		//Booléen qui va passer a TRUE si le fichier est mal formé et que le parametre ne contient pas tout les attributs nécessaires
		boolean caMarchePas = false;
		try {
			fichier = new BufferedReader(new FileReader("save.xml"));
			String ligne;
			while ((ligne=fichier.readLine())!=null){
				if(ligne.equals("<Parametre>")){
					
					
					//Largeur
					ligne=fichier.readLine();
					if(ligne.equals("<Largeur>")){
						ligne=fichier.readLine();
						p.setLargeurPlateau(Integer.parseInt(ligne));
						ligne=fichier.readLine();
					}else{
						caMarchePas = true;
					}
					
					//Hauteur
					ligne=fichier.readLine();
					if(ligne.equals("<Hauteur>")){
					}else{
						caMarchePas = true;
					}
				}
			}
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void save(Parametre contenu) {
		// TODO Auto-generated method stub
		BufferedWriter fichier;
		try {
			fichier = new BufferedWriter(new FileWriter("save.xml",true));
			fichier.write("<Parametre>");
			fichier.newLine();
			
				fichier.write("<Largeur>");
				fichier.newLine();
				fichier.write(contenu.getLargeurPlateau());
				fichier.newLine();
				fichier.write("</Largeur>");
				
				fichier.write("<Hauteur>");
				fichier.newLine();
				fichier.write(contenu.getHauteurPlateau());
				fichier.newLine();
				fichier.write("</Hauteur>");
				
				fichier.write("<Auto>");
				fichier.newLine();
				fichier.write(contenu.isAutomatique() ? "true" : "false");
				fichier.newLine();
				fichier.write("</Auto>");
				
			fichier.newLine();
			fichier.write("</Parametre>");
			fichier.newLine();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
