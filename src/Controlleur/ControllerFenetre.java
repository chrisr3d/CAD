package Controlleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import Modele.CaseBateau;
import Modele.Modes;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;
import Modele.Bateau.Bateau;
import Modele.Bateau.FabriqueBateau;
import Vue.Options;
import Vue.Placement;
import Vue.VueJeu;

public class ControllerFenetre implements ActionListener, MouseListener, MouseMotionListener{

	Placement place;
	Parametre param;
	Options o;
	Plateau jeu;
	Plateau adversaire;
	private int nb,placeI,placeJ;
	//private boolean pressed = false; //
	Bateau b;

	private boolean selected=false; //true lorsqu'une taille de bateau est selectionnee
	private boolean placed=false; //true lorsque la premiere case du bateau est placee
	
	Integer nbBoat;
	Integer tailleB;
	
	
	public ControllerFenetre(Placement pl, Options o){
		this.place=pl;
		this.o=o;
		Double d = (Double) o.getSpinner().getValue();
		Integer i = d.intValue();
		Double d2 = (Double) o.getNbBateau().getValue();
		nbBoat = d2.intValue();

		Double d3 = (Double) o.getTailleBateau().getValue();
		tailleB = d3.intValue();
		
		param = new Parametre((int) i, (int) i, true, (Modes) o.getModes().getSelectedItem());
		o.getFrame().setVisible(false);
		o.getFrame().setEnabled(false);
		jeu = new Plateau((int) i, (int) i);
		adversaire = new Plateau((int) i, (int) i);
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
			boolean enoughPlace = false;
			boolean gray=false;
			
			//en haut de la premiere case du bateau
			for(int k=i-1;k>(i-nb);k--){
				if(k>0){
					if(place.getGrille()[k][j].getBackground()==Color.GRAY){
						gray=true;
						break;
					}
				}
				else{
					break;
				}
			}
			if ((i-nb+1)>0 && !gray){
				place.getGrille()[i-1][j].setBackground(Color.WHITE);
				enoughPlace = true;
			}
			gray=false;

			//en bas de la premiere case du bateau
			for(int k=i+1;k<(i+nb);k++){
				if(k<(place.getGrille().length)){
					if(place.getGrille()[k][j].getBackground()==Color.GRAY){
						gray=true;
						break;
					}
				}
				else{
					break;
				}
			}
			if ((i+nb-1)<(place.getGrille().length) && !gray){
				place.getGrille()[i+1][j].setBackground(Color.WHITE);
				enoughPlace=true;
			}
			gray=false;

			//a gauche de la premiere case du bateau
			for(int k=j-1;k>(j-nb);k--){
				if(k>0){
					if(place.getGrille()[i][k].getBackground()==Color.GRAY){
						gray=true;
						break;
					}
				}
				else{
					break;
				}
			}
			if ((j-nb+1)>0 && !gray){
				place.getGrille()[i][j-1].setBackground(Color.WHITE);
				enoughPlace=true;
			}
			gray=false;
			
			//a droite de la premiere case du bateau
			for(int k=j+1;k<(j+nb);k++){
				if(k<(place.getGrille().length)){
					if(place.getGrille()[i][k].getBackground()==Color.GRAY){
						gray=true;
						break;
					}
				}
				else{
					break;
				}
			}
			if ((j+nb-1)<(place.getGrille().length) && !gray){
				place.getGrille()[i][j+1].setBackground(Color.WHITE);
				enoughPlace=true;
			}
			
			//s'il y a de la place pour le bateau, on place la premiere case
			if(enoughPlace){
				placed=true;
				place.getGrille()[i][j].setBackground(Color.GRAY);
				place.getGrille()[i][j].setText(String.valueOf(nb));
				
			}
		}
		else{
			if(place.getGrille()[i][j].getBackground()==Color.WHITE){
				if(i<placeI){
					for(int k=i;k>(i-nb+1);k--){
						place.getGrille()[k][j].setBackground(Color.GRAY);
						place.getGrille()[k][j].setText(String.valueOf(nb));
					}
					b = FabriqueBateau.getBateau(nb);
					ArrayList<CaseBateau> caseb = new ArrayList<CaseBateau>();
					for(int k=placeI;k>(i-nb+1);k--){
						caseb.add(new CaseBateau(k-1,j-1));
					}
					b.setEmplacement(caseb);
					jeu.getBateau().add(b);
					for (int k=0;k<nb;k++) {
						jeu.getCarte()[i-k-1][j-1] = caseb.get(k);
					}
					adversaire.placerAleatoireBateau(FabriqueBateau.getBateau(nb));
					if((placeI+1)<(place.getGrille().length)){
						if(place.getGrille()[placeI+1][j].getBackground()!=Color.GRAY)
							place.getGrille()[placeI+1][j].setBackground(null);
					}
					if((j-1)>0){
						if(place.getGrille()[placeI][j-1].getBackground()!=Color.GRAY)
							place.getGrille()[placeI][j-1].setBackground(null);
					}
					if((j+1)<(place.getGrille().length)){
						if(place.getGrille()[placeI][j+1].getBackground()!=Color.GRAY)
							place.getGrille()[placeI][j+1].setBackground(null);
					}
						
				}
				if(j<placeJ){
					for(int k=j;k>(j-nb+1);k--){
						place.getGrille()[i][k].setBackground(Color.GRAY);
						place.getGrille()[i][k].setText(String.valueOf(nb));
					}
					b = FabriqueBateau.getBateau(nb);
					ArrayList<CaseBateau> caseb = new ArrayList<CaseBateau>();
					for(int k=placeJ;k>(j-nb+1);k--){
						caseb.add(new CaseBateau(i-1,k-1));
					}
					b.setEmplacement(caseb);
					jeu.getBateau().add(b);
					for (int k=0;k<nb;k++) {
						jeu.getCarte()[i-1][j-k-1] = caseb.get(k);
					}
					adversaire.placerAleatoireBateau(FabriqueBateau.getBateau(nb));
					
					if((placeJ+1)<(place.getGrille().length)){
						if(place.getGrille()[i][placeJ+1].getBackground()!=Color.GRAY)
							place.getGrille()[i][placeJ+1].setBackground(null);
					}
					if((i-1)>0){
						if(place.getGrille()[i-1][placeJ].getBackground()!=Color.GRAY)
							place.getGrille()[i-1][placeJ].setBackground(null);
					}
					if((i+1)<(place.getGrille().length)){
						if(place.getGrille()[i+1][placeJ].getBackground()!=Color.GRAY)
							place.getGrille()[i+1][placeJ].setBackground(null);
					}
				}
				if(i>placeI){
					for(int k=i;k<(i+nb-1);k++){
						place.getGrille()[k][j].setBackground(Color.GRAY);
						place.getGrille()[k][j].setText(String.valueOf(nb));
					}
					b = FabriqueBateau.getBateau(nb);
					ArrayList<CaseBateau> caseb = new ArrayList<CaseBateau>();
					for(int k=placeI;k<(i+nb-1);k++){
						caseb.add(new CaseBateau(k-1,j-1));
					}
					b.setEmplacement(caseb);
					jeu.getBateau().add(b);
					for (int k=0;k<nb;k++) {
						jeu.getCarte()[i+k-1][j-1] = caseb.get(k);
					}
					adversaire.placerAleatoireBateau(FabriqueBateau.getBateau(nb));

					if((placeI-1)>0){
						if(place.getGrille()[placeI-1][j].getBackground()!=Color.GRAY)
							place.getGrille()[placeI-1][j].setBackground(null);
					}
					if((j-1)>0){
						if(place.getGrille()[placeI][j-1].getBackground()!=Color.GRAY)
							place.getGrille()[placeI][j-1].setBackground(null);
					}
					if((j+1)<(place.getGrille().length)){
						if(place.getGrille()[placeI][j+1].getBackground()!=Color.GRAY)
							place.getGrille()[placeI][j+1].setBackground(null);
					}
				}
				if(j>placeJ){
					for(int k=j;k<(j+nb-1);k++){
						place.getGrille()[i][k].setBackground(Color.GRAY);
						place.getGrille()[i][k].setText(String.valueOf(nb));
					}
					b = FabriqueBateau.getBateau(nb);
					ArrayList<CaseBateau> caseb = new ArrayList<CaseBateau>();
					for(int k=placeJ;k<(j+nb-1);k++){
						caseb.add(new CaseBateau(i-1,k-1));
					}
					b.setEmplacement(caseb);
					jeu.getBateau().add(b);
					for (int k=0;k<nb;k++) {
						jeu.getCarte()[i-1][j+k-1] = caseb.get(k);
					}
					adversaire.placerAleatoireBateau(FabriqueBateau.getBateau(nb));
					if((placeJ-1)>0){
						if(place.getGrille()[i][placeJ-1].getBackground()!=Color.GRAY)
							place.getGrille()[i][placeJ-1].setBackground(null);
					}
					if((i-1)>0){
						if(place.getGrille()[i-1][placeJ].getBackground()!=Color.GRAY)
							place.getGrille()[i-1][placeJ].setBackground(null);
					}
					if((i+1)<(place.getGrille().length)){
						if(place.getGrille()[i+1][placeJ].getBackground()!=Color.GRAY)
							place.getGrille()[i+1][placeJ].setBackground(null);
					}
				}
				
				placed=false;
				int nb = Integer.parseInt(place.getNbBateaux().getText())-1;
				String nbat = Integer.toString(nb);
				place.getNbBateaux().setText(nbat);
				if(Integer.parseInt(place.getNbBateaux().getText())>0){
					if(place.getMode().getText()=="Mosaique"){
						place.getBut3().setEnabled(true);
						place.getBut2().setEnabled(true);
						place.getBut4().setEnabled(true);
						place.getBut5().setEnabled(true);
					}
					else{
						int taille = tailleB;
						switch(taille){
						case 2:
							place.getBut2().setEnabled(true);
							break;
						case 3:
							place.getBut3().setEnabled(true);
							break;
						case 4:
							place.getBut4().setEnabled(true);
							break;
						case 5:
							place.getBut5().setEnabled(true);
							break;
						}
					}
				}
				else{
					place.getBut3().setEnabled(false);
					place.getBut2().setEnabled(false);
					place.getBut4().setEnabled(false);
					place.getBut5().setEnabled(false);
					place.getValider().setVisible(true);
				}
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
			if(place.getMode().getText()=="Mosaique"){
				place.getBut3().setEnabled(true);
				place.getBut4().setEnabled(true);
				place.getBut5().setEnabled(true);
			}
			
			nb=2;
			selected=true;
		}
	}

