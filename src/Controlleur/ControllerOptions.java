package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import Modele.Modes;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;
import Modele.Bateau.FabriqueBateau;
import Modele.Epoque.FabriqueEpoque;
import Modele.Epoque.listeEpoque;
import Modele.Tactique.ContexteTactique;
import Modele.Tactique.ListeTactique;
import Vue.Options;
import Vue.Placement;
import Vue.VueJeu;

/**
 * @author Misternutz
 *
 */
public class ControllerOptions implements ActionListener {

	private Parametre p;
	private Options o;
	private Partie pa;
	// private FenetreJeu f;

	public ControllerOptions(Options o) {

		this.o = o;

	}

	@SuppressWarnings("incomplete-switch")
	public void actionPerformed(ActionEvent e) {

		Double d = (Double) o.getSpinner().getValue();
		Integer i = d.intValue();

		Double d2 = (Double) o.getNbBateau().getValue();
		Integer nbBoat = d2.intValue();

		Double d3 = (Double) o.getTailleBateau().getValue();
		Integer tailleB = d3.intValue();

		Parametre p = new Parametre((int) i, (int) i, true, (Modes) o.getModes().getSelectedItem());
		o.getFrame().setVisible(false);
		o.getFrame().setEnabled(false);
		Plateau jeu;
		Plateau adversaire;

		jeu = new Plateau((int) i, (int) i);
		adversaire = new Plateau((int) i, (int) i);
		if (o.getRdbtnAutomatique().isSelected()) {

			if (o.getModes().getSelectedItem() == Modes.Normal) {
				for (int j = 0; j < nbBoat; j++) {
					jeu.placerAleatoireBateau(FabriqueBateau.getBateau(tailleB));
					adversaire.placerAleatoireBateau(FabriqueBateau.getBateau(tailleB));
					// PlacerBateau

				}
				

			} else {

				for (int k = 0; k < nbBoat; k++) {
					int t = 2 + (int)(Math.random() * ((5 - 2) + 1));
					jeu.placerAleatoireBateau(FabriqueBateau.getBateau(t));
					adversaire.placerAleatoireBateau(FabriqueBateau.getBateau(t));

				}

			}
			switch ((listeEpoque) o.getComboBox().getSelectedItem()) {
			case Actuelle:
				FabriqueEpoque.setEpoqueActuelle();
				FabriqueEpoque.choisirEpoqueFutur(jeu.getBateau());
				FabriqueEpoque.choisirEpoqueFutur(adversaire.getBateau());
				break;
			case Futur:
				FabriqueEpoque.setEpoqueFutur();
				FabriqueEpoque.choisirEpoqueActuelle(jeu.getBateau());
				FabriqueEpoque.choisirEpoqueActuelle(adversaire.getBateau());
				break;
			}
			
			
			switch((ListeTactique) o.getComboBox_1().getSelectedItem()){
			case Aleatoire :
				ContexteTactique.choisirTactiqueAleatoire();
				break;
				
			case Croix :
				ContexteTactique.choisirTactiqueCroix();
				break;
			}

			Partie.getInstance().setJoueur(jeu);
			Partie.getInstance().setIA(adversaire);
			Partie.getInstance().setNbBateauRestantIA(nbBoat);
			Partie.getInstance().setNbBateauRestantJoueur(nbBoat);
			Partie.getInstance().setParam(p);
			
			jeu.remplirCaseVide();
			adversaire.remplirCaseVide();
			VueJeu vj = new VueJeu();
			vj.getFrame().setVisible(true);

		} else {
			// Placement manuel des bateaux

			// Placement adversaire
			Partie.getInstance().setParam(p);
			Placement pl = new Placement(o);
			pl.getFrame().setVisible(true);

		}

	}

}
