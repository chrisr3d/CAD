package Modele;

import Modele.Epoque.Epoque;
import Modele.Tactique.TactiqueIAStrategie;

public class Parametre {

	TactiqueIAStrategie tactique; // Non definitif
	
	private final String placement;
	private final int largeurPlateau;
	private final int hauteurPlateau;
	boolean automatique;
	String epoque; // Non definitif
	
	public Parametre(){
		
	}
	
	public Parametre(String epoque, int hauteurPlateau, int largeurPlateau, String tactique, String placement){
		
	}
	
	public void sauvegardeParametre(){
		
	}
	
	public String getPlacement() {
		return placement;
	}
	
	public String getEpoque() {
		return epoque;
	}
	
	
}
