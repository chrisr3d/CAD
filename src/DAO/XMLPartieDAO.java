package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Modele.CaseBateau;
import Modele.Partie;
import Modele.Plateau;
import Modele.Bateau.Bateau;

public class XMLPartieDAO extends DAO<Partie> {

	private volatile static XMLPartieDAO unique = null;

	public static XMLPartieDAO getInstance() {
		if (unique == null) {
			synchronized (XMLPartieDAO.class) {
				if (unique == null) {
					unique = new XMLPartieDAO();
				}
			}
		}
		return unique;
	}

	public Partie find() {
		// TODO Auto-generated method stub
		BufferedReader fichier;
		Partie p = new Partie();
		// Booléen qui va passer a TRUE si le fichier est mal formé et que le
		// parametre ne contient pas tout les attributs nécessaires
		boolean caMarchePas = false;
		try {
			fichier = new BufferedReader(new FileReader("save.xml"));
			String ligne;
			ArrayList<Bateau> bateauJoueur = new ArrayList<Bateau>();
			ArrayList<Bateau> bateauIA = new ArrayList<Bateau>();
			while ((ligne = fichier.readLine()) != null) {
				if (ligne.equals("<Partie>")) {

					// NbBateauRestantIA
					ligne = fichier.readLine();
					if (ligne.equals("<NbBateauRestantIA>")) {
						ligne = fichier.readLine();
						p.setNbBateauRestantIA(Integer.parseInt(ligne));
						ligne = fichier.readLine();
					} else {
						caMarchePas = true;
					}

					// Hauteur
					ligne = fichier.readLine();
					if (ligne.equals("<NbBateauRestantJoueur>")) {
						ligne = fichier.readLine();
						p.setNbBateauRestantJoueur(Integer.parseInt(ligne));
						ligne = fichier.readLine();
					} else {
						caMarchePas = true;
					}
				}
				if (ligne.equals("<BateauxIA>")) {
					while (!(ligne.equals("</BateauIA>"))) {
						ArrayList<CaseBateau> cbb = new ArrayList<CaseBateau>();
						// Bateau - tag
						if (ligne.equals("<Bateau>")) {
							Bateau bat = new Bateau();
							
							// Taille
							ligne = fichier.readLine();
							if (ligne.equals("<Taille>")) {
								ligne = fichier.readLine();
								bat.setTaille(Integer.parseInt(ligne));
								ligne = fichier.readLine();
							} else {
								caMarchePas = true;
							}

							// Horizontale
							ligne = fichier.readLine();
							if (ligne.equals("<Horizontale>")) {
								ligne = fichier.readLine();
								bat.setHorizontal((ligne.equals("True")) ? true : false);
								ligne = fichier.readLine();
							} else {
								caMarchePas = true;
							}

							ligne = fichier.readLine();
							while (!(ligne.equals("</Cases>"))) {
								if (ligne.equals("<Case>")) {
									int x = -1;
									int y = -1;
									// X
									ligne = fichier.readLine();
									if (ligne .equals("<X>")) {
										ligne = fichier.readLine();
										x = Integer.parseInt(ligne);
										ligne = fichier.readLine();
									} else {
										caMarchePas = true;
									}

									// Y
									ligne = fichier.readLine();
									if (ligne.equals("<Y>")) {
										ligne = fichier.readLine();
										y = (Integer.parseInt(ligne));
										ligne = fichier.readLine();
									} else {
										caMarchePas = true;
									}
									CaseBateau temp = new CaseBateau(x, y);
									// Cibler
									ligne = fichier.readLine();
									if (ligne.equals("<Cibler>")) {
										ligne = fichier.readLine();
										temp.setCibler((ligne.equals("True")) ? true : false);
										ligne = fichier.readLine();
									} else {
										caMarchePas = true;
									}
									cbb.add(temp);
								}
								ligne = fichier.readLine();
							}
							bat.setEmplacement(cbb);
							bateauIA.add(bat);
						}
						ligne = fichier.readLine();
					}
				} else if (ligne.equals("<BateauxJoueur>")) {
					while (!(ligne.equals("</BateauxJoueur>")) && ligne !=null) {
						// Bateau - tag
						if (ligne.equals("<Bateau>")) {
							Bateau bat = new Bateau();
							ArrayList<CaseBateau> cb = new ArrayList<CaseBateau>();
							// Taille
							ligne = fichier.readLine();
							if (ligne.equals("<Taille>")) {
								ligne = fichier.readLine();
								bat.setTaille(Integer.parseInt(ligne));
								ligne = fichier.readLine();
							} else {
								caMarchePas = true;
							}

							// Horizontale
							ligne = fichier.readLine();
							if (ligne.equals("<Horizontale>")) {
								ligne = fichier.readLine();
								bat.setHorizontal((ligne.equals("True")) ? true : false);
								ligne = fichier.readLine();
							} else {
								caMarchePas = true;
							}
							ligne = fichier.readLine();
							while (!(ligne.equals("</Cases>")) && ligne !=null) {
								
								if (ligne.equals("<Case>")) {
									int x = -1;
									int y = -1;
									// X
									ligne = fichier.readLine();
									if (ligne.equals("<X>")) {
										ligne = fichier.readLine();
										x = (Integer.parseInt(ligne));
										ligne = fichier.readLine();
									} else {
										caMarchePas = true;
									}

									// Y
									ligne = fichier.readLine();
									if (ligne.equals("<Y>")) {
										ligne = fichier.readLine();
										y = (Integer.parseInt(ligne));
										ligne = fichier.readLine();
									} else {
										caMarchePas = true;
									}
									CaseBateau temp = new CaseBateau(x, y);

									// Cibler
									ligne = fichier.readLine();
									if (ligne.equals("<Cibler>")) {
										ligne = fichier.readLine();
										
										temp.setCibler((ligne.equals("True")) ? true : false);
										ligne = fichier.readLine();
									} else {
										caMarchePas = true;
									}
									cb.add(temp);
								}
								ligne = fichier.readLine();
							}
							bat.setEmplacement(cb);
							bateauJoueur.add(bat);
						}
						ligne = fichier.readLine();
					}

				}
			}
			fichier.close();
			Plateau IA = new Plateau();
			IA.setBateau(bateauIA);
			Plateau Jou = new Plateau();
			Jou.setBateau(bateauJoueur);
			p.setIA(IA);
			p.setJoueur(Jou);
			
			if (caMarchePas) {
				throw (new Exception("La sauvegarde n'est pas récupérable !"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void save(Partie contenu) {
		// TODO Auto-generated method stub
		BufferedWriter fichier;
		try {
			fichier = new BufferedWriter(new FileWriter("save.xml", true));
			fichier.write("<Partie>");
			fichier.newLine();

			fichier.write("<NbBateauRestantIA>");
			fichier.newLine();
			fichier.write(contenu.getNbBateauRestantIA() + "");
			fichier.newLine();
			fichier.write("</NbBateauRestantIA>");
			fichier.newLine();

			fichier.write("<NbBateauRestantJoueur>");
			fichier.newLine();
			fichier.write(contenu.getNbBateauRestantJoueur() + "");
			fichier.newLine();
			fichier.write("</NbBateauRestantJoueur>");
			fichier.newLine();

			fichier.write("<BateauxIA>");
			for (Bateau boat : contenu.getIA().getBateau()) {

				fichier.newLine();
				fichier.write("<Bateau>");
				fichier.newLine();
				fichier.write("<Taille>");
				fichier.newLine();
				fichier.write(boat.getTaille() + "");
				fichier.newLine();
				fichier.write("</Taille>");
				fichier.newLine();

				fichier.write("<Horizontale>");
				fichier.newLine();
				fichier.write(boat.isHorizontal() ? "True" : "False");
				fichier.newLine();
				fichier.write("</Horizontale>");
				fichier.newLine();

				fichier.write("<Cases>");
				for (CaseBateau cb : boat.getEmplacement()) {

					fichier.newLine();
					fichier.write("<Case>");
					fichier.newLine();
					fichier.write("<X>");
					fichier.newLine();
					fichier.write(cb.getX() + "");
					fichier.newLine();
					fichier.write("</X>");

					fichier.newLine();
					fichier.write("<Y>");
					fichier.newLine();
					fichier.write(cb.getY() + "");
					fichier.newLine();
					fichier.write("</Y>");

					fichier.newLine();
					fichier.write("<Cibler>");
					fichier.newLine();
					fichier.write(cb.isCibler() ? "True" : "False");
					fichier.newLine();
					fichier.write("</Cibler>");
					fichier.newLine();
					fichier.write("</Case>");
				}
				fichier.newLine();
				fichier.write("</Cases>");
				fichier.newLine();
				fichier.write("</Bateau>");
			}
			fichier.newLine();
			fichier.write("</BateauIA>");
			fichier.newLine();

			fichier.write("<BateauxJoueur>");
			for (Bateau boat : contenu.getIA().getBateau()) {

				fichier.newLine();
				fichier.write("<Bateau>");
				fichier.newLine();
				fichier.write("<Taille>");
				fichier.newLine();
				fichier.write(boat.getTaille() + "");
				fichier.newLine();
				fichier.write("</Taille>");
				fichier.newLine();

				fichier.write("<Horizontale>");
				fichier.newLine();
				fichier.write(boat.isHorizontal() ? "True" : "False");
				fichier.newLine();
				fichier.write("</Horizontale>");
				fichier.newLine();

				fichier.write("<Cases>");
				for (CaseBateau cb : boat.getEmplacement()) {

					fichier.newLine();
					fichier.write("<Case>");
					fichier.newLine();
					fichier.write("<X>");
					fichier.newLine();
					fichier.write(cb.getX() + "");
					fichier.newLine();
					fichier.write("</X>");

					fichier.newLine();
					fichier.write("<Y>");
					fichier.newLine();
					fichier.write(cb.getY() + "");
					fichier.newLine();
					fichier.write("</Y>");

					fichier.newLine();
					fichier.write("<Cibler>");
					fichier.newLine();
					fichier.write(cb.isCibler() ? "True" : "False");
					fichier.newLine();
					fichier.write("</Cibler>");
					fichier.newLine();
					fichier.write("</Case>");
				}
				fichier.newLine();
				fichier.write("</Cases>");
				fichier.newLine();
				fichier.write("</Bateau>");
			}
			fichier.newLine();
			fichier.write("</BateauxJoueur>");
			fichier.newLine();

			fichier.write("</Partie>");
			fichier.newLine();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
