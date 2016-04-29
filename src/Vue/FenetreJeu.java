package Vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controlleur.ControllerMenu;
import DAO.AbstractDAOFactory;
import DAO.DAO;
import Modele.Parametre;




public class FenetreJeu implements Observer {
	private JFrame window;
	private Menu menu = new Menu(this);
	private VueBataille bataille;
	
	public FenetreJeu(){
		window = new JFrame("Bataille Navale");
		window.setContentPane(menu);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		ControllerMenu controller = new ControllerMenu();
		
		JMenuBar menuBar = new JMenuBar();
		JMenu jmenu = new JMenu("Jeu");
		jmenu.add(new JMenuItem("Nouvelle Partie")).addActionListener(controller);
		jmenu.add(new JMenuItem("Charger Partie")).addActionListener(controller);
		jmenu.add(new JMenuItem("Menu Principal")).addActionListener(controller);
		jmenu.add(new JMenuItem("Quitter")).addActionListener(controller);
		
		menuBar.add(jmenu);
		window.setJMenuBar(menuBar);
	}
	
	public void ouvrirMenu(){
		window.setContentPane(menu);
		window.pack();
	}
	
	public void creerNouvellePartie(){
		window.setContentPane(new Options(this));
		window.pack();
	}
	
	public void chargerPartie(){
		
	}
	
	public void nouvellePartie(Parametre parametre){
		
	}
	
	public void changerOptions(){
		if(bataille == null)
			return;
		window.setContentPane(new Options(this)); // deuxième paramètre : état de la partie (voir dans Partie)
		window.pack();
	}
	
	public void afficherBataille(){
		if (bataille == null)
			nouvellePartie(new Parametre());
		window.setContentPane(bataille);
		window.pack();
	}
	
	public void quitter(){
		window.setVisible(false);
		System.exit(0);
	}
}
