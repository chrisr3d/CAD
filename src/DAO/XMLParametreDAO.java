package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Modele.Modes;
import Modele.Parametre;
import Modele.Epoque.Epoque;
import Modele.Epoque.EpoqueActuelle;
import Modele.Epoque.EpoqueFutur;
import Modele.Tactique.ListeTactique;

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
	 * Cette méthode peut déclencher une EXCEPTION si parametre ne contient pas tout les paramètres nécessaires.
	 * @throws  
	 */
	public Parametre find() {
		// TODO Auto-generated method stub
		BufferedReader fichier;
		Parametre p = new Parametre();
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
						ligne=fichier.readLine();
						p.setHauteurPlateau(Integer.parseInt(ligne));
						ligne=fichier.readLine();
					}else{
						caMarchePas = true;
					}
					
					//Auto
					ligne=fichier.readLine();
					if(ligne.equals("<Auto>")){
						ligne=fichier.readLine();
						p.setAutomatique( (ligne=="True") ? true : false);
						ligne=fichier.readLine();
					}else{
						caMarchePas = true;
					}
					
					//Auto
					ligne=fichier.readLine();
					if(ligne.equals("<Mode>")){
						ligne=fichier.readLine();
						for (Modes mod : Modes.values()) {
							if(mod.name().equals(ligne)){
								p.setMode(mod);
							}
						}
						ligne=fichier.readLine();
					}else{
						caMarchePas = true;
					}
				}
			}
			fichier.close();
			if(caMarchePas){
				throw( new Exception("La sauvegarde n'est pas récupérable !"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
				fichier.write(Parametre.getLargeurPlateau()+"");
				fichier.newLine();
				fichier.write("</Largeur>");
				fichier.newLine();
				
				fichier.write("<Hauteur>");
				fichier.newLine();
				fichier.write(Parametre.getHauteurPlateau()+"");
				fichier.newLine();
				fichier.write("</Hauteur>");
				fichier.newLine();
				
				fichier.write("<Auto>");
				fichier.newLine();
				fichier.write(contenu.isAutomatique() ? "True" : "False");
				fichier.newLine();
				fichier.write("</Auto>");
				fichier.newLine();
				
				fichier.write("<Mode>");
				fichier.newLine();
				fichier.write(contenu.getMode().name());
				fichier.newLine();
				fichier.write("</Mode>");
				
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
