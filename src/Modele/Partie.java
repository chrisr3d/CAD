package Modele;

import java.io.File;
import Modele.Observable;
 

import Modele.Bateau.Bateau;
import Modele.Bateau.FabriqueBateau;

public class Partie extends Observable{

	private static Partie INSTANCE = new Partie();

	
	Parametre param;
	
	int NbBateauRestantJoueur;
	
	int NbBateauRestantIA;
	
	Plateau joueur;
	
	Plateau IA;
	
	private Partie(){
		
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
	
	public static Partie getInstance()
	{	return INSTANCE;
	}

	public Parametre getParam() {
		return param;
	}

	public void setParam(Parametre param) {
		this.param = param;
	}

	public int getNbBateauRestantJoueur() {
		return NbBateauRestantJoueur;
	}

	public void setNbBateauRestantJoueur(int nbBateauRestantJoueur) {
		NbBateauRestantJoueur = nbBateauRestantJoueur;
	}

	public int getNbBateauRestantIA() {
		return NbBateauRestantIA;
	}

	public void setNbBateauRestantIA(int nbBateauRestantIA) {
		NbBateauRestantIA = nbBateauRestantIA;
	}

	public Plateau getJoueur() {
		return joueur;
	}

	public void setJoueur(Plateau joueur) {
		this.joueur = joueur;
	}

	public Plateau getIA() {
		return IA;
	}

	public void setIA(Plateau iA) {
		IA = iA;
	}
}
