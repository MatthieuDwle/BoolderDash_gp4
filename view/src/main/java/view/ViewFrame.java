package view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import contract.IController;
import contract.IModel;
import showboard.BoardFrame;
import showboard.IPawn;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame implements KeyListener {

	/** The model. */
	private IModel model;
	/** The controller. */
	private IController	controller;
	/** The width. */
	private int width;
	/** The height. */
	private int height;
	/** The size width of the frame. */
	private int sizeFrameWidth;
	/** The size height of the frame. */
	private int sizeFrameHeight;
	
	/** The Board Frame*/
	BoardFrame boardFrame;
	
	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		
		this.setModel(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}
	
	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	
	private void setModel(IModel model) {
		this.model = model;
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}
	
	/**
	 * Gets the Board Frame 
	 * 
	 * @return boardFrame
	 */
	public BoardFrame getBoardFrame() {
		return this.boardFrame;
	}
	
	  /**
     * Sets the width.
     *
     * @param width
     *            the new width.
     */
	protected void setWidth(final int width) {
		this.width = width;
	}
	
	/**
	 * Gets the width 
	 * 
	 * @return Width
	 */
	public int getWidth() {
		return this.width;
	}
	
	  /**
     * Sets the height.
     *
     * @param height
     *            the new height.
     */
	protected void setHeight(final int height) {
		this.height = height;
	}
	
	/**
	 * Gets the height 
	 * 
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	
	 /**
     * Sets the frame size.
     *
     * @param sizeFrameWidth
     *            the new size width of the frame.
     * @param sizeFrameHeight
     * 			  the new size height of the frame.
     */
	protected void setSizeFrame() {
		this.sizeFrameWidth = width*16*3;
		this.sizeFrameHeight = height*16*3;
	}
	
	/**
	 *  Configure the frame 
	 * the name of frame
	 * Dimension and display size
	 * 
	 * * <h2>Explanation of how the method works.</h2>
     * <p>
     * A double loop to add all square to the frame.
     * </p>
     *
     * <pre>
     * {@code
     *         for (int x = 0; x < width; x++) {
     *             for (int y = 0; y < height; y++) {
     *                 [...]
     *              }
     *         }
     * }
     * </pre>
     * <p>
     * To have level background
     * Get dig dirt to the background.
     * </p>
     *
     *
     * <pre>
     * {@code
     *  boardFrame.addSquare(this.model.getLevel().getBackground(), x, y);           
     *             
     * }
     * </pre>
     * <p>
     * The pawn are added to the frame .
     * </p>
     *
     * <pre>
     * {@code
     *              	for (IPawn pawn : this.model.getLevel().getPawns()) {
			boardFrame.addPawn(pawn);
     * }
     * </pre>
     * <p>
     * The pawns are added to the frame.
     * </p>
     *
     * <pre>
     * {@code
     *         for (final Monster monster : this.monsters) {
     *             frame.addPawn(monster);
     *         }
     * }
     * </pre>
     * <p>
     * Add the frame as observer to refresh display.
     * </p>
     *
     * <pre>
     * {@code
     *       model.getObservable().addObserver(boardFrame.getObserver());
     * }
     * </pre>
     * <p>
     * Listen the key
     * </p>
     *
     * <pre>
     * {@code
     *     	this.boardFrame.addKeyListener(this);
     * }
     * </pre>
     *
	 */
	public void frameConfigure() {
		this.boardFrame = new BoardFrame("Boulderdash");
	    this.boardFrame.setDimension(new Dimension(width, height));
	    this.boardFrame.setDisplayFrame(new Rectangle(0,0,width,height));
	    this.boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
	    
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				boardFrame.addSquare(this.model.getLevel().getBackground(), x, y);
			}
		}
		for (IPawn pawn : this.model.getLevel().getPawns()) {
			boardFrame.addPawn(pawn);
		}
		model.getObservable().addObserver(boardFrame.getObserver());
		this.boardFrame.addKeyListener(this);
	}
	
}
