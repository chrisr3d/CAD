package Vue;

import javax.swing.JPanel;

import Controlleur.ControllerMenu;

public class Menu extends JPanel implements Observer {
	
	private ControllerMenu cm;
	private FenetreJeu fenetre;
	
	public Menu(FenetreJeu fenetre){
		this.fenetre = fenetre;
		construireMenu();
	}
	
	private void construireMenu(){
		
	}

}
