package Vue;

import javax.swing.*;

import Controlleur.ControllerOptions;
import Modele.Parametre;
import Modele.Partie;
import Modele.Epoque.FabriqueEpoque;



public class Options extends JPanel implements Observer{
	private FenetreJeu fenetre;
	private Partie partie;
	
	private JRadioButton placementAlea, placementManu;
	private JSpinner largeurGrille, hauteurGrille;
	private JButton valider;
	private JComboBox<String> epoque, strategie;
	
	private ControllerOptions co;
	
	public Options(FenetreJeu fenetre) {
		this.fenetre=fenetre;
		construireOptions();
		MaJOptions(new Parametre());
	}
	
	public Options(FenetreJeu fenetre, Partie partie){
		this.fenetre=fenetre;
		this.partie=partie;
		construireOptions();
		MaJOptions(partie.getParametres());
	}
	
	private void construireOptions(){
		
	}
	
	public void MaJOptions(Parametre parametre){
		if(parametre.getPlacement().equalsIgnoreCase("random"))
			placementAlea.setSelected(true);
		else
			placementManu.setSelected(true);
		epoque.setSelectedItem(FabriqueEpoque.getEpoque(parametre.getEpoque()).getNom());
		strategie.setSelectedItem(TactiqueIAStrategie.getStrategie(parametre.getTactique()).getNom());
		largeurGrille.setValue(parametre.getLargeurGrille());
		hauteurGrille.setValue(parametre.getHauteurGrille());
	}
}
