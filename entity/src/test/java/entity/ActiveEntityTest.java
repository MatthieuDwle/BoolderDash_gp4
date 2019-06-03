package entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActiveEntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetX() {
		ActiveEntity X = new ActiveEntity("getX");
		X.setPosition(4, 0);
		assertEquals(4, X.getX());
	}

	@Test
	public void testGetY() {
		ActiveEntity Y = new ActiveEntity("getY");
		Y.setPosition(0, 5);
		assertEquals(5, Y.getY());
	}

}
