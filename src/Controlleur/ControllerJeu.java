package Controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Modele.Partie;
import Vue.VueJeu;

public class ControllerJeu implements ActionListener,MouseListener, MouseMotionListener{

	VueJeu vue;
	public ControllerJeu(VueJeu vj){
		this.vue = vj;
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<vue.getGrille().length;i++){
			for(int j= 1; j<vue.getGrille().length;j++){
				
				if(arg0.getSource() == vue.getGrille()[i][j]){
					if((vue.getGrille()[i][j].getText().equals(""))){
					vue.getGrille()[i][j].setText("x");
					}	
				}
			}
		}
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<vue.getGrille().length;i++){
			for(int j= 1; j<vue.getGrille().length;j++){
				
				if(arg0.getSource() == vue.getGrille()[i][j]){
					if((vue.getGrille()[i][j].getText().equals("x"))){
						
					
					vue.getGrille()[i][j].setText("");
					}
					
				}
			}
		}
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//Tour du joueur 
		for(int i=1; i<vue.getGrille().length;i++){
			for(int j= 1; j<vue.getGrille().length;j++){
				
				if(arg0.getSource() == vue.getGrille()[i][j]){
					boolean touch = Partie.getInstance().tirer(Partie.getInstance().getIA().getCarte()[i-1][j-1]);
					if(touch){
						vue.getGrille()[i][j].setText("TOUCHE");
					}else{
					
					vue.getGrille()[i][j].setText("COULE");
					}
				}
			}
		}
		
		
		//Tour de l'IA
		
		boolean touchIA = Partie.getInstance().JouerIA();
		try {
			vue.getInformations().setText("Tour de l'adversaire");
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vue.getInformations().setText("Votre tour");
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("hi");
	}

}
