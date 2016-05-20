package Controlleur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Modele.Partie;
import Modele.Tactique.ContexteTactique;
import Modele.Tactique.ListeTactique;
import Vue.VueJeu;

public class ControllerMenu implements MenuListener, ActionListener {

	VueJeu vue;

	public ControllerMenu(VueJeu vj) {
		this.vue = vj;

	}

	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == vue.getMnStrategie().getItem(0)){
			ContexteTactique.choisirTactiqueAleatoire();
		}else{
			ContexteTactique.choisirTactiqueCroix();
		}
	
	}

}
