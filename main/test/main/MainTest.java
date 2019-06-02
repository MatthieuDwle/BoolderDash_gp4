package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;
/**
 * The class Main Test
 * 
 * @author asus
 *
 */
public class MainTest {

	
/**
 * Instantiate a new Model
 * 
 * @throws Exception
 */
	@Before
	public void setUp() throws Exception {
		Model model = new Model(1);
	}

	/**
	 * 
	 * Testing if Model have the godd level number or model is out of range 
	 * 
	 */
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
