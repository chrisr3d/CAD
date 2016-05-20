package Controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;

import Vue.Placement;

public class ControllerFenetre implements ActionListener, MouseListener, MouseMotionListener{

	Placement place;
	private int nb,placeI,placeJ;
	//private boolean pressed = false; //
	private boolean selected=false; //true lorsqu'une taille de bateau est sélectionnée
	private boolean placed=false; //true lorsque la première case du bateau est placée
	
	public ControllerFenetre(Placement pl){
		this.place=pl;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for (int i = 1; i < place.getGrille().length; i++) {
			for (int j = 1; j < place.getGrille().length; j++) {

				if (arg0.getSource() == place.getGrille()[i][j]) {
					if (!placed && !selected && place.getGrille()[i][j].getBackground()!=Color.GRAY) {
						place.getGrille()[i][j].setBackground(Color.WHITE);
					}
				}
			}
		}
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for (int i = 1; i < place.getGrille().length; i++) {
			for (int j = 1; j < place.getGrille().length; j++) {

				if (arg0.getSource() == place.getGrille()[i][j]) {
					if (!placed && ! selected && place.getGrille()[i][j].getBackground()!=Color.GRAY) {
						place.getGrille()[i][j].setBackground(null);
					}
				}
			}
		}
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == place.getBut2())
			pressBateau2();
		if(e.getSource() == place.getBut3())
			pressBateau3();
		if(e.getSource() == place.getBut4())
			pressBateau4();
		if(e.getSource() == place.getBut5())
			pressBateau5();
		for(int i=1; i<place.getGrille().length; i++){
			for(int j=1; j<place.getGrille().length; j++){
				if(e.getSource() == place.getGrille()[i][j]){
					if(selected){
						if(!placed){
							placeI=i;
							placeJ=j;
						}
						pressCase(i,j);
					}
				}	
			}
		}
	}

	private void pressCase(int i, int j) {
		// TODO Auto-generated method stub
		if (!placed){
			place.getGrille()[i][j].setBackground(Color.GRAY);
			if ((i-nb+1)>0)
				place.getGrille()[i-1][j].setBackground(Color.WHITE);
			if ((i+nb-1)<(place.getGrille().length))
				place.getGrille()[i+1][j].setBackground(Color.WHITE);
			if ((j-nb+1)>0)
				place.getGrille()[i][j-1].setBackground(Color.WHITE);
			if ((j+nb-1)<(place.getGrille().length))
				place.getGrille()[i][j+1].setBackground(Color.WHITE);
			placed=true;
		}
		else{
			if(place.getGrille()[i][j].getBackground()==Color.WHITE){
				if(i<placeI){
					for(int k=i;k>(i-nb+1);k--)
						place.getGrille()[k][j].setBackground(Color.GRAY);
					place.getGrille()[placeI+1][j].setBackground(null);
					place.getGrille()[placeI][j-1].setBackground(null);
					place.getGrille()[placeI][j+1].setBackground(null);
				}
				if(j<placeJ){
					for(int k=j;k>(j-nb+1);k--)
						place.getGrille()[i][k].setBackground(Color.GRAY);
					place.getGrille()[i][placeJ+1].setBackground(null);
					place.getGrille()[i-1][placeJ].setBackground(null);
					place.getGrille()[i+1][placeJ].setBackground(null);
				}
				if(i>placeI){
					for(int k=i;k<(i+nb-1);k++)
						place.getGrille()[k][j].setBackground(Color.GRAY);
					place.getGrille()[placeI-1][j].setBackground(null);
					place.getGrille()[placeI][j-1].setBackground(null);
					place.getGrille()[placeI][j+1].setBackground(null);
				}
				if(j>placeJ){
					for(int k=i;k<(i+nb-1);k++)
						place.getGrille()[i][k].setBackground(Color.GRAY);
					place.getGrille()[i][placeJ-1].setBackground(null);
					place.getGrille()[i-1][placeJ].setBackground(null);
					place.getGrille()[i+1][placeJ].setBackground(null);
				}
				placed=false;
				place.getBut3().setEnabled(true);
				place.getBut2().setEnabled(true);
				place.getBut4().setEnabled(true);
				place.getBut5().setEnabled(true);
				selected=false;
			}
		}
		
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void pressBateau2() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut2().setEnabled(false);
			place.getBut3().setEnabled(true);
			place.getBut4().setEnabled(true);
			place.getBut5().setEnabled(true);
			nb=2;
			selected=true;
		}
	}

	public void pressBateau3() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut3().setEnabled(false);
			place.getBut2().setEnabled(true);
			place.getBut4().setEnabled(true);
			place.getBut5().setEnabled(true);
			nb=3;
			selected=true;
		}
	}

	public void pressBateau4() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut4().setEnabled(false);
			place.getBut3().setEnabled(true);
			place.getBut2().setEnabled(true);
			place.getBut5().setEnabled(true);
			nb=4;
			selected=true;
		}
	}

	public void pressBateau5() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut5().setEnabled(false);
			place.getBut3().setEnabled(true);
			place.getBut4().setEnabled(true);
			place.getBut2().setEnabled(true);
			nb=5;
			selected=true;
		}
	}
}
