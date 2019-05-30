package controller;

import java.io.IOException;
import java.util.Random;

import contract.ControllerOrder;
import contract.IController;
import entity.ActiveEntity;
import entity.Board;
import entity.Bob;
import entity.Crystal;
import entity.Dirt;
import entity.Enemy;
import entity.Exit;
import entity.Level;
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
	 private static final int       timeLoop            = 300;
	
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
	
	private boolean testFront(ActiveEntity mob, final ControllerOrder controllerOrder) {
		ActiveEntity element = null;
		boolean canMove = false;
		for (ActiveEntity pawn : this.model.getLevel().getPawns()){
			switch (controllerOrder) {
			case UP:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY()-1) {
					element = pawn;
					canMove = true;
				}
			break;
			case DOWN:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY()+1) {
					element = pawn;
					canMove = true;
				}
			break;
			case RIGHT:
				if (pawn.getX() == mob.getX()+1 && pawn.getY() == mob.getY()) {
					element = pawn;
					canMove = true;
				}
			break;
			case LEFT:
				if (pawn.getX() == mob.getX()-1 && pawn.getY() == mob.getY()) {
					element = pawn;	
				}
			break;
			}
		}
		if (element instanceof Dirt && mob instanceof Bob) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
		}
		else if(element instanceof Crystal) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			((Bob) mob).addCrystal(crystal);
		}
		else if (element instanceof Wall || element instanceof Rock) {
			canMove = false;
		}
		else if (element instanceof Exit && ((Bob) mob).getCrystalCount() < crystal ) {
			canMove = false;
			
		}
		else if (element instanceof Exit && ((Bob) mob).getCrystalCount() >= crystal ) {
			canMove = true;
			this.view.win();
			System.exit(0);
		}
		
		else if (element instanceof Enemy) {
			canMove = true;
			this.view.lose();
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			bob.setImage(null);
			this.model.getLevel().popPawn(bob);
			System.exit(0);
		}
		
		else {
			canMove = true;
		}
		return canMove;
		
	}
    public final void move(ControllerOrder controllerOrder) throws InterruptedException {
    	final Random random = new Random();
    
        for (;;) {
        	
            for (final ActiveEntity pawn : this.model.getLevel().getPawns()) {
            	switch (random.nextInt()%4) {	
            	case 1:
            		
            		controllerOrder = ControllerOrder.UP;
    				((Enemy) pawn).moveUp(this.testFront(pawn, controllerOrder));
    			break;
    			case 2:
    				controllerOrder = ControllerOrder.DOWN;
    				((Enemy) pawn).moveDown(this.testFront(pawn, controllerOrder));
    			break;
    			case 3:
    				controllerOrder = ControllerOrder.RIGHT;
    				((Enemy) pawn).moveRight(this.testFront(pawn, controllerOrder));
    			break;
    			case 4:
    				controllerOrder = ControllerOrder.LEFT;
    				((Enemy) pawn).moveLeft(this.testFront(pawn, controllerOrder));
    			break;            	
            	}
            	}       
            model.note();
            Thread.sleep(timeLoop);
            }         
        }
    }



