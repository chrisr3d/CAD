package Modele;

public class Parametre {

	private static int largeurPlateau;
	private static int hauteurPlateau;
	private boolean automatique;
	
	public Parametre(int i, int i2, boolean b, String string) {
		// TODO Auto-generated constructor stub
	}
	public static int getLargeurPlateau() {
		return largeurPlateau;
	}
	public void setLargeurPlateau(int largeurPlateau) {
		this.largeurPlateau = largeurPlateau;
	}
	public static int getHauteurPlateau() {
		return hauteurPlateau;
	}
	public void setHauteurPlateau(int hauteurPlateau) {
		this.hauteurPlateau = hauteurPlateau;
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
