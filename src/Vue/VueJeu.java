package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import Controlleur.ControllerJeu;
import Controlleur.ControllerMenu;
import Controlleur.ControlleurSauvegarde;
import Modele.CaseBateau;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;
import Modele.Tactique.ContexteTactique;
import Modele.Tactique.ListeTactique;
import Modele.Tactique.TactiqueAleatoire;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;

public class VueJeu implements Observer {

	private JFrame frame;
	// private JPanel panelInfo;
	private JTextField informations;
	private JPanel contentPane;
	private JPanel contentPane2;
	private JButton[][] Grille;
	private JTextField[][] Grille2;
	Alphabet tab = new Alphabet();
	private ControllerJeu cj = new ControllerJeu(this);
	private ControllerMenu cm = new ControllerMenu(this);
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnStrategie;
	private JMenuItem mntmSauvegarderPartie;
	private JMenuItem mntmQuitter;
	private ControlleurSauvegarde cs = new ControlleurSauvegarde();

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
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		mntmSauvegarderPartie = new JMenuItem("Sauvegarder Partie");
		mntmSauvegarderPartie.addActionListener(cs);
		mnFichier.add(mntmSauvegarderPartie);
		
		mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFichier.add(mntmQuitter);
		ButtonGroup bg = new ButtonGroup();
		mnStrategie = new JMenu("Strategie");
		JRadioButtonMenuItem jr = new JRadioButtonMenuItem();
		
		for(ListeTactique ts : ListeTactique.values()){
			jr = new JRadioButtonMenuItem(ts.name());
			jr.setSelected(true);
			bg.add(jr);
			mnStrategie.add(jr);
			
				
		}
		if(ContexteTactique.getTactique() instanceof TactiqueAleatoire){
			mnStrategie.getItem(0).setSelected(true);
		}else{
			mnStrategie.getItem(1).setSelected(false);
		}
		
		mnStrategie.addMenuListener(cm);
		for(int a = 0; a<mnStrategie.getItemCount();a++){
			mnStrategie.getItem(a).addActionListener(cm);
			mnStrategie.getItem(a).setName(mnStrategie.getItem(a).getName());
		}
		
		
		
		menuBar.add(mnStrategie);
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
					System.out.println(Partie.getInstance().getIA().getCarte()[i-1][k-1].isCibler());
					if(Partie.getInstance().getIA().getCarte()[i-1][k-1].isCibler()  ){
						Grille[i][k].setText("TOUCHE");
						Grille[i][k].setEnabled(false);
						
					}

					Grille[i][k].setText("");

				} else if (i == 0 && k != 0) {
					Grille[i][k].setText(Integer.toString(k));
					Grille[i][k].setEnabled(false);
				}
				contentPane.add(Grille[i][k]);
			}

		}

		for (int j = 0; j < Grille2.length; j++) {
			for (int l = 0; l < Grille2.length; l++) {
				Grille2[j][l] = new JTextField();
				
				Grille2[j][l].setEditable(false);

				if (j != 0 && l != 0) {
					
					
					
					if (!(j == Grille2.length) && !(l == Grille2.length)) {
						if (Partie.getInstance().getJoueur().getCarte()[j-1][l-1] instanceof CaseBateau ) {
							
							Grille2[j][l].setBackground(Color.GRAY);
						}
					}
					Grille2[j][l].setText("");

				} else if (j == 0 && l != 0) {
					Grille2[j][l].setText(Integer.toString(l));
					Grille2[j][l].setEnabled(false);
				}else if(j == 0 && l == 0)  {
					Grille2[j][l].setEnabled(false);
					Grille[j][l].setEnabled(false);
					
				}
				contentPane2.add(Grille2[j][l]);
			}

		}

		for (int a = 1; a < Grille.length; a++) {
			Grille2[a][0].setEnabled(false);
			Grille[a][0].setEnabled(false);
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

	public ControllerMenu getCm() {
		return cm;
	}

	public void setCm(ControllerMenu cm) {
		this.cm = cm;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnFichier() {
		return mnFichier;
	}

	public void setMnFichier(JMenu mnFichier) {
		this.mnFichier = mnFichier;
	}

	public JMenu getMnStrategie() {
		return mnStrategie;
	}

	public void setMnStrategie(JMenu mnStrategie) {
		this.mnStrategie = mnStrategie;
	}

	public JMenuItem getMntmSauvegarderPartie() {
		return mntmSauvegarderPartie;
	}

	public void setMntmSauvegarderPartie(JMenuItem mntmSauvegarderPartie) {
		this.mntmSauvegarderPartie = mntmSauvegarderPartie;
	}

	public JMenuItem getMntmQuitter() {
		return mntmQuitter;
	}

	public void setMntmQuitter(JMenuItem mntmQuitter) {
		this.mntmQuitter = mntmQuitter;
	}
	
}
