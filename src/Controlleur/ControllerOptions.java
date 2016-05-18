package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import Modele.Parametre;
import Modele.Partie;
import Vue.Options;

public class ControllerOptions implements ActionListener{
	
	private Parametre p;
	private Options o;
	private Partie pa;
	//private FenetreJeu f;
	
	/*public ControllerOptions(Parametre p, Options o, Partie pa, FenetreJeu f){
		this.p=p;
		this.o=o;
		this.pa=pa;
	//	this.f=f;
	}*/
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void pressBoutonValider(JSpinner largeurGrille, JSpinner hauteurGrille, JComboBox<String> strategie,
			JComboBox<String> epoque, JRadioButton placementAlea, JRadioButton placementManu) {
		// TODO Auto-generated method stub
		String placement, strat, epo;
		int largeur, hauteur;
		placement = (placementAlea.isSelected()) ? "alea" : "manuel";
		strat=(String)strategie.getSelectedItem();
		epo=(String)epoque.getSelectedItem();
		hauteur=(Integer)hauteurGrille.getValue();
		largeur=(Integer)largeurGrille.getValue();
		//Parametre param = new Parametre(epo, hauteur, largeur, strat, placement);
		try {
		//	param.sauvegardeParametre();
		} catch (Exception e1) {
			System.err.println();
		}
		if (pa != null){
			pa.changerParametre();
		} else {
		//	f.nouvellePartie(p);
		}
		//f.creerNouvellePartie();
	}

}
