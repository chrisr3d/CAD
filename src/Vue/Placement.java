package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.Partie;

public class Placement extends JFrame implements Observer{
	private JPanel contentPane, bateaux;
	private JTextField[][] Grille;
	private JButton but2,but3,but4,but5;
	Alphabet tab = new Alphabet();
	
	public Placement(){
		getContentPane().setLayout(new GridLayout(2,1));
		
		contentPane = new JPanel();
		bateaux = new JPanel();
		contentPane.setLayout(new GridLayout(Partie.getInstance().getParametres().getHauteurPlateau()+1,Partie.getInstance().getParametres().getHauteurPlateau()+1));
		this.setTitle("Placez vos bateaux");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, (Partie.getInstance().getParametres().getHauteurPlateau()+1)*50, (Partie.getInstance().getParametres().getHauteurPlateau()+1)*100);
		getContentPane().add(contentPane);
		getContentPane().add(bateaux);
		Grille = new JTextField[Partie.getInstance().getParametres().getHauteurPlateau()+1][Partie.getInstance().getParametres().getLargeurPlateau()+1];
		for (int i = 0; i < Grille.length; i++) {
			for (int k = 0; k < Grille.length; k++) {
				Grille[i][k] = new JTextField();

				Grille[i][k].setEditable(false);
				if (i != 0 && k != 0) {

					Grille[i][k].setText("");

				} else if (i == 0 && k != 0) {
					Grille[i][k].setText(Integer.toString(k));
				}
				contentPane.add(Grille[i][k]);
			}

		}
		for(int a = 1; a<Grille.length;a++){
			Grille[a][0].setText(tab.getAlphabet()[a]);
		}
		bateaux.setLayout(null);
		but2 = new JButton("2");
		but3 = new JButton("3");
		but4 = new JButton("4");
		but5 = new JButton("5");
		but2.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,50,110,29);
		but3.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,125,110,29);
		but4.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,200,110,29);
		but5.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,275,110,29);
		bateaux.add(but2, BorderLayout.CENTER);
		bateaux.add(but3,BorderLayout.CENTER);
		bateaux.add(but4,BorderLayout.CENTER);
		bateaux.add(but5,BorderLayout.SOUTH);
	}
}
