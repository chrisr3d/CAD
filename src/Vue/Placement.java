package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlleur.ControllerFenetre;
import Modele.Parametre;
import Modele.Partie;

public class Placement extends JFrame implements Observer{
	Options opt;
	private JPanel contentPane, bateaux;
	private JButton[][] Grille;
	private JButton but2,but3,but4,but5;
	private JLabel info,nbBateauxTxt,nbBateaux,mode,tailleBateaux;
	private JButton valider;
	Alphabet tab = new Alphabet();
	ControllerFenetre cf = new ControllerFenetre(this,opt);
	
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
	public JLabel getNbBateaux(){
		return nbBateaux;
	}
	public void setNbBateaux(JLabel nb){
		nbBateaux=nb;
	}
	public JLabel getMode(){
		return mode;
	}
	public void setMode(JLabel m){
		mode=m;
	}
	public JLabel getTailleB(){
		return tailleBateaux;
	}
	public void setTailleB(JLabel tb){
		tailleBateaux=tb;
	}
	
	public Placement(Options opt){
		this.opt=opt;
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
		valider = new JButton("Valider");
		nbBateauxTxt = new JLabel("Nombre de bateaux restants :");
		nbBateaux = new JLabel();
		info = new JLabel("Créer Bateau de taille :");
		Double d2 = (Double) opt.getNbBateau().getValue();
		Integer nbBoat = d2.intValue();
		nbBateaux.setText(nbBoat.toString());
		String modeB = opt.getModes().getSelectedItem().toString();
		mode = new JLabel("Mode : "+modeB);
		but2.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*27,40,110,29);
		but3.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*27,115,110,29);
		but4.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*27,190,110,29);
		but5.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*27,265,110,29);
		nbBateauxTxt.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*45,100, 250,50);
		Double tg = (Double) opt.getSpinner().getValue();
		Integer tailleG = tg.intValue(); 
		switch(tailleG){
		case 6:
			nbBateaux.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*77,100,50,50);
			break;
		case 7:
			nbBateaux.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*73,100,50,50);
			break;
		case 8:
			nbBateaux.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*70,100,50,50);
			break;
		case 9:
			nbBateaux.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*68,100,50,50);
			break;
		case 10:
			nbBateaux.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*65,100,50,50);
			break;
		}
		mode.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*45,150,250,50);
		info.setBounds(10,140,250,50);
		valider.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*50,250,200,50);
		but2.addActionListener(cf);
		but3.addActionListener(cf);
		but4.addActionListener(cf);
		but5.addActionListener(cf);
		valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//cf.pressValider();
			}
		});
		valider.setVisible(false);
		bateaux.add(valider);
		bateaux.add(info);
		bateaux.add(nbBateauxTxt);
		bateaux.add(nbBateaux);
		bateaux.add(mode);
		bateaux.add(but2);
		bateaux.add(but3);
		bateaux.add(but4);
		bateaux.add(but5);
		if(modeB == "Normal"){
			Double d3 = (Double) opt.getTailleBateau().getValue();
			Integer tailleB = d3.intValue();
			tailleBateaux = new JLabel("Taille des bateaux : "+tailleB.toString());
			tailleBateaux.setBounds((Partie.getInstance().getParametres().getHauteurPlateau()+1)*45,200,250,50);
			bateaux.add(tailleBateaux);
			switch (tailleB){
			case 2:
				but3.setEnabled(false);
				but4.setEnabled(false);
				but5.setEnabled(false);
				break;
			case 3:
				but2.setEnabled(false);
				but4.setEnabled(false);
				but5.setEnabled(false);
				break;
			case 4:
				but3.setEnabled(false);
				but2.setEnabled(false);
				but5.setEnabled(false);
				break;
			case 5:
				but3.setEnabled(false);
				but4.setEnabled(false);
				but2.setEnabled(false);
				break;
			}
		}
	}
}
