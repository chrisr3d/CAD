package Modele.Epoque;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Modele.Bateau.*;

public class EpoqueActuelle implements Epoque{

	@Override
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
	 * M�thode qui va donner une image de l'�poque actuelle au bateau pass� en param�tre
	 * Si le bateau est horizontal, le bateau n'aura pas la m�me texture !
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
				img = new File("/images/actuelle/Torp-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 2:
				img = new File("/images/actuelle/Patr-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 3:
				img = new File("/images/actuelle/Dest-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 4:
				img = new File("/images/actuelle/Port-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			default:
				img = new File("/images/actuelle/Port-H.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			}
		}else{
			switch (b.getTaille()) {
			case 1:
				img = new File("/images/actuelle/Torp-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 2:
				img = new File("/images/actuelle/Patr-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 3:
				img = new File("/images/actuelle/Dest-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			case 4:
				img = new File("/images/actuelle/Port-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			default:
				img = new File("/images/actuelle/Port-V.png");
				in =  ImageIO.read(img);
				b.setTexture(in);
				break;
			}
		}
	}

	/**
	 * M�thode qui permet l'ajout d'une puissance � un bateau correspondant � l'�poque Actuelle
	 * @param b : bateau
	 */
	private void ajoutPuissanceEpoque(Bateau b) {
		// TODO Auto-generated method stub
		switch (b.getTaille()) {
		case 1:
			b.setPuissance(5);
			break;
		case 2:
			b.setPuissance(7);
			break;
		case 3:
			b.setPuissance(9);
			break;
		case 4:
			b.setPuissance(11);
			break;
		default:
			b.setPuissance(11);
			break;
		}
	}

	/**
	 * M�thode qui permet l'ajout d'un nom correspondant � l'�poque Actuelle
	 * Sources : https://fr.wikipedia.org/wiki/Liste_des_types_de_navires
	 * @param b : bateau
	 */
	private void ajoutNomEpoque(Bateau b) {
		switch (b.getTaille()) {
		case 1:
			b.setNom("Torpilleurs");
			break;
		case 2:
			b.setNom("Patrouilleurs");
			break;
		case 3:
			b.setNom("Destroyers");
			break;
		case 4:
			b.setNom("Porte Avion");
			break;
		default:
			b.setNom("Porte Avion");
			break;
		}
	}

}