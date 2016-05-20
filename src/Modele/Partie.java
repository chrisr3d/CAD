package Modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

/**
 * @author Misternutz
 *
 */
public class Partie extends Observable {

	private volatile static Partie unique = null;

	Parametre param;

	int NbBateauRestantJoueur;

	int NbBateauRestantIA;

	Plateau joueur;

	Plateau IA;

	public static Partie getInstance() {
		if (unique == null) {
			synchronized (Partie.class) {
				if (unique == null) {
					unique = new Partie();
				}
			}
		}
		return unique;
	}

	private Partie() {

	}

	public void caseDonneBateau(Case c) {
		Bateau temp = null;
		for (Bateau b : this.getIA().getBateau()) {
			for (Case ca : b.getEmplacement()) {
				if (c.getX() == ca.getX() && c.getY() == ca.getY()) {
					ca.setCibler(true);

				}
			}
		}

	}

	public void caseDonneBateauJoueur(Case c) {
		Bateau temp = null;
		for (Bateau b : this.getJoueur().getBateau()) {
			for (Case ca : b.getEmplacement()) {
				if (c.getX() == ca.getX() && c.getY() == ca.getY()) {
					ca.setCibler(true);

				}
			}
		}

	}

	public boolean tirer(Case c) {
		boolean toucher = false;
		Bateau b = null;
		for (int i = 0; i < IA.getCarte().length; i++) {
			for (int j = 0; j < IA.getCarte().length; j++) {
				if (IA.getCarte()[i][j] == c && NbBateauRestantJoueur > 0) {
					IA.getCarte()[i][j].setCibler(true);

					if (IA.getCarte()[i][j] instanceof CaseBateau) {
						caseDonneBateau(IA.getCarte()[i][j]);
						toucher = true;
					}
				}
			}
		}

		verificationMortIA(IA);
		return toucher;

	}

	public void Jouer() {

	}

	public Case JouerIA() {

		Case c = ContexteTactique.getTactique().appliquerTactique(IA, joueur);

		return c;
	}

	/**
	 * M�thode qui permet de sauvegarder une partie
	 * 
	 * @author Mathieu
	 */
	public void SauvegarderPartie() {
		// Suppr�ssion du fichier de sauvegarde avant de le r�utiliser pour
		// �viter les probl�mes.
		// Une seule sauvegarde possible par cons�quent !
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
		XMLStrategieDAO strategie = XMLStrategieDAO.getInstance();
		XMLParametreDAO parametre = XMLParametreDAO.getInstance();
		XMLEpoqueDAO epoque = XMLEpoqueDAO.getInstance();
		XMLPartieDAO partie = XMLPartieDAO.getInstance();
		epoque.save(FabriqueEpoque.getEpoque());
		strategie.save(ContexteTactique.getTactique());
		parametre.save(this.param);
		partie.save(this);

	}

	/***
	 * M�tode qui permet de charger une partie
	 * 
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
		if (FabriqueEpoque.getEpoque() instanceof EpoqueActuelle) {
			FabriqueEpoque.choisirEpoqueActuelle(this.getIA().getBateau());
			FabriqueEpoque.choisirEpoqueActuelle(this.getJoueur().getBateau());
		} else if (FabriqueEpoque.getEpoque() instanceof EpoqueFutur) {
			FabriqueEpoque.choisirEpoqueFutur(this.getIA().getBateau());
			FabriqueEpoque.choisirEpoqueFutur(this.getJoueur().getBateau());
		}
		Partie.getInstance().getIA().remplirCaseVide();
		Partie.getInstance().getJoueur().remplirCaseVide();
	}

	public void verificationMort(Plateau p) {
		int compteur = 0;
		Bateau tempo = null;
		ArrayList<Bateau> temp = new ArrayList<Bateau>();
		temp = p.getBateau();
		for (Bateau b : p.getBateau()) {
			compteur = 0;
			for (CaseBateau cb : b.getEmplacement()) {
				if (cb.isCibler()) {
					compteur++;
				}
				if (compteur == b.taille) {
					tempo = b;
				}
			}
		}

		if (tempo != null) {
			p.getBateau().remove(tempo);
			NbBateauRestantJoueur--;

		}

	}

	public void verificationMortIA(Plateau p) {
		int compteur = 0;
		Bateau tempo = null;
		ArrayList<Bateau> temp = new ArrayList<Bateau>();
		temp = p.getBateau();
		for (Bateau b : p.getBateau()) {
			compteur = 0;
			for (CaseBateau cb : b.getEmplacement()) {
				if (cb.isCibler()) {
					compteur++;
				}
				if (compteur == b.taille) {
					tempo = b;
				}
			}
		}

		if (tempo != null) {
			p.getBateau().remove(tempo);
			NbBateauRestantIA--;

		}

	}

	public void tournerBateau(Bateau b) {

	}

	// Pour une case donnée, si oui ou non elle est accessible
	
	public ArrayList<Case> testPorte() {
		ArrayList<Case> caseOk = new ArrayList<Case>();
		boolean ok = false;
		for (Bateau bat : this.getJoueur().getBateau()) {
			for (CaseBateau cb : bat.getEmplacement()) {
				for (int i = 0; i < Parametre.getHauteurPlateau(); i++) {
					for (int j = 0; j < Parametre.getLargeurPlateau(); j++) {
						Case temp = new Case(Parametre.getHauteurPlateau()-1,cb.getY());
						if ((Math.abs	(IA.getCarte()[i][j].getX() - temp.getX())
								
								+ Math.abs(temp.getY() - IA.getCarte()[i][j].getY())
								+ (cb.getX()+1)) <= bat.getPuissance()) {
							for(Case c : caseOk){
							if(c.getX() == this.getJoueur().getCarte()[i][j].getX() && c.getY() == this.getJoueur().getCarte()[i][j].getY()){
								ok = true;
							}
							}
							if(!ok){
								caseOk.add(this.getJoueur().getCarte()[i][j]);
							}
							
							} ok = false;
						
						}
					}
				}
			}
		
		return caseOk;

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
