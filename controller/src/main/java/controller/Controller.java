package controller;

import java.io.IOException;


import contract.ControllerOrder;
import contract.IController;
import model.ActiveEntity;
import model.Bob;
import model.Model;
import showboard.IPawn;
import view.View;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private View	view;

	/** The model. */
	private Model	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller() {
		/*this.setView(view);
		this.setModel(model);*/
		this.model = new Model();
		try {
			model.loadLevel(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.view = new View(model);
		view.setController(this);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control(int levelNumber) {
	}


	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
			for (ActiveEntity pawn : this.model.getLevel().getPawns()) {
			if (pawn instanceof Bob) {
				switch (controllerOrder) {
				case UP:
					((Bob) pawn).moveUp();
				break;
				case DOWN:
					((Bob) pawn).moveDown();
				break;
				case RIGHT:
					((Bob) pawn).moveRight();
				break;
				case LEFT:
					((Bob) pawn).moveLeft();
				break;
				}
				
				//model.note();
			}
			
			}
					
		}
	}

