package Controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import Modele.Case;
import Modele.CaseBateau;
import Modele.Parametre;
import Modele.Partie;
import Modele.Bateau.Bateau;
import Vue.VueJeu;

/**
 * @author Misternutz
 *
 */
public class ControllerJeu implements ActionListener, MouseListener, MouseMotionListener {
	boolean tir = false;
	VueJeu vue;

	public ControllerJeu(VueJeu vj) {
		this.vue = vj;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// Tour du joueur

		for (int i = 1; i < vue.getGrille().length; i++) {
			for (int j = 1; j < vue.getGrille().length; j++) {

				if (arg0.getSource() == vue.getGrille()[i][j]) {

					if (!vue.getGrille()[i][j].isEnabled()) {
						tir = false;
					} else {
						tir = true;
						vue.getGrille()[i][j].setEnabled(false);
						boolean touch = Partie.getInstance()
								.tirer(Partie.getInstance().getIA().getCarte()[i - 1][j - 1]);
						if (touch) {

							vue.getGrille()[i][j].setText("TOUCHE");
							vue.getGrille()[i][j].setForeground(Color.RED);
						} else {

							vue.getGrille()[i][j].setText("COULE");
						}
					}

				}
			}
		}

		// Vérification si un bateau adversaire est mort apres tir
		Partie.getInstance().verificationMort(Partie.getInstance().getIA());
		if (Partie.getInstance().getNbBateauRestantIA() == 0) {
			String[] victoire = { " Quitter " };

			int rang = JOptionPane.showOptionDialog(null, "Vous avez gagné !!!", "", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, victoire, victoire[0]);

			if (rang == JOptionPane.OK_OPTION) {
				vue.getFrame().setVisible(false);
				vue.getFrame().setEnabled(false);
				System.exit(0);
			}

		}

		// Tour de l'IA

		if (tir) {
			vue.getInformations().setText("Tour de l'adversaire");

			Case touchIA = Partie.getInstance().JouerIA();
			if (touchIA != null) {

				for (int i = 0; i < Partie.getInstance().getJoueur().getCarte().length; i++) {
					for (int j = 0; j < Partie.getInstance().getJoueur().getCarte().length; j++) {

						if (Partie.getInstance().getJoueur().getCarte()[i][j].getX() == touchIA.getX()
								&& Partie.getInstance().getJoueur().getCarte()[i][j].getY() == touchIA.getY()) {

							Partie.getInstance().getJoueur().getCarte()[i][j].setCibler(true);
							Partie.getInstance()
									.caseDonneBateauJoueur(Partie.getInstance().getJoueur().getCarte()[i][j]);
							vue.getGrille2()[i + 1][j + 1].setBackground(Color.BLUE);
							if (Partie.getInstance().getJoueur().getCarte()[i][j] instanceof CaseBateau) {
								vue.getInformations().setText("L'IA vous a touché !");
								vue.getGrille2()[i + 1][j + 1].setBackground(Color.RED);
								;
							}

						}
					}

				}
			} else {
				String[] victoire = { " Quitter " };

				int rang = JOptionPane.showOptionDialog(null, "Vous avez gagné, l'IA ne peut plus vous toucher !!!", "",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, victoire, victoire[0]);

				if (rang == JOptionPane.OK_OPTION) {
					vue.getFrame().setVisible(false);
					vue.getFrame().setEnabled(false);
					System.exit(0);
				}

			}
			Partie.getInstance().verificationMort(Partie.getInstance().getJoueur());
		}

		if (Partie.getInstance().getNbBateauRestantJoueur() == 0) {
			String[] victoire = { " Quitter " };

			int rang = JOptionPane.showOptionDialog(null, "Vous avez perdu...", "", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, victoire, victoire[0]);

			if (rang == JOptionPane.OK_OPTION) {
				vue.getFrame().setVisible(false);
				vue.getFrame().setEnabled(false);
				System.exit(0);
			}

		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

		/*
		 * for (int i = 1; i < vue.getGrille().length; i++) { for (int j = 1; j
		 * < vue.getGrille().length; j++) {
		 * 
		 * for(Bateau b : Partie.getInstance().getJoueur().getBateau()){
		 * 
		 * } if (arg0.getSource() == vue.getGrille()[i][j]) { if
		 * ((vue.getGrille()[i][j].getText().equals(""))) {
		 * vue.getGrille()[i][j].setText("x"); } } } }
		 */

		for (Bateau bat : Partie.getInstance().getJoueur().getBateau()) {
			for (CaseBateau cb : bat.getEmplacement()) {
				for (int i = 0; i < Parametre.getHauteurPlateau(); i++) {
					for (int j = 0; j < Parametre.getLargeurPlateau(); j++) {
						
						
						
					}
				}
			}
		}

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

		for (int i = 1; i < vue.getGrille().length; i++) {
			for (int j = 1; j < vue.getGrille().length; j++) {

				if (arg0.getSource() == vue.getGrille()[i][j]) {
					if ((vue.getGrille()[i][j].getText().equals("x"))) {

						vue.getGrille()[i][j].setText("");
					}

				}
			}
		}
	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("hi");
	}

}
