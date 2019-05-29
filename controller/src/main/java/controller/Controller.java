package controller;

import java.io.IOException;


import contract.ControllerOrder;
import contract.IController;
import model.Model;
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
		this.view = new View(model, 600);
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
		/*try {
			this.model.loadLevel(levelNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		
	}

}
