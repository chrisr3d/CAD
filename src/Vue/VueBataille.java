package Vue;

import java.util.Observable;

import javax.swing.JPanel;

import Controlleur.ControllerJeu;
import Modele.Partie;

public class VueBataille extends JPanel implements Observer {
	private Partie partie;
	
	private ControllerJeu cj;
	
	public VueBataille(final FenetreJeu fenetre, Partie partie){
		
	}
	
	public void update(Observable o, Object arg){
		
	}
	
	private void updateVue(){
		
	}
	
	private class VueGrille extends JPanel{
		
	}
}
