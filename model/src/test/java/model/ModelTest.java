/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class ModelTest
 * 
 * @author asus
 *
 */
public class ModelTest {
    private Model model;

 
    /** 
     * Instantiate new model
     * @throws Exception
     * 			throws exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(1);
    }

    /**
     * test link with level
     */
    @Test
    public void testGetXindex() {
        try {
			this.model.loadLevel(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Assert.assertEquals(0, this.model.getLevel().getPawns().get(0).getX());
        
    }
}
