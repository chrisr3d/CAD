package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlleur.ControllerFenetre;
import Modele.Partie;

public class Placement extends JFrame implements Observer{
	private JPanel contentPane, bateaux;
	private JButton[][] Grille;
	private JButton but2,but3,but4,but5;
	Alphabet tab = new Alphabet();
	ControllerFenetre cf = new ControllerFenetre(this);
	
	public JButton[][] getGrille(){
		return Grille;
	}
	public void setGrille(JButton[][] grille){
		Grille=grille;
	}
	public JButton getBut2(){
		return but2;
	}
	public void setBut2(JButton b2){
		but2 = b2;
	}
	public JButton getBut3(){
		return but3;
	}
	public void setBut3(JButton b3){
		but3 = b3;
	}
	public JButton getBut4(){
		return but4;
	}
	public void setBut4(JButton b4){
		but4 = b4;
	}
	public JButton getBut5(){
		return but5;
	}
	public void setBut5(JButton b5){
		but5 = b5;
	}
	public ControllerFenetre getCf(){
		return cf;
	}
	public void setCf(ControllerFenetre cf){
		this.cf=cf;
	}
	
	public Placement(){
		getContentPane().setLayout(new GridLayout(2,1));
		
		contentPane = new JPanel();
		bateaux = new JPanel();
		contentPane.setLayout(new GridLayout(Partie.getInstance().getParametres().getHauteurPlateau()+1,
				Partie.getInstance().getParametres().getHauteurPlateau()+1));
		this.setTitle("Placez vos bateaux");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, (Partie.getInstance().getParametres().getHauteurPlateau()+1)*85, 
				(Partie.getInstance().getParametres().getHauteurPlateau()+1)*100);
		getContentPane().add(contentPane);
		getContentPane().add(bateaux);
		Grille = new JButton[Partie.getInstance().getParametres().getHauteurPlateau()
		                     +1][Partie.getInstance().getParametres().getLargeurPlateau()+1];
		for (int i = 0; i < Grille.length; i++) {
			for (int k = 0; k < Grille.length; k++) {
				Grille[i][k] = new JButton();
				Grille[i][k].addMouseListener(cf);
				Grille[i][k].addActionListener(cf);
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
		but2.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,40,110,29);
		but3.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,115,110,29);
		but4.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,190,110,29);
		but5.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*25-55,265,110,29);
		but2.addActionListener(cf);
		but3.addActionListener(cf);
		but4.addActionListener(cf);
		but5.addActionListener(cf);
		bateaux.add(but2);
		bateaux.add(but3);
		bateaux.add(but4);
		bateaux.add(but5);
	}
}
