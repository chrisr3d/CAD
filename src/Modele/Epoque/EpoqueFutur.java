package Modele.Epoque;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Modele.Bateau.*;
import Modele.Tactique.TactiqueAleatoire;
public class EpoqueFutur implements Epoque{

	//volatile pour autoriser l'initialisation à null !
	private volatile static EpoqueFutur unique = null;
	
	public static EpoqueFutur getInstance(){
		if(unique == null){
			synchronized(EpoqueFutur.class){
				if(unique == null){
					unique = new EpoqueFutur();
				}
			}
		}
		return unique;
	}
	
	public ArrayList<Bateau> setEpoque(ArrayList<Bateau> listBateau) {
		// TODO Auto-generated method stub
		for (Bateau bateau : listBateau) {
			this.ajoutNomEpoque(bateau);
			this.ajoutPuissanceEpoque(bateau);
			try {
				this.ajoutImageEpoque(bateau);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listBateau;
	}
	/**
	 * Méthode qui va donner une image de l'époque futuriste au bateau passé en paramètre
	 * Si le bateau est horizontal, le bateau n'aura pas la même texture !
	 * @param b : bateau
	 * @throws IOException : exeception pour la lecture des images en dur
	 */
	private void ajoutImageEpoque(Bateau b) throws IOException {
		// TODO Auto-generated method stub
		BufferedImage in = null;
		File img = null;
		if(b.isHorizontal()){
			switch (b.getTaille()) {
			case 1:
				img = new File("/images/futur/Chas-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 2:
				img = new File("/images/futur/Croi-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 3:
				img = new File("/images/futur/Cuir-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 4:
				img = new File("/images/futur/Mere-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			default:
				img = new File("/images/futur/Mere-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			}
		}else{
			switch (b.getTaille()) {
			case 1:
				img = new File("/images/futur/Chas-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 2:
				img = new File("/images/futur/Croi-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 3:
				img = new File("/images/futur/Cuir-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 4:
				img = new File("/images/futur/Mere-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			default:
				img = new File("/images/futur/Mere-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			}
		}
	}

	/**
	 * Méthode qui permet l'ajout d'une puissance à un bateau correspondant à l'époque futuriste
	 * @param b : bateau
	 */
	private void ajoutPuissanceEpoque(Bateau b) {
		// TODO Auto-generated method stub
		switch (b.getTaille()) {
		case 1:
			b.setPuissance(6);
			break;
		case 2:
			b.setPuissance(8);
			break;
		case 3:
			b.setPuissance(10);
			break;
		case 4:
			b.setPuissance(12);
			break;
		default:
			b.setPuissance(12);
			break;
		}
	}

	/**
	 * Méthode qui permet l'ajout d'un nom correspondant à l'époque futuriste
	 * Sources : https://fr.wikipedia.org/wiki/Vaisseau_spatial
	 * @param b : bateau
	 */
	private void ajoutNomEpoque(Bateau b) {
		switch (b.getTaille()) {
		case 1:
			b.setNom("Chasseur");
			break;
		case 2:
			b.setNom("Croiseur");
			break;
		case 3:
			b.setNom("Cuirassé");
			break;
		case 4:
			b.setNom("Vaisseau-mère");
			break;
		default:
			b.setNom("Vaisseau-mère");
			break;
		}
	}

	
	
}
