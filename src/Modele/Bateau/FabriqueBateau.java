package Modele.Bateau;

import java.util.ArrayList;

import Modele.Epoque.Epoque;

public class FabriqueBateau {
	
	public static Bateau getBateau(int taille){
		// Création des bateau avec le decorateur
		Bateau b = new Bateau(taille);
		return b;
	}
		
}
	 


