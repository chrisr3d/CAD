import java.util.ArrayList;

import DAO.XMLPartieDAO;
import Modele.CaseBateau;
import Modele.Modes;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;
import Modele.Bateau.Bateau;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		XMLPartieDAO partie = XMLPartieDAO.getInstance();
		Parametre p = new Parametre(6, 6, true,Modes.Normal);
		ArrayList<Bateau> listBoat = new ArrayList<Bateau>();
		
		Bateau b1 = new Bateau(2,true);
		ArrayList<CaseBateau> cb = new ArrayList<CaseBateau>();
		CaseBateau cb1 = new CaseBateau(1, 1);
		CaseBateau cb2 = new CaseBateau(2, 1);
		cb.add(cb1);
		cb.add(cb2);
		b1.setEmplacement(cb);
		
		Bateau b2 = new Bateau(3,true);
		ArrayList<CaseBateau> cbb = new ArrayList<CaseBateau>();
		CaseBateau cb11 = new CaseBateau(2, 2);
		CaseBateau cb22 = new CaseBateau(3, 2);
		CaseBateau cb33 = new CaseBateau(4, 2);
		cb11.setCibler(true);
		cbb.add(cb11);
		cbb.add(cb22);
		cbb.add(cb33);
		b2.setEmplacement(cbb);
		
		listBoat.add(b1);
		listBoat.add(b2);
		
		ArrayList<Bateau> listBoatJ = new ArrayList<Bateau>();
		
		Bateau bj = new Bateau(4,false);
		ArrayList<CaseBateau> cbj = new ArrayList<CaseBateau>();
		CaseBateau cb1j = new CaseBateau(1, 1);
		CaseBateau cb2j = new CaseBateau(1, 2);
		CaseBateau cb3j = new CaseBateau(1, 3);
		CaseBateau cb4j = new CaseBateau(1, 4);
		cbj.add(cb1j);
		cbj.add(cb2j);
		cbj.add(cb3j);
		cbj.add(cb4j);
		
		bj.setEmplacement(cbj);
		
		Bateau b2j = new Bateau(2,false);
		ArrayList<CaseBateau> cbbj = new ArrayList<CaseBateau>();
		CaseBateau cb11j = new CaseBateau(3, 1);
		CaseBateau cb22j = new CaseBateau(3, 2);
		cb11j.setCibler(true);
		cbbj.add(cb11j);
		cbbj.add(cb22j);
		b2j.setEmplacement(cbbj);
		
		listBoatJ.add(bj);
		listBoatJ.add(b2j);
		
		Plateau plateauIA = new Plateau(Parametre.getLargeurPlateau(),Parametre.getHauteurPlateau());
		plateauIA.setBateau(listBoat);
		Plateau plateauJ = new Plateau(Parametre.getLargeurPlateau(),Parametre.getHauteurPlateau());
		plateauJ.setBateau(listBoatJ);
		
		Partie parti = Partie.getInstance();
		parti.setParam(p);
		parti.setJoueur(plateauJ);
		parti.setIA(plateauIA);
		
		parti.setNbBateauRestantIA(2);
		parti.setNbBateauRestantJoueur(2);
		
		parti.SauvegarderPartie();
		partie.save(parti);
		
		Partie pppppp = partie.find();
		for (int i = 0; i < Parametre.getLargeurPlateau(); i++) {
			for (int j = 0; j < Parametre.getHauteurPlateau(); j++) {
				if(parti.getJoueur().getCarte()[i][j] != null){
					System.out.println(parti.getJoueur().getCarte()[i][j].getX() + "  " + parti.getJoueur().getCarte()[i][j].getY());
				}
			}
		}
		
	}

}
