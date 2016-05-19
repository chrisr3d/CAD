package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlleur.ControllerOptions;
import Modele.Modes;
import Modele.Parametre;
import Modele.Epoque.listeEpoque;
import Modele.Tactique.ListeTactique;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options {
	private JFrame frame;

	private JPanel contentPane;

	JRadioButton rdbtnManuel;
	JRadioButton rdbtnAutomatique;
	JLabel lblModeDePlacement;
	JLabel modeTexte;
	JSpinner spinner;
	JSpinner tailleBateau;
	JSpinner nbBateau;
	JLabel lblTailleDeLa;
	JButton btnValider;
	JComboBox<listeEpoque> comboBox;
	JComboBox<ListeTactique> comboBox_1;
	JLabel lblEpoque;
	JLabel lblStrategie;
	JComboBox<Modes> modes;
	JLabel nbBoats;
	JLabel tailleBoat;

	ControllerOptions co;

	/**
	 * Create the frame.
	 */

	public Options() {
		
		co = new ControllerOptions(this);
		frame = new JFrame();
		frame.setTitle("Options");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 550, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup bg = new ButtonGroup();
		modes = new JComboBox<Modes>();
		modes.setModel(new DefaultComboBoxModel<Modes>(Modes.values()));
		modes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modes.getSelectedItem() == Modes.Mosaique){
					tailleBateau.setEnabled(false);
				}else{
					tailleBateau.setEnabled(true);
				}
				
			}
		});
		rdbtnManuel = new JRadioButton("Manuel");
		

		rdbtnManuel.setBounds(172, 34, 77, 23);
		contentPane.add(rdbtnManuel);

		rdbtnAutomatique = new JRadioButton("Automatique");
		rdbtnAutomatique.setBounds(261, 34, 113, 23);
		contentPane.add(rdbtnAutomatique);
		bg.add(rdbtnAutomatique);
		bg.add(rdbtnManuel);

		lblModeDePlacement = new JLabel("Mode de placement :");
		lblModeDePlacement.setBounds(17, 38, 143, 16);
		contentPane.add(lblModeDePlacement);
		SpinnerNumberModel model1 = new SpinnerNumberModel(6.0, 6.0, 10.0, 1.0);
		SpinnerNumberModel model2 = new SpinnerNumberModel(2.0, 2.0, 5.0, 1.0);
		SpinnerNumberModel model3 = new SpinnerNumberModel(1.0, 1.0, 5.0, 1.0);
		spinner = new JSpinner(model1);
		tailleBateau = new JSpinner(model2);
		nbBateau = new JSpinner(model3);

		spinner.setBounds(131, 84, 58, 26);
		nbBateau.setBounds(300, 84, 58, 26);
		tailleBateau.setBounds(460, 84, 58, 26);
		contentPane.add(spinner);
		contentPane.add(nbBateau);
		tailleBateau.setEnabled(false);
		contentPane.add(tailleBateau);
		
		
		
		lblTailleDeLa = new JLabel("Taille de la grille :");
		lblTailleDeLa.setBounds(17, 89, 129, 16);
		contentPane.add(lblTailleDeLa);

		nbBoats = new JLabel("Nombre Bateaux : ");
		nbBoats.setBounds(190, 89, 129, 16);
		contentPane.add(nbBoats);
		
		tailleBoat = new JLabel("Taille bateaux :");
		tailleBoat.setBounds(360, 84, 90, 26);
		contentPane.add(tailleBoat);
		

		btnValider = new JButton("Valider");
		btnValider.addActionListener(co);

		btnValider.setBounds(172, 228, 117, 29);
		contentPane.add(btnValider);
		modes.setBounds(237, 200, 150, 27);
		contentPane.add(modes);
		
		comboBox = new JComboBox<listeEpoque>();
		comboBox.setModel(new DefaultComboBoxModel<listeEpoque>(listeEpoque.values()));
		comboBox.setBounds(237, 129, 150, 27);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox<ListeTactique>();
		comboBox_1.setModel(new DefaultComboBoxModel<ListeTactique>(ListeTactique.values()));
		comboBox_1.setBounds(237, 160, 150, 27);
		contentPane.add(comboBox_1);

		modeTexte = new JLabel ("Mode : ");
		modeTexte.setBounds(17, 210, 77, 16);
		contentPane.add(modeTexte);
		
		lblEpoque = new JLabel("Epoque :");
		lblEpoque.setBounds(17, 140, 77, 16);
		contentPane.add(lblEpoque);

		lblStrategie = new JLabel("Strategie :");
		lblStrategie.setBounds(17, 170, 96, 16);
		contentPane.add(lblStrategie);
		frame.setResizable(false);
	}

	public JLabel getTailleBoat() {
		return tailleBoat;
	}

	public void setTailleBoat(JLabel tailleBoat) {
		this.tailleBoat = tailleBoat;
	}

	

	public JLabel getNbBoats() {
		return nbBoats;
	}

	public void setNbBoats(JLabel nbBoats) {
		this.nbBoats = nbBoats;
	}

	

	public JLabel getModeTexte() {
		return modeTexte;
	}

	public void setModeTexte(JLabel modeTexte) {
		this.modeTexte = modeTexte;
	}

	public JSpinner getTailleBateau() {
		return tailleBateau;
	}

	public void setTailleBateau(JSpinner tailleBateau) {
		this.tailleBateau = tailleBateau;
	}

	public JSpinner getNbBateau() {
		return nbBateau;
	}

	public void setNbBateau(JSpinner nbBateau) {
		this.nbBateau = nbBateau;
	}

	public JComboBox<Modes> getModes() {
		return modes;
	}

	public void setModes(JComboBox<Modes> modes) {
		this.modes = modes;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JRadioButton getRdbtnManuel() {
		return rdbtnManuel;
	}

	public void setRdbtnManuel(JRadioButton rdbtnManuel) {
		this.rdbtnManuel = rdbtnManuel;
	}

	public JRadioButton getRdbtnAutomatique() {
		return rdbtnAutomatique;
	}

	public void setRdbtnAutomatique(JRadioButton rdbtnAutomatique) {
		this.rdbtnAutomatique = rdbtnAutomatique;
	}

	public JLabel getLblModeDePlacement() {
		return lblModeDePlacement;
	}

	public void setLblModeDePlacement(JLabel lblModeDePlacement) {
		this.lblModeDePlacement = lblModeDePlacement;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JLabel getLblTailleDeLa() {
		return lblTailleDeLa;
	}

	public void setLblTailleDeLa(JLabel lblTailleDeLa) {
		this.lblTailleDeLa = lblTailleDeLa;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public JLabel getLblEpoque() {
		return lblEpoque;
	}

	public void setLblEpoque(JLabel lblEpoque) {
		this.lblEpoque = lblEpoque;
	}

	public JLabel getLblStrategie() {
		return lblStrategie;
	}

	public void setLblStrategie(JLabel lblStrategie) {
		this.lblStrategie = lblStrategie;
	}

	public ControllerOptions getCo() {
		return co;
	}

	public void setCo(ControllerOptions co) {
		this.co = co;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
