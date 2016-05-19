package Modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import Modele.Observable;

import Modele.Bateau.Bateau;

public class Partie extends Observable {

	private volatile static Partie unique = null;

	Parametre param;

	int NbBateauRestantJoueur;

	int NbBateauRestantIA;

	Plateau joueur;

	Plateau IA;

	public static Partie getInstance(){
		if(unique == null){
			synchronized(Partie.class){
				if(unique == null){
					unique = new Partie();
				}
			}
		}
		return unique;
	}
	
	private Partie() {

	}

	public void Jouer() {

	}

	public void JouerIA() {

	}

	public void SauvegarderPartie() {
		File file = new File("save.xml");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void changerParametre() {

	}

	public void tournerBateau(Bateau b) {

	}

	public Parametre getParametres() {
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
