package DAO;


/**
 * @author Mathieu
 * Classe abstraite et générique qui permet de séparer les différents moyens de sauvegarde
 * @param <T>
 */
public abstract class DAO<T>{

	/**
	 * Pour sauvegarder un élément, je le passe en parametre.
	 * @param contenu
	 */
	public abstract void save(T contenu);

	/**
	 * @return l'objet de la classe que nous voulont récupérer
	 */
	public abstract T find();
	
}

