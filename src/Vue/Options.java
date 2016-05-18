package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modele.Parametre;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options  {
	private JFrame frame;

	private JPanel contentPane;

	JRadioButton rdbtnManuel;
	JRadioButton rdbtnAutomatique;
	JLabel lblModeDePlacement;
	JSpinner spinner;
	JLabel lblTailleDeLa;
	JButton btnValider;
	JComboBox comboBox;
	JComboBox comboBox_1;
	JLabel lblEpoque;
	JLabel lblStrategie;
	/**
	 * Create the frame.
	 */
	
	
	public Options() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup bg = new ButtonGroup();
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
		SpinnerNumberModel model1 = new SpinnerNumberModel(5.0, 5.0, 10.0, 1.0);
		 spinner = new JSpinner(model1);
		spinner.setBounds(231, 84, 58, 26);
		
		
		contentPane.add(spinner);
		
		 lblTailleDeLa = new JLabel("Taille de la grille :");
		lblTailleDeLa.setBounds(17, 89, 129, 16);
		contentPane.add(lblTailleDeLa);
		
		 btnValider = new JButton("Valider");
		 btnValider.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Double d = (Double)spinner.getValue();
		 		Integer i = d.intValue();
		 		System.out.println(spinner.getValue());
		 		Parametre p = new Parametre((int)i,(int) i, true, "");
		 		frame.setVisible(false);
				frame.setEnabled(false);
				VueJeu vj = new VueJeu(p);
				vj.setVisible(true);
		 		
		 	}
		 });
		btnValider.setBounds(172, 228, 117, 29);
		contentPane.add(btnValider);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(237, 129, 52, 27);
		contentPane.add(comboBox);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setBounds(237, 176, 52, 27);
		contentPane.add(comboBox_1);
		
		 lblEpoque = new JLabel("Epoque :");
		lblEpoque.setBounds(17, 140, 77, 16);
		contentPane.add(lblEpoque);
		
		 lblStrategie = new JLabel("Strategie :");
		lblStrategie.setBounds(17, 187, 96, 16);
		contentPane.add(lblStrategie);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
