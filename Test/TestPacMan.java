package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Modele.PacMan;

public class TestPacMan {
	protected PacMan p;
	
	
	@Before
	public void setUp() throws IOException{
		p = new PacMan(null);
	}
	
	@Test
	public void testSetXBasic(){
		p.setX(3);
		assertEquals(3, p.getX());
		
	}
	
	

}
