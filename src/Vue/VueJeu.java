package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import Controlleur.ControllerJeu;
import Modele.CaseBateau;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class VueJeu implements Observer {

	private JFrame frame;
	// private JPanel panelInfo;
	private JTextField informations;
	private JPanel contentPane;
	private JPanel contentPane2;
	private JButton[][] Grille;
	private JTextField[][] Grille2;
	Alphabet tab = new Alphabet();
	ControllerJeu cj = new ControllerJeu(this);

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getInformations() {
		return informations;
	}

	public void setInformations(JTextField informations) {
		this.informations = informations;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JPanel getContentPane2() {
		return contentPane2;
	}

	public void setContentPane2(JPanel contentPane2) {
		this.contentPane2 = contentPane2;
	}

	public JButton[][] getGrille() {
		return Grille;
	}

	public void setGrille(JButton[][] grille) {
		Grille = grille;
	}

	public JTextField[][] getGrille2() {
		return Grille2;
	}

	public void setGrille2(JTextField[][] grille2) {
		Grille2 = grille2;
	}

	public Alphabet getTab() {
		return tab;
	}

	public void setTab(Alphabet tab) {
		this.tab = tab;
	}

	public ControllerJeu getCj() {
		return cj;
	}

	public void setCj(ControllerJeu cj) {
		this.cj = cj;
	}

	public VueJeu() {

		frame = new JFrame();
		frame.getContentPane().setLayout(new GridLayout(3, 1));

		contentPane = new JPanel();
		contentPane2 = new JPanel();
		// panelInfo = new JPanel();
		informations = new JTextField();
		informations.setText("J'affiche les informations bitches");

		contentPane.setLayout(new GridLayout(Partie.getInstance().getParametres().getHauteurPlateau() + 1,
				Partie.getInstance().getParametres().getHauteurPlateau() + 1));
		contentPane2.setLayout(new GridLayout(Partie.getInstance().getParametres().getHauteurPlateau() + 1,
				Partie.getInstance().getParametres().getHauteurPlateau() + 1));

		frame.setTitle("Jeu");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, (Partie.getInstance().getParametres().getHauteurPlateau() + 1) * 100,
				(Partie.getInstance().getParametres().getHauteurPlateau() + 1) * 100);
		frame.getContentPane().add(contentPane);

		frame.getContentPane().add(informations);
		frame.getContentPane().add(contentPane2);
		Grille = new JButton[Partie.getInstance().getParametres().getHauteurPlateau()
				+ 1][Partie.getInstance().getParametres().getLargeurPlateau() + 1];
		Grille2 = new JTextField[Partie.getInstance().getParametres().getLargeurPlateau()
				+ 1][Partie.getInstance().getParametres().getLargeurPlateau() + 1];

		// Création de la grille de jeu

		for (int i = 0; i < Grille.length; i++) {
			for (int k = 0; k < Grille.length; k++) {
				Grille[i][k] = new JButton();
				Grille[i][k].addMouseListener(cj);

				if (i != 0 && k != 0) {

					Grille[i][k].setText("");

				} else if (i == 0 && k != 0) {
					Grille[i][k].setText(Integer.toString(k));
				}
				contentPane.add(Grille[i][k]);
			}

		}

		for (int j = 0; j < Grille2.length; j++) {
			for (int l = 0; l < Grille2.length; l++) {
				Grille2[j][l] = new JTextField();
				Grille2[j][l].setEditable(false);

				if (j != 0 && l != 0) {
					
					System.out.println(j + " " + l + "" + Grille2.length);
					
					if (!(j == Grille2.length) && !(l == Grille2.length)) {
						if (Partie.getInstance().getJoueur().getCarte()[j-1][l-1] instanceof CaseBateau) {
							
							Grille2[j][l].setBackground(Color.GRAY);
						}
					}
					Grille2[j][l].setText("");

				} else if (j == 0 && l != 0) {
					Grille2[j][l].setText(Integer.toString(l));
				}
				contentPane2.add(Grille2[j][l]);
			}

		}

		for (int a = 1; a < Grille.length; a++) {

			Grille[a][0].setText(tab.getAlphabet()[a]);
			Grille2[a][0].setText(tab.getAlphabet()[a]);
		}

	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Plateau) {
			for (int i = 0; i < Grille2.length; i++) {
				for (int j = 0; j < Grille2.length; i++) {
					if (((Plateau) arg).getCarte()[i][j] instanceof CaseBateau) {
						Grille2[i][j].setBackground(Color.RED);

					}
				}
			}
		}

	}
}
