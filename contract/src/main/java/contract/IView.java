package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {
	void startPopup(int crystal);
	void setController(final IController controller);
	void win();
	void lose();
}
