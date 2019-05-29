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
	/** The size of the frame. */
	private int sizeFrameWidth;
	private int sizeFrameHeight;
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
	
	public BoardFrame getBoardFrame() {
		return this.boardFrame;
	}
	
	protected void setWidth(final int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	protected void setHeight(final int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	protected void setSizeFrame() {
		this.sizeFrameWidth = width*16*3;
		this.sizeFrameHeight = height*16*3;
	}
	
	
	public void frameConfigure() {
		this.boardFrame = new BoardFrame("Boulderdash");
	    this.boardFrame.setDimension(new Dimension(width, height));
	    this.boardFrame.setDisplayFrame(new Rectangle(0,0,width,height));
	    this.boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
	    
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				boardFrame.addSquare(this.model.getLevel().getFond(), x, y);
			}
		}
		for (IPawn pawn : this.model.getLevel().getPawns()) {
			boardFrame.addPawn(pawn);
		}
		model.getObservable().addObserver(boardFrame.getObserver());
		this.boardFrame.addKeyListener(this);
	}
	
}
