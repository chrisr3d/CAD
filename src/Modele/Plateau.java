package Modele;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

public class Plateau {

	private Case[][] carte;
	ArrayList<Bateau> bateau;

	public Plateau(int l, int h) {
	}

	public void placerBateau(Bateau b, Case c) {

	}

	public Case[][] getCarte() {
		return carte;
	}

	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}

	public ArrayList<Bateau> getBateau() {
		return bateau;
	}

	public void setBateau(ArrayList<Bateau> bateau) {
		this.bateau = bateau;
	}

	public void tirer(Case c) {

	}

	public void placerAleatoireBateau(Bateau b) {

	}

	public void ajouterBateau(Bateau b) {

	}

}
