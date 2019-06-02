package entity;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.IOException;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphicEntityTest {
	
	   private Image image;
	    private String imageName;

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
	public void testLoadImage() throws IOException {
		Wall wall = new Wall("Wall.png");
		wall.loadImage();
	}
}
