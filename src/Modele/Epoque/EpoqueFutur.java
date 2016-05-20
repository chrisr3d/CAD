package Modele.Epoque;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import Modele.Bateau.*;

/**
 * Classe EpoqueFutur qui va appliquer les images, les noms et la puissance selon l'epoque en question
 * @author Mathieu
 *
 */
public class EpoqueFutur implements Epoque{

	//volatile pour autoriser l'initialisation � null !
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
	 * M�thode qui va donner une image de l'�poque futuriste au bateau pass� en param�tre
	 * Si le bateau est horizontal, le bateau n'aura pas la m�me texture !
	 * @param b : bateau
	 * @throws IOException : exeception pour la lecture des images en dur
	 */
	private void ajoutImageEpoque(Bateau b) throws IOException {
		// TODO Auto-generated method stub
	/*	BufferedImage in = null;
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
			case 2:
				img = new File("/images/futur/Chas-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 3:
				img = new File("/images/futur/Croi-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 4:
				img = new File("/images/futur/Cuir-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 5:
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
		}*/
	}

	/**
	 * M�thode qui permet l'ajout d'une puissance � un bateau correspondant � l'�poque futuriste
	 * @param b : bateau
	 */
	private void ajoutPuissanceEpoque(Bateau b) {
		// TODO Auto-generated method stub
		switch (b.getTaille()) {
		case 2:
			b.setPuissance(6);
			break;
		case 3:
			b.setPuissance(8);
			break;
		case 4:
			b.setPuissance(10);
			break;
		case 5:
			b.setPuissance(12);
			break;
		default:
			b.setPuissance(12);
			break;
		}
	}

	/**
	 * M�thode qui permet l'ajout d'un nom correspondant � l'�poque futuriste
	 * Sources : https://fr.wikipedia.org/wiki/Vaisseau_spatial
	 * @param b : bateau
	 */
	private void ajoutNomEpoque(Bateau b) {
		switch (b.getTaille()) {
		case 2:
			b.setNom("Chasseur");
			break;
		case 3:
			b.setNom("Croiseur");
			break;
		case 4:
			b.setNom("Cuirass�");
			break;
		case 5:
			b.setNom("Vaisseau-m�re");
			break;
		default:
			b.setNom("Vaisseau-m�re");
			break;
		}
	}

	public String getNomEpoque() {
		// TODO Auto-generated method stub
		return "Futur";
	}

	
	
}
