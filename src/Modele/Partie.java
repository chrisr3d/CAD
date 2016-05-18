package Modele;

import java.io.File;
import Modele.Observable;
 

import Modele.Bateau.Bateau;
import Modele.Bateau.FabriqueBateau;

public class Partie extends Observable{

	Parametre param;
	
	int NbBateauRestantJoueur;
	
	int NbBateauRestantIA;
	
	Plateau joueur;
	
	Plateau IA;
	
	FabriqueBateau fabrique; // Permet la création des bateau
	
	public Partie(Parametre param){
		
	}
	public void Jouer(){
		
	}
	
	public void JouerIA(){
		
	}
	
	public void SauvegarderPartie(){
		try{
    		
    		File file = new File("save.xml");
    		if(!file.delete()){
    			System.out.println("on a pas réussi a supprimer le fichier");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public void changerParametre(){
		
	}
	public void tournerBateau(Bateau b){
		
	}
	
	public Parametre getParametres() {
		return param;
	}
}
