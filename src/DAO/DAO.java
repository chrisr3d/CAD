package DAO;


/**
 * @author Mathieu
 * Classe abstraite et generique qui permet de separer les differents moyens de sauvegarde
 * @param <T>
 */
public abstract class DAO<T>{

	/**
	 * Pour sauvegarder un element, je le passe en parametre.
	 * @param contenu
	 */
	public abstract void save(T contenu);

	/**
	 * @return l'objet de la classe que nous voulont recuperer
	 */
	public abstract T find();
	
}

