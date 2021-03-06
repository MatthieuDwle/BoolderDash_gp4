package view;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	
	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 * @param crystal
	 * 			the number of crystal must have to win         
	 */
	
	
	public View(final IModel model, final int crystal) {
		this.viewFrame = new ViewFrame(model, "BoulderDash");
		this.viewFrame.setWidth(model.getLevel().getBoard().getWidth());
		this.viewFrame.setHeight(model.getLevel().getBoard().getHeight());
		this.viewFrame.setSizeFrame();
		SwingUtilities.invokeLater(this);
		this.startPopup(crystal);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			default:
				return null;
		}
	}


	
	/**
	 * Launch the creation of frame 
	 * 
	 */
	public void run() {
		this.viewFrame.frameConfigure();
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	
	/**
	 * Display a Pop Up with the condition of winning
	 * @param crystal
	 * 			the number of crystal must have to win 
	 */
	public void startPopup(int crystal){
		JOptionPane.showMessageDialog(null, "CATCH " + crystal + " CRYSTAL TO ESCAPE !" );
	}
	
	/**
	 * Display a Pop Up with a win message
	 * 
	 */
	public void win() {
		JOptionPane.showMessageDialog(null, "YOU WIN !!!");
	}
	
	/**
	 * Display a message when Bob die 
	 * 
	 */
	public void lose() {
		JOptionPane.showMessageDialog(null, "YOU LOSE....");
	}

}
