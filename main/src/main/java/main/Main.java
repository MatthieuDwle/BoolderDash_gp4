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
     * @throws InterruptedException 
     */
	
    public static void main(final String[] args) throws IOException, InterruptedException {
    	final Controller controller = new Controller();
    	controller.control(1);
    }
}
