package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import Modele.CaseBateau;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

public class VueJeu extends JFrame implements Observer{
	
	//private JPanel panelInfo;
	private JTextField informations;
	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField[][] Grille;
	private JTextField[][] Grille2;
	Alphabet tab = new Alphabet();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VueJeu() {
		
		getContentPane().setLayout(new GridLayout(3,1));
		
		contentPane = new JPanel();
		contentPane2 = new JPanel();
		//panelInfo = new JPanel();
		informations = new JTextField();
		informations.setText("J'affiche les informations bitches");
		
		contentPane.setLayout(new GridLayout(Partie.getInstance().getParametres().getHauteurPlateau()+1,Partie.getInstance().getParametres().getHauteurPlateau()+1));
		contentPane2.setLayout(new GridLayout(Partie.getInstance().getParametres().getHauteurPlateau()+1,Partie.getInstance().getParametres().getHauteurPlateau()+1));
		//panelInfo.add(informations);
		
		this.setTitle("Jeu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, (Partie.getInstance().getParametres().getHauteurPlateau()+1)*50, (Partie.getInstance().getParametres().getHauteurPlateau()+1)*100);
		getContentPane().add(contentPane);
		//informations.setBounds(informations.getX(), informations.getY(), 100, 100);
		//informations.setMaximumSize(new Dimension(1100, 100));
		
		getContentPane().add(informations);
		getContentPane().add(contentPane2);
		Grille = new JTextField[Partie.getInstance().getParametres().getHauteurPlateau()+1][Partie.getInstance().getParametres().getLargeurPlateau()+1];
		Grille2 = new JTextField[Partie.getInstance().getParametres().getLargeurPlateau()+1][Partie.getInstance().getParametres().getLargeurPlateau()+1];
		
		//Création de la grille de jeu
		

		

		
		for(int i = 0; i<Grille.length; i++){
			for(int k = 0; k<Grille.length; k++){
				Grille[i][k] = new JTextField();
				
				Grille[i][k].setEditable(false);
				if(i != 0 && k!= 0){
		
		
		Grille[i][k].setText("");
		
		
		
		
	
		}else if ( i == 0 && k!= 0){
			Grille[i][k].setText(Integer.toString(k));
		}
				contentPane.add(Grille[i][k]);
		}
			
		}
		for(int j = 0; j<Grille2.length; j++){
			for(int l = 0; l<Grille2.length; l++){
				Grille2[j][l] = new JTextField();
				Grille2[j][l].setEditable(false);
				if(j != 0 && l!= 0){
		
		
		Grille2[j][l].setText("");
		
		
		
		
	
		}else if ( j == 0 && l!= 0){
			Grille2[j][l].setText(Integer.toString(l));
		}
				contentPane2.add(Grille2[j][l]);
		}
			
		}
		
	
		for(int a = 1; a<Grille.length;a++){
			
			Grille[a][0].setText(tab.getAlphabet()[a]);
			Grille2[a][0].setText(tab.getAlphabet()[a]);
		}
		
		
	}


	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		/*if(arg instanceof Plateau){
		for(int i = 0; i < Grille.length; i++){
			for(int j = 0; j< Grille.length;i++){
				if(((Plateau) arg).getCarte()[i][j] instanceof CaseBateau){
					Grille[i][j].setBackground(Color.RED);
					
				}
			}
		}
		}*/
		
	}
}
