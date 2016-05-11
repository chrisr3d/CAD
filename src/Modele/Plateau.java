package Modele;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

public class Plateau{
	
	private int largeur;
	private int hauteur;
	private Case[][] carte; 
	ArrayList<Bateau> bateauJoueur;
	ArrayList<Bateau> bateauIA;
	
	public Plateau(int l, int h){
		this.largeur = l;
		this.hauteur = h;
	}
	
	public void placerBateau(Bateau b, Case c){
		
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public Case[][] getCarte() {
		return carte;
	}

	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
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
