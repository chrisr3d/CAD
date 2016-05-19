package DAO;


/**
 * @author Mathieu
 * Classe abstraite et g�n�rique qui permet de s�parer les diff�rents moyens de sauvegarde
 * @param <T>
 */
public abstract class DAO<T>{

	/**
	 * Pour sauvegarder un �l�ment, je le passe en parametre.
	 * @param contenu
	 */
	public abstract void save(T contenu);

	/**
	 * @return l'objet de la classe que nous voulont r�cup�rer
	 */
	public abstract T find();
	
}

