package Modele;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

public class Plateau{
	
	private Case[][] carte; 
	ArrayList<Bateau> bateauJoueur;
	ArrayList<Bateau> bateauIA;
	
	public Plateau(int l, int h){
	}
	
	public void placerBateau(Bateau b, Case c){
		
	}

	public Case[][] getCarte() {
		return carte;
	}

	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}

	public ArrayList<Bateau> getBateauJoueur() {
		return bateauJoueur;
	}

	public void setBateauJoueur(ArrayList<Bateau> bateauJoueur) {
		this.bateauJoueur = bateauJoueur;
	}

	public ArrayList<Bateau> getBateauIA() {
		return bateauIA;
	}

	public void setBateauIA(ArrayList<Bateau> bateauIA) {
		this.bateauIA = bateauIA;
	}

	public void tirer(Case c){
		
	}
	
	public void placerAleatoireBateau(Bateau b){
		
	}
	
	public void ajouterBateau(Bateau b) {
		
	}

}	
