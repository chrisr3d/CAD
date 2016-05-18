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
	
	public Partie(Parametre param){
		
	}
	
	public void Jouer(){
		
	}
	
	public void JouerIA(){
		
	}
	
	public void SauvegarderPartie(){
		try{
    		
    		File file = new File("save.xml");
    		file.delete();

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
