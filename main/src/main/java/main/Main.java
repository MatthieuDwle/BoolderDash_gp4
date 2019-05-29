/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import controller.Controller;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     */
	
    public static void main(final String[] args) throws IOException {
        /*final Model model = new Model();
        model.loadLevel(1);
        final View view = new View(model, 500);
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.control(1);*/
    	
    	final Controller controller = new Controller();
    	controller.control(1);
    }
}
