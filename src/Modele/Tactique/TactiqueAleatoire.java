package Modele.Tactique;

import Modele.Case;

public class TactiqueAleatoire implements TactiqueIAStrategie{

	public static String nom="Aleatoire";
	//volatile pour autoriser l'initialisation à null !
	private volatile static TactiqueAleatoire unique = null;
	public static TactiqueAleatoire getInstance(){
		 /* Ici je ne pense pas qu'il soit possible de créer deux intances en même temps
		    car une instance de l'algo seulement au choix de l'utilisateur (combobox )
		    Dans le doute on met le "double check test"
	     	cf cours M1-S7-CAD */
		if(unique == null){
			synchronized(TactiqueAleatoire.class){
				if(unique == null){
					unique = new TactiqueAleatoire();
				}
			}
		}
		return unique;
	}

	@Override
	public Case appliquerTactique(Plateau plat) {
		// TODO Auto-generated method stub
		return null;
	}

}
