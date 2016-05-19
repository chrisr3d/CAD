package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import Modele.Modes;
import Modele.Parametre;
import Modele.Partie;
import Modele.Plateau;
import Modele.Bateau.FabriqueBateau;
import Modele.Epoque.FabriqueEpoque;
import Modele.Epoque.listeEpoque;
import Vue.Options;
import Vue.VueJeu;

public class ControllerOptions implements ActionListener{
	
	private Parametre p;
	private Options o;
	private Partie pa;
	//private FenetreJeu f;
	
	public ControllerOptions(Options o){
		
		this.o=o;
		
	
	}
	

	@SuppressWarnings("incomplete-switch")
	public void actionPerformed(ActionEvent e) {
		
			
			Double d = (Double)o.getSpinner().getValue();
	 		Integer i = d.intValue();
	 		
	 		
	 		Double d2 = (Double)o.getNbBateau().getValue();
	 		Integer nbBoat = d2.intValue();
	 		
	 		Double d3 = (Double)o.getTailleBateau().getValue();
	 		Integer tailleB = d3.intValue();
	 		
	 		
	 		
	 		Parametre p = new Parametre((int)i,(int) i, true, (Modes)o.getModes().getSelectedItem());
	 		o.getFrame().setVisible(false);
			o.getFrame().setEnabled(false);
			Plateau jeu;
			
			jeu = new Plateau((int)i,(int)i);
			
			if(o.getRdbtnAutomatique().isSelected()){
				
				
				
				
				if(o.getModes().getSelectedItem() == Modes.Normal){
				for(int j = 0; j<nbBoat;j++){
					jeu.placerAleatoireBateau(FabriqueBateau.getBateau(tailleB));
					//PlacerBateau	
					
				}
				
				
				}else{
					
					
				for(int k = 0; k<nbBoat;k++){
					int t = (int) (2 + (Math.random() * (5 - 2)));
					jeu.placerAleatoireBateau(FabriqueBateau.getBateau(t));
					//PlacerBateau
					
				}
				
					
				}
				
			}else {
				
				
				
				
				
			}
			
			switch((listeEpoque)o.getComboBox().getSelectedItem()){
			case Actuelle :
				FabriqueEpoque.setEpoqueActuelle();
				FabriqueEpoque.choisirEpoqueFutur(jeu.getBateau());
				break;
			case Futur :
				FabriqueEpoque.setEpoqueFutur();
				FabriqueEpoque.choisirEpoqueActuelle(jeu.getBateau());
				break;
			}
			
			
			
			//Partie aléatoire
			
			VueJeu vj = new VueJeu(p);
			vj.setVisible(true);
		


	}

}
