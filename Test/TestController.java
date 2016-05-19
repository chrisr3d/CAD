package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import Modele.Direction;
import Modele.Ennemi;
import Modele.Monde;
import Modele.PacMan;
import Modele.Personnage;
import Modele.Projectile;

public class TestController {
	protected Monde m;
	protected Personnage pm;

	@Before
	public void setUp() throws IOException{
		m = new Monde(600,400);
		pm = m.getPersonnages().get(0);
	}

	@Test
	public void testDeplacementGauche() throws IOException {
		pm.setX(60);
		pm.setY(60);
		pm.update(Direction.LEFT);
		assertEquals(60 - pm.getDeplacement(), pm.getX());
	}

	@Test
	public void testDeplacementGaucheContreObstacle() throws IOException {
		// Cr�ation contre un mur
		pm.setX(10);
		pm.setY(60);
		pm.update(Direction.LEFT);

		// M�thode pour tester si il y a une collision et replacement de pacman
		m.testerCollionsMur(pm,10-5,60);
		assertEquals(10, pm.getX());
	}

	@Test
	public void testDeplacementDroite() throws IOException {
		pm.setX(60);
		pm.setY(60);
		pm.update(Direction.RIGHT);
		assertEquals(60 + pm.getDeplacement(), pm.getX());
	}

	@Test
	public void testDeplacementDroiteContreObstacle() throws IOException {
		// Cr�ation contre un mur
		pm.update(Direction.RIGHT);

		// M�thode pour tester si il y a une collision et replacement de pacman
		pm.setX(450);
		pm.setY(60);
		m.testerCollionsMur(pm,450+5,60);
		assertEquals(450, pm.getX());
	}

	@Test
	public void testDeplacementHaut() throws IOException {
		pm.setX(60);
		pm.setY(60);
		pm.update(Direction.UP);
		assertEquals(60 - pm.getDeplacement(), pm.getY());
	}

	@Test
	public void testDeplacementHautContreObstacle() throws IOException {
		pm.update(Direction.UP);

		// M�thode pour tester si il y a une collision et replacement de pacman
		pm.setX(60);
		pm.setY(200);
		m.testerCollionsMur(pm,60,200-5);
		assertEquals(200, pm.getY());
	}

	@Test
	public void testDeplacementBas() throws IOException {
		pm.setX(60);
		pm.setY(60);
		pm.update(Direction.DOWN);
		assertEquals(60 + pm.getDeplacement(), pm.getY());
	}

	@Test
	public void testDeplacementBasContreObstacle() throws IOException {
		pm.update(Direction.DOWN);

		// M�thode pour tester si il y a une collision et replacement de pacman
		pm.setX(60);
		pm.setY(250);
		m.testerCollionsMur(pm,60,250+5);
		assertEquals(250, pm.getY());
	}
	
	@Test
	public void testCollisionProjectileGauche() throws IOException{
		Ennemi e = new Ennemi(50, 51, m);
		m.getListPersonnage().add(e);
	    Projectile p = new Projectile(79,51,m.getPacmanPX()+4,m.getPacmanPY(),4,19,8,ImageIO.read(new File("Texture/FlecheR.png")),m,Direction.LEFT);
		m.getListPersonnage().add(p);
	    m.testerCollisionsProjectile(e, e.getX(), e.getY());
		boolean mort = m.getListMort().contains(e);
		assertTrue(mort);
		
		
	}
	
	@Test
	public void testCollisionProjectileDroite() throws IOException{
		Ennemi e = new Ennemi(50, 51, m);
		m.getListPersonnage().add(e);
	    Projectile p = new Projectile(79,51,m.getPacmanPX()+4,m.getPacmanPY(),4,19,8,ImageIO.read(new File("Texture/FlecheR.png")),m,Direction.RIGHT);
		m.getListPersonnage().add(p);
	    m.testerCollisionsProjectile(e, e.getX(), e.getY());
		boolean mort = m.getListMort().contains(e);
		assertTrue(mort);
		
	}
	
	@Test
	public void testCollisionProjectileHaut() throws IOException{
		Ennemi e = new Ennemi(50, 40, m);
		m.getListPersonnage().add(e);
		Projectile p = new Projectile(m.getPacmanPX()+(m.LargeurUnite/2),m.getPacmanPY()+m.HauteurUnite-50,m.getPacmanPX(),m.getPacmanPY(),4,19,8,ImageIO.read(new File("Texture/FlecheU.png")),m,Direction.UP);
		m.getListPersonnage().add(p);
	    m.testerCollisionsProjectile(e, e.getX(), e.getY());
		boolean mort = m.getListMort().contains(e);
		assertTrue(mort);
		
	}
	
	@Test
	public void testCollisionProjectileBas() throws IOException{
		Ennemi e = new Ennemi(50, 75, m);
		m.getListPersonnage().add(e);
		Projectile p = new Projectile(50,75,4,19,4,19,8,ImageIO.read(new File("Texture/FlecheD.png")),m,Direction.DOWN);
		p.setX(50);
		p.setY(75);
		p.getRect().setLocation(p.getX(), p.getY());
		m.getListPersonnage().add(p);
	    m.testerCollisionsProjectile(e, e.getX(), e.getY());
		boolean mort = m.getListMort().contains(e);
		assertTrue(mort);
		
		
	}
	
	
	

}
