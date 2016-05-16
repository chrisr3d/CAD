package Modele;

import Modele.Epoque.Epoque;
import Modele.Tactique.TactiqueIAStrategie;

public class Parametre {

	private final String placement;
	private final int largeurPlateau;
	private final int hauteurPlateau;
	boolean automatique;
	
	//A faire
	public Parametre(){
		this.placement ="";
		this.largeurPlateau = 0;
		this.hauteurPlateau = 0;
		automatique = false;
	}
	
	//A faire
	public Parametre(String epoque, int hauteurPlateau, int largeurPlateau, String tactique, String placement){
		this.placement ="";
		this.largeurPlateau = 0;
		this.hauteurPlateau = 0;
		automatique = false;
	}
	
	public void sauvegardeParametre(){
		
	}
	
	public String getPlacement() {
		return placement;
	}
	
	
}