	public void pressBateau3() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut3().setEnabled(false);
			if(place.getMode().getText()=="Mosaique"){
				place.getBut2().setEnabled(true);
				place.getBut4().setEnabled(true);
				place.getBut5().setEnabled(true);
			}
			nb=3;
			selected=true;
		}
	}

	public void pressBateau4() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut4().setEnabled(false);
			if(place.getMode().getText()=="Mosaique"){
				place.getBut3().setEnabled(true);
				place.getBut2().setEnabled(true);
				place.getBut5().setEnabled(true);
			}
			nb=4;
			selected=true;
		}
	}

	public void pressBateau5() {
		// TODO Auto-generated method stub
		if(!placed){
			place.getBut5().setEnabled(false);
			if(place.getMode().getText()=="Mosaique"){
				place.getBut3().setEnabled(true);
				place.getBut4().setEnabled(true);
				place.getBut2().setEnabled(true);
			}
			nb=5;
			selected=true;
		}
	}

	public void pressValider() {
		// TODO Auto-generated method stub
		Partie.getInstance().setJoueur(jeu);
		Partie.getInstance().setIA(adversaire);
		Partie.getInstance().setNbBateauRestantIA(nbBoat);
		Partie.getInstance().setNbBateauRestantJoueur(nbBoat);
		jeu.remplirCaseVide();
		adversaire.remplirCaseVide();
		VueJeu vj = new VueJeu();
		vj.getFrame().setVisible(true);
	}
}
