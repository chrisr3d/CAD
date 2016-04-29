package Modele;

import java.io.File;
import Modele.Observable;
 

import Modele.Bateau.Bateau;
import Modele.Bateau.FabriqueBateau;
import bataillenavale.game.OptionsJeu;

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
	
	public void SauvegarderPartie(String nom, File f){
		
	}
	
	public void changerParametre(String nom, File f){
		
	}
	public void tournerBateau(Bateau b){
		
	}
	
	public Parametre getParametres() {
		return param;
	}
}
