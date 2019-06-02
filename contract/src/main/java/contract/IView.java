package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {
	/**
	 * Display a pop-up
	 * @param crystal
	 * 				the number of crystal must have to win
	 */
	void startPopup(int crystal);
	/**
	 * Set the controller in the view
	 * @param controller
	 * 				the controller
	 */
	void setController(final IController controller);
	/**
	 * Display a pop-up
	 */
	void win();
	/**
	 * Display a pop-up
	 */
	void lose();
}
