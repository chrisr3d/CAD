package Modele;

import java.util.ArrayList;

import Modele.Bateau.Bateau;

/**
 * @author Misternutz
 *
 */
public class Plateau {

	private Case[][] carte;
	ArrayList<Bateau> bateau;

	public Plateau(int l, int h) {
		bateau = new ArrayList<Bateau>();
		carte = new Case[l][h];
	}

	public void placerBateau(Bateau b, Case c) {

	}

	public Case[][] getCarte() {
		return carte;
	}

	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}

	public ArrayList<Bateau> getBateau() {
		return bateau;
	}

	public void setBateau(ArrayList<Bateau> bateau) {
		this.bateau = bateau;
	}
	
	public void remplirCaseVide(){
		for(int i =0;i<carte.length;i++){
			for(int j = 0; j<carte.length;j++){
				if(!(carte[i][j] instanceof CaseBateau)){
					carte[i][j] = new Case(i,j);
				}
			}
		}
		
	}

	 
	public void placerAleatoireBateau(Bateau b) {

		boolean placer = false;
		boolean cut = false;
		int orient;

		// Placement horizontal
		while (!placer) {
			cut = false;
			orient = 1 + (int) (Math.random() * ((2 - 1) + 1));
			if (orient == 1) {

				int ligne = (int) 0 + (int) (Math.random() * ((carte.length - 1) + 1));
				int colone = 0 + (int) (Math.random() * (((carte.length - b.taille)) + 1));

				ArrayList<CaseBateau> caseb = new ArrayList<CaseBateau>();
				for (int p = 0; p < b.taille; p++) {
					if (colone + p > carte.length - 1) {
						cut = true;
					}

				}

				if (!cut) {
					for (int p = 0; p < b.taille; p++) {
						if (carte[ligne][colone + p] != null) {
							cut = true;
						}

					}
				}

				if (!cut) {
					for (int j = 0; j < b.taille; j++) {
						caseb.add(new CaseBateau(ligne, colone + j));
					}
					b.setEmplacement(caseb);
					bateau.add(b);

					for (int k = 0; k < b.taille; k++) {
						carte[ligne][colone + k] = caseb.get(k);

					}
					placer = true;
				}

				// Placement vertical
			} else {

				int ligne = 0 + (int) (Math.random() * (((carte.length - b.taille)) + 1));
				int colone = (int) 0 + (int) (Math.random() * ((carte.length - 1) + 1));

				ArrayList<CaseBateau> caseb = new ArrayList<CaseBateau>();

				for (int p = 0; p < b.taille; p++) {
					if (ligne + p > carte.length - 1) {

						cut = true;
					}
				}
				if (!cut) {
					for (int p = 0; p < b.taille; p++) {
						if (carte[ligne + p][colone] != null) {

							cut = true;
						}
					}
				}

				if (!cut) {
					for (int j = 0; j < b.getTaille(); j++) {
						caseb.add(new CaseBateau(ligne + j, colone));
					}
					b.setEmplacement(caseb);
					bateau.add(b);

					for (int k = 0; k < b.getTaille(); k++) {

						carte[ligne + k][colone] = caseb.get(k);

					}
					placer = true;
				}

			}
		}

	}

	public void ajouterBateau(Bateau b) {
		bateau.add(b);

	}

}
