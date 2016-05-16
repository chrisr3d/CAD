package Modele.Tactique;

import java.util.ArrayList;

import Modele.Case;
import Modele.CaseBateau;
import Modele.Plateau;
import Modele.Bateau.Bateau;

public class TactiqueAleatoire implements TactiqueIAStrategie {

	public static String nom = "Aleatoire";
	// volatile pour autoriser l'initialisation � null !
	private volatile static TactiqueAleatoire unique = null;

	public static TactiqueAleatoire getInstance() {
		/*
		 * Ici je ne pense pas qu'il soit possible de cr�er deux intances en
		 * m�me temps car une instance de l'algo seulement au choix de
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
		
		int indiceAuHasard = (int) (Math.random() * (portee.size() - 1));
		tir = portee.get(indiceAuHasard);

		return tir;
	}

}
