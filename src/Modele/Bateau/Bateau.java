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
}
