package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

public class MainTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Model model = new Model(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		try {
			new Model(0);
			fail("No available Level");
		}catch ( final Exception e) {
		final String expected = "Out of range";
		
		}
		
	}

}
