package Modele.Bateau;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Modele.CaseBateau;

public class Bateau {

	public int taille;
	
	public int puissance;
	
	ArrayList<CaseBateau> emplacement;
	
	public String nom;
	
	protected BufferedImage texture;
	
	boolean horizontal;

	public int getTaille() {
		// TODO Auto-generated method stub
		return this.taille;
	}

	public void setNom(String nom) {
		// TODO Auto-generated method stub
		this.nom = nom;
	}

	public void setPuissance(int puissance) {
		// TODO Auto-generated method stub
		this.puissance=puissance;
	}

	public ArrayList<CaseBateau> getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(ArrayList<CaseBateau> emplacement) {
		this.emplacement = emplacement;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public int getPuissance() {
		return puissance;
	}

	public String getNom() {
		return nom;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
}
