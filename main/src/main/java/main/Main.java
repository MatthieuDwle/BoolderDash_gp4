/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */

public abstract class Main {
	private static int crystal = 15;
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     * @throws InterruptedException 
     */
	
    public static void main(final String[] args) throws IOException, InterruptedException {
    	Model model = new Model(5);
    	View view = new View(model, crystal);
    	new Controller(model, view, crystal);
    }
}
