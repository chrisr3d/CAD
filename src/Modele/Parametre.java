package Modele;

public class Parametre {

	private static int largeurPlateau;
	private static int hauteurPlateau;
	private boolean automatique;
	private Modes mode;

	public Parametre(int i, int i2, boolean b, Modes m) {
		this.hauteurPlateau = i;
		this.largeurPlateau = i2;
		this.mode = m;
	}
	
	public Modes getMode() {
		return mode;
	}

	public void setMode(Modes mode) {
		this.mode = mode;
	}

	public Parametre() {
	// TODO Auto-generated constructor stub
	}
	
	public static int getLargeurPlateau() {
		return largeurPlateau;
	}
	public void setLargeurPlateau(int largeurPlateau) {
		Parametre.largeurPlateau = largeurPlateau;
	}
	public static int getHauteurPlateau() {
		return hauteurPlateau;
	}
	public void setHauteurPlateau(int hauteurPlateau) {
		Parametre.hauteurPlateau = hauteurPlateau;
	}
	
	public boolean isAutomatique() {
		return automatique;
	}
	public void setAutomatique(boolean automatique) {
		this.automatique = automatique;
	}
	public void sauvegardeParametre() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
