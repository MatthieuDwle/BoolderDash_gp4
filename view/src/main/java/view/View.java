package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

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
	 */
	public View(final IModel model, final int sizeFrame) {
		this.viewFrame = new ViewFrame(model);
		this.viewFrame.setWidth(model.getLevel().getBoard().getWidth());
		this.viewFrame.setHeight(model.getLevel().getBoard().getHeight());
		this.viewFrame.setSizeFrame(sizeFrame);
		SwingUtilities.invokeLater(this);
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
			case KeyEvent.VK_Z:
				return ControllerOrder.UP;
			case KeyEvent.VK_S:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_D:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_Q:
				return ControllerOrder.LEFT;
			default:
				return null;
			
		}
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.getBoardFrame().setSize(this.viewFrame.getWidth(), this.viewFrame.getHeight());
		this.viewFrame.getBoardFrame().setDimension(new Dimension(this.viewFrame.getWidth(), this.viewFrame.getHeight()));
		this.viewFrame.getBoardFrame().setDisplayFrame(new Rectangle(0, 0, this.viewFrame.getWidth(), this.viewFrame.getHeight()));
		
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
}
