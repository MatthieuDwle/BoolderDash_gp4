package entity;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * The ActiveEntity test class
 * @author asus
 *
 */
public class ActiveEntityTest {

	/**
	 * Testing if GetX recover x
	 */
	@Test
	public void testGetX() {
		ActiveEntity X = new ActiveEntity("getX");
		X.setPosition(4, 0);
		assertEquals(4, X.getX());
	}

	/**
	 * Testing if GetY recover y 
	 */
	@Test
	public void testGetY() {
		ActiveEntity Y = new ActiveEntity("getY");
		Y.setPosition(0, 5);
		assertEquals(5, Y.getY());
	}
}
