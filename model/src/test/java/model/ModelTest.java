/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import org.junit.Assert;
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
     * test link with level
     */
    @Test
    public void testLoadLevel() {
    	
    	this.model = new Model(1);
        Assert.assertEquals(0, this.model.getLevel().getPawns().get(0).getX());
        
    }
}
