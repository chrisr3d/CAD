package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Partie;

public class ControlleurSauvegarde implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Partie.getInstance().SauvegarderPartie();
	}

}
