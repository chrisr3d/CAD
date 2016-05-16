package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlleur.ControllerOptions;
import Modele.Parametre;
import Modele.Partie;
import Modele.Epoque.FabriqueEpoque;



public class Options extends JPanel implements Observer{
	private FenetreJeu fenetre;
	private Partie partie;
	private JFrame frame = new JFrame("Options");
	private JRadioButton placementAlea, placementManu;
	private JSpinner largeurGrille, hauteurGrille;
	private JButton valider;
	private JComboBox<String> epoque, strategie;
	private Parametre p;
	private ControllerOptions co;
	
	public Options(FenetreJeu fenetre, ControllerOptions co) {
		this.fenetre=fenetre;
		this.co=co;
		construireOptions();
		MaJOptions(new Parametre());
	}
	
	public Options(FenetreJeu fenetre, Partie partie, ControllerOptions co){
		this.fenetre=fenetre;
		this.partie=partie;
		this.co=co;
		construireOptions();
		MaJOptions(partie.getParametres());
	}
	
	private void construireOptions(){
		boolean protect = (partie == null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = (JPanel) frame.getContentPane();
        
        JLabel tailleLabel = new JLabel("Taille de la Grille", SwingConstants.CENTER);
        contentPane.add(tailleLabel);
        largeurGrille = new JSpinner(new SpinnerNumberModel(10,6,20,1));
        largeurGrille.setEnabled(protect);
        contentPane.add(largeurGrille);
        JLabel x = new JLabel("X", SwingConstants.CENTER);
        contentPane.add(x);
        hauteurGrille = new JSpinner(new SpinnerNumberModel(10,6,20,1));
        hauteurGrille.setEnabled(protect);
        contentPane.add(hauteurGrille);
        
        JLabel stratLabel = new JLabel("Stratégie de l'ordinateur",SwingConstants.CENTER);
        contentPane.add(stratLabel);
		strategie = new JComboBox<>();
		//Il faut importer les stratégies pour les ajouter dans la ComboBox
		contentPane.add(strategie);
		
		JLabel epoqueLabel = new JLabel("Époque", SwingConstants.CENTER);
		contentPane.add(epoqueLabel);
		epoque = new JComboBox<>();
		//Pareil que pour les stratégies
		epoque.setEnabled(protect);
		contentPane.add(epoque);
		
		JLabel placementLabel = new JLabel("Placement des bateaux", SwingConstants.CENTER);
		contentPane.add(placementLabel);
		placementAlea = new JRadioButton("Aléatoire");
		placementAlea.setEnabled(protect);
		contentPane.add(placementAlea);
		placementManu = new JRadioButton("Manuel");
		placementManu.setEnabled(protect);
		contentPane.add(placementManu);
		
		valider = new JButton("Valider");
		contentPane.add(valider);
		valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				co.pressBoutonValider(largeurGrille, hauteurGrille, strategie,epoque,placementAlea,placementManu);
			}
		});
	}
	
	public void MaJOptions(Parametre parametre){
		if(parametre.getPlacement().equalsIgnoreCase("random"))
			placementAlea.setSelected(true);
		else
			placementManu.setSelected(true);
		/*epoque.setSelectedItem(FabriqueEpoque.getEpoque(parametre.getEpoque()).getNom());
		strategie.setSelectedItem(TactiqueIAStrategie.getStrategie(parametre.getTactique()).getNom());
		largeurGrille.setValue(parametre.getLargeurGrille());
		hauteurGrille.setValue(parametre.getHauteurGrille());*/
	}
	
	
}
