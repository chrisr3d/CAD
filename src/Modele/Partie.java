package Modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.parsers.FactoryConfigurationError;

import DAO.XMLDAOFactory;
import DAO.XMLEpoqueDAO;
import DAO.XMLParametreDAO;
import DAO.XMLPartieDAO;
import DAO.XMLStrategieDAO;
import Modele.Observable;

import Modele.Bateau.Bateau;
import Modele.Epoque.EpoqueActuelle;
import Modele.Epoque.EpoqueFutur;
import Modele.Epoque.FabriqueEpoque;
import Modele.Tactique.ContexteTactique;

public class Partie extends Observable {

	private volatile static Partie unique = null;

	Parametre param;

	int NbBateauRestantJoueur;

	int NbBateauRestantIA;

	Plateau joueur;

	Plateau IA;

	public static Partie getInstance(){
		if(unique == null){
			synchronized(Partie.class){
				if(unique == null){
					unique = new Partie();
				}
			}
		}
		return unique;
	}
	
	private Partie() {

	}

	public void Jouer() {

	}

	public void JouerIA() {

	}

	/**
	 * Méthode qui permet de sauvegarder une partie
	 * @author Mathieu
	 */
	public void SauvegarderPartie() {
		//Suppréssion du fichier de sauvegarde avant de le réutiliser pour éviter les problèmes.
		//Une seule sauvegarde possible par conséquent !
		File file = new File("save.xml");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XMLEpoqueDAO epoque = XMLEpoqueDAO.getInstance();
		XMLPartieDAO partie = XMLPartieDAO.getInstance();
		XMLStrategieDAO strategie = XMLStrategieDAO.getInstance();
		XMLParametreDAO parametre = XMLParametreDAO.getInstance();
		epoque.save(FabriqueEpoque.getEpoque());
		partie.save(this);
		strategie.save(ContexteTactique.getTactique());
		parametre.save(this.param);
		
	}

	/***
	 * Métode qui permet de charger une partie
	 * @author Mathieu
	 */
	public void changerParametre() {
		XMLDAOFactory factory = new XMLDAOFactory();
		XMLEpoqueDAO epoque = (XMLEpoqueDAO) factory.getEpoqueDAO();
		XMLPartieDAO partie = (XMLPartieDAO) factory.getPartieDAO();
		XMLStrategieDAO strategie = (XMLStrategieDAO) factory.getStrategie();
		XMLParametreDAO parametre = (XMLParametreDAO) factory.getParametreDAO();
		epoque.find();
		strategie.find();
		parametre.find();
		Partie temporaire = partie.find();
		this.setIA(temporaire.getIA());
		this.setJoueur(temporaire.getJoueur());
		this.setNbBateauRestantIA(temporaire.getNbBateauRestantIA());
		this.setNbBateauRestantJoueur(temporaire.getNbBateauRestantJoueur());
		this.setParam(parametre.find());
		if(FabriqueEpoque.getEpoque() instanceof EpoqueActuelle){
			FabriqueEpoque.choisirEpoqueActuelle(this.getIA().getBateau());
			FabriqueEpoque.choisirEpoqueActuelle(this.getJoueur().getBateau());
		}else if(FabriqueEpoque.getEpoque() instanceof EpoqueFutur){
			FabriqueEpoque.choisirEpoqueFutur(this.getIA().getBateau());
			FabriqueEpoque.choisirEpoqueFutur(this.getJoueur().getBateau());
		}
	}

	public void tournerBateau(Bateau b) {

	}

	public Parametre getParametres() {
		return param;
	}

	public void setParam(Parametre param) {
		this.param = param;
	}


	public int getNbBateauRestantJoueur() {
		return NbBateauRestantJoueur;
	}

	public void setNbBateauRestantJoueur(int nbBateauRestantJoueur) {
		NbBateauRestantJoueur = nbBateauRestantJoueur;
	}

	public int getNbBateauRestantIA() {
		return NbBateauRestantIA;
	}

	public void setNbBateauRestantIA(int nbBateauRestantIA) {
		NbBateauRestantIA = nbBateauRestantIA;
	}

	public Plateau getJoueur() {
		return joueur;
	}

	public void setJoueur(Plateau joueur) {
		this.joueur = joueur;
	}

	public Plateau getIA() {
		return IA;
	}

	public void setIA(Plateau iA) {
		IA = iA;
	}
}
