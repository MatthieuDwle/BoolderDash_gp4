package contract;

import java.io.IOException;
import java.util.Observable;

import entity.Level;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel{
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	/**
	 * Load the message
	 * 
	 * @param levelNumber
	 * @throws IOException
	 */
	void loadLevel(int levelNumber) throws IOException;
/**
 *  Get the level
 *  
 * @return the the level
 */
	Level getLevel();

	/**
	 * note
	 * 
	 * note
	 */
	void note();
}
