package DAO;

import java.io.File;

import Modele.Epoque.Epoque;

public abstract class DAO<T>{

	public abstract void save(String contenu);

	public abstract T find();
	
}

