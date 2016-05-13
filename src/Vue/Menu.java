package Vue;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlleur.ControllerFenetre;

public class Menu extends JPanel {
	
	private ControllerFenetre cm;
	private FenetreJeu fenetre;
	
	public Menu(FenetreJeu fenetre){
		this.fenetre = fenetre;
		construireMenu();
	}
	
	private void construireMenu(){
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = constraints.gridy = 0;
		constraints.insets = new Insets(25, 25, 25, 25);
		constraints.fill = GridBagConstraints.BOTH;

		JLabel jl1 = new JLabel("Menu principal");
		jl1.setHorizontalAlignment(JLabel.CENTER);
		add(jl1, constraints);

		JLabel jl2 = new JLabel("Bataille navale");
		jl2.setHorizontalAlignment(JLabel.CENTER);
		constraints.gridy++;
		add(jl2, constraints);

		JButton nvo = new JButton("Nouvelle partie");
		nvo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.creerNouvellePartie();
			}
		});
		constraints.gridy++;
		add(nvo, constraints);

		JButton charger = new JButton("Charger une partie");
		charger.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                            fenetre.chargerPartie();
                        }
		});
		constraints.gridy++;
		add(charger, constraints);

		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.quitter();
			}
		});
		constraints.gridy++;
		add(quitter, constraints);
	}

}
