package entity;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;



import org.junit.Test;

/**
 * The GraphicEntityTest class
 * 
 * @author asus
 *
 */


public class GraphicEntityTest {

	/**
	 * The method for test the loading of image
	 * @throws IOException
	 */
	@Test
	public void testLoadImage() throws IOException {
		Wall wall = new Wall("Wall.png");
		wall.loadImage();
		assertNotNull(wall.getImage());
	}
}
