package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Partie;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Menu");
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNouvellePartie = new JButton("Nouvelle Partie");
		btnNouvellePartie.setBounds(141, 6, 183, 62);
		btnNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				
				Options j = new Options();
				j.getFrame().setVisible(true);
				
			}
		});
		panel.setLayout(null);
		panel.add(btnNouvellePartie);
		
		JButton btnChargerPartie = new JButton("Charger Partie");
		btnChargerPartie.setBounds(141, 100, 183, 62);
		btnChargerPartie.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Partie.getInstance().changerParametre();
				frame.setVisible(false);
				frame.setEnabled(false);
				VueJeu j = new VueJeu();
				j.getFrame().setVisible(true);
			}
		});
		panel.add(btnChargerPartie);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(141, 193, 183, 62);
		panel.add(btnQuitter);
	}
}
