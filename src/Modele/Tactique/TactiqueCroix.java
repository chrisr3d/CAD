package Modele.Tactique;

import java.util.ArrayList;

import Modele.Case;
import Modele.CaseBateau;
import Modele.Plateau;
import Modele.Bateau.Bateau;

public class TactiqueCroix implements TactiqueIAStrategie {

	public static String nom = "Croix";
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

	public Case appliquerTactique(Plateau plat) {
		// TODO Auto-generated method stub
		// (v�rifier que nous n'avons pas perdu)
		// v�rifier qu'il reste des bateaux adverse et pour soit
		// r�cup�rer les caseBateau du bateau

		// la case que l'on va retourner
		Case tir = null;
		ArrayList<Case> portee = new ArrayList<Case>();
		// pour chaque bateau, on r�cup�re les cases bateaux pour v�rifier la
		// port�e
		for (Bateau bat : plat.getBateauIA()) {
			for (CaseBateau cb : bat.getEmplacement()) {
				for (int i = plat.getLargeur() / 2; i < plat.getLargeur(); i++) {
					for (int j = plat.getHauteur() / 2; j < plat.getHauteur(); j++) {
						if (Math.abs(cb.getX() - plat.getCarte()[i][j].getX())
								+ Math.abs(cb.getY()
										- plat.getCarte()[i][j].getY()) <= bat
									.getPuissance()) {
							// v�rifier qu'on ne les a pas d�j� ajout�
							if (!portee.contains(plat.getCarte()[i][j])
									&& !plat.getCarte()[i][j].isCibler()) {
								portee.add(plat.getCarte()[i][j]);
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
				tir = new Case(this.dernierTir.getX() - 1,
						this.dernierTir.getY());
			} else if (this.dernierTir.getY() - 1 >= plat.getHauteur() / 2) {// en
																				// haut
				tir = new Case(this.dernierTir.getX(),
						this.dernierTir.getY() - 1);
			} else if (this.dernierTir.getX() + 1 < plat.getLargeur()) {// a
																		// droite
				tir = new Case(this.dernierTir.getX() + 1,
						this.dernierTir.getY());
			} else if (this.dernierTir.getY() + 1 < plat.getHauteur()) {// en
																		// bas
				tir = new Case(this.dernierTir.getX(),
						this.dernierTir.getY() + 1);
			}
		} else {// sinon on tir de manière aléatoire
			int indiceAuHasard = (int) (Math.random() * (portee.size() - 1));
			tir = portee.get(indiceAuHasard);
		}
		// vérifier si on a touché
		for (Bateau bat : plat.getBateauJoueur()) {
			if (bat.contientCase(tir)) {
				// stocker le dernier tir et passer toucher à vrai
				this.dernierTir = tir;
				this.toucher = true;
			}
		}
		return tir;
	}

}
