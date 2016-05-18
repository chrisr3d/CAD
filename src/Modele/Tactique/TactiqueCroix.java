package Modele.Tactique;

import java.util.ArrayList;

import Modele.Case;
import Modele.CaseBateau;
import Modele.Parametre;
import Modele.Plateau;
import Modele.Bateau.Bateau;

public class TactiqueCroix implements TactiqueIAStrategie {

	private static String nom = "Croix";
	/**
	 * Booléen pour savoir si la dernière fois que l'on a utilisé cette
	 * stratégie, on a touché un bateau
	 */
	private boolean toucher = false;
	/**
	 * On stocke la case sur lequel on a tiré la dernière fois si on a touché un
	 * bateau, pour tirer autour ensuite
	 */
	private Case dernierTir = null;

	// volatile pour autoriser l'initialisation � null !
	private volatile static TactiqueCroix unique = null;

	public static TactiqueCroix getInstance() {
		/*
		 * Ici je ne pense pas qu'il soit possible de cr�er deux intances en
		 * m�me temps car une instance de l'algo seulement au choix de
		 * l'utilisateur (combobox ) Dans le doute on met le "double check test"
		 * cf cours M1-S7-CAD
		 */
		if (unique == null) {
			synchronized (TactiqueCroix.class) {
				if (unique == null) {
					unique = new TactiqueCroix();
				}
			}
		}
		return unique;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	public Case appliquerTactique(Plateau platIA, Plateau joueur) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// (v�rifier que nous n'avons pas perdu)
		// v�rifier qu'il reste des bateaux adverse et pour soit
		// r�cup�rer les caseBateau du bateau

		// la case que l'on va retourner
		Case tir = null;
		ArrayList<Case> portee = new ArrayList<Case>();
		// pour chaque bateau, on r�cup�re les cases bateaux pour v�rifier la
		// port�e
		for (Bateau bat : platIA.getBateau()) {
			for (CaseBateau cb : bat.getEmplacement()) {
				for (int i = 0; i < Parametre.getLargeurPlateau(); i++) {
					for (int j = 0; j < Parametre.getHauteurPlateau(); j++) {
						if (Math.abs(cb.getX() - joueur.getCarte()[i][j].getX()) + Math.abs(cb.getY() - joueur.getCarte()[i][j].getY()) + ((Parametre.getHauteurPlateau()-1)-cb.getY())  <= bat.getPuissance()) {
							// v�rifier qu'on ne les a pas d�j� ajout�
							if (!portee.contains(joueur.getCarte()[i][j])
									&& !joueur.getCarte()[i][j].isCibler()) {
								portee.add(joueur.getCarte()[i][j]);
							}
						}
					}
				}
			}
		}
		// Si on a touché au dernier tir alors on tir en croix
		if (this.toucher && this.dernierTir != null) {
			// On tir a gauche en premier
			if (this.dernierTir.getX() - 1 >= 0) {
				tir = new Case(this.dernierTir.getX() - 1,this.dernierTir.getY());
			} else if (this.dernierTir.getY() - 1 >= 0) {// en haut
				tir = new Case(this.dernierTir.getX(),this.dernierTir.getY() - 1);
			} else if (this.dernierTir.getX() + 1 < Parametre.getLargeurPlateau()) {// a droite
				tir = new Case(this.dernierTir.getX() + 1,this.dernierTir.getY());
			} else if (this.dernierTir.getY() + 1 < Parametre.getHauteurPlateau()) {// en bas
				tir = new Case(this.dernierTir.getX(),this.dernierTir.getY() + 1);
			}
		} else {// sinon on tir de manière aléatoire
			int indiceAuHasard = (int) (Math.random() * (portee.size() - 1));
			tir = portee.get(indiceAuHasard);
		}
		// vérifier si on a touché
		for (Bateau bat : joueur.getBateau()) {
			if (bat.contientCase(tir)) {
				// stocker le dernier tir et passer toucher à vrai
				this.dernierTir = tir;
				this.toucher = true;
			}
		}
		return tir;
	}

}
