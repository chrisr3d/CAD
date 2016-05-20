package Modele.Tactique;

import java.util.ArrayList;

import Modele.Case;
import Modele.CaseBateau;
import Modele.Parametre;
import Modele.Plateau;
import Modele.Bateau.Bateau;

/**
 * Classe qui va appliquer la tactique aléatoire
 * Design Pattern : Singleton 
 * 
 * @author Mathieu
 *
 */
public class TactiqueAleatoire implements TactiqueIAStrategie {

	private static String nom = "Aleatoire";
	// volatile pour autoriser l'initialisation ï¿½ null !
	private volatile static TactiqueAleatoire unique = null;

	/**
	 * @return l'instance de la classe
	 */
	public static TactiqueAleatoire getInstance() {
		/*
		 * Ici je ne pense pas qu'il soit possible de crï¿½er deux intances en
		 * mï¿½me temps car une instance de l'algo seulement au choix de
		 * l'utilisateur (combobox ) Dans le doute on met le "double check test"
		 * cf cours M1-S7-CAD
		 */
		if (unique == null) {
			synchronized (TactiqueAleatoire.class) {
				if (unique == null) {
					unique = new TactiqueAleatoire();
				}
			}
		}
		return unique;
	}

	public Case appliquerTactique(Plateau platIA, Plateau joueur) {
		// TODO Auto-generated method stub
		// la case que l'on va retourner
		Case tir = null;
		ArrayList<Case> portee = new ArrayList<Case>();
		// pour chaque bateau, on récupére les cases bateaux pour vï¿½rifier la
		// porté
		for (Bateau bat : platIA.getBateau()) {
			for (CaseBateau cb : bat.getEmplacement()) {
				for (int i = 0; i < Parametre.getLargeurPlateau(); i++) {
					for (int j = 0; j < Parametre.getHauteurPlateau(); j++) {
						if (Math.abs(cb.getX() - joueur.getCarte()[i][j].getX()) + Math.abs(cb.getY() - joueur.getCarte()[i][j].getY()) + ((Parametre.getHauteurPlateau()-1)-cb.getY())  <= bat.getPuissance()) {
							// vï¿½rifier qu'on ne les a pas dï¿½jï¿½ ajoutï¿½
							if (!portee.contains(joueur.getCarte()[i][j])
									&& !joueur.getCarte()[i][j].isCibler()) {
								portee.add(joueur.getCarte()[i][j]);
							}
						}
					}
				}
			}
		}
		
		int indiceAuHasard = (int) (Math.random() * (portee.size() - 1));
		if(!portee.isEmpty()){
		tir = portee.get(indiceAuHasard);
		}else{
			tir = null;
		}
		return tir;
	}
	
	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

}