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
import Vue.Options;
import Vue.VueJeu;

public class ControllerOptions implements ActionListener{
	
	private Parametre p;
	private Options o;
	private Partie pa;
	//private FenetreJeu f;
	
	public ControllerOptions(Options o){
		
		this.o=o;
		
	
	}
	

	public void actionPerformed(ActionEvent e) {
		
			
			Double d = (Double)o.getSpinner().getValue();
	 		Integer i = d.intValue();
	 		System.out.println(o.getSpinner().getValue());
	 		Parametre p = new Parametre((int)i,(int) i, true, (Modes)o.getModes().getSelectedItem());
	 		o.getFrame().setVisible(false);
			o.getFrame().setEnabled(false);
			
			
			
			//Partie aléatoire
			
			VueJeu vj = new VueJeu(p);
			vj.setVisible(true);
		


	}

}
