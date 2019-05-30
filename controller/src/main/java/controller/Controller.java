package controller;

import java.io.IOException;

import contract.ControllerOrder;
import contract.IController;
import entity.ActiveEntity;
import entity.Bob;
import entity.Crystal;
import entity.Dirt;
import entity.Exit;
import entity.Rock;
import entity.Wall;
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
	
	private int crystal = 15;
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
		this.view.startPopup(crystal);
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
		ActiveEntity bob = null;
			for (ActiveEntity pawn : this.model.getLevel().getPawns()) {
				if (pawn instanceof Bob) {
					bob = pawn;
					
				}
			}
			switch (controllerOrder) {
			case UP:
				((Bob) bob).moveUp(this.testFront(bob, controllerOrder));
			break;
			case DOWN:
				((Bob) bob).moveDown(this.testFront(bob, controllerOrder));
			break;
			case RIGHT:
				((Bob) bob).moveRight(this.testFront(bob, controllerOrder));
			break;
			case LEFT:
				((Bob) bob).moveLeft(this.testFront(bob, controllerOrder));
			break;
			}
			model.note();
		}
	
	private boolean testFront(ActiveEntity bob, final ControllerOrder controllerOrder) {
		ActiveEntity element = null;
		boolean canMove = false;
		for (ActiveEntity pawn : this.model.getLevel().getPawns()){
			switch (controllerOrder) {
			case UP:
				if (pawn.getX() == bob.getX() && pawn.getY() == bob.getY()-1) {
					element = pawn;
					canMove = true;
				}
			break;
			case DOWN:
				if (pawn.getX() == bob.getX() && pawn.getY() == bob.getY()+1) {
					element = pawn;
					canMove = true;
				}
			break;
			case RIGHT:
				if (pawn.getX() == bob.getX()+1 && pawn.getY() == bob.getY()) {
					element = pawn;
					canMove = true;
				}
			break;
			case LEFT:
				if (pawn.getX() == bob.getX()-1 && pawn.getY() == bob.getY()) {
					element = pawn;	
				}
			break;
			}
		}
		if (element instanceof Dirt) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
		}
		else if(element instanceof Crystal) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			((Bob) bob).addCrystal(crystal);
		}
		else if (element instanceof Wall || element instanceof Rock) {
			canMove = false;
		}
		else if (element instanceof Exit && ((Bob) bob).getCrystalCount() < crystal ) {
			canMove = false;
			
		}
		else if (element instanceof Exit && ((Bob) bob).getCrystalCount() >= crystal ) {
			canMove = true;
			this.view.win();
			System.exit(0);
		}
		
		else {
			canMove = true;
		}
		return canMove;
		
	}
}
