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
	
	void loadLevel(int levelNumber) throws IOException;

	Level getLevel();

	void note();
}
