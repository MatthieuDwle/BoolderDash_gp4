package controller;

import java.io.IOException;
import java.util.Random;

import contract.ControllerOrder;
import contract.IController;
import entity.ActiveEntity;
import entity.Bob;
import entity.Crystal;
import entity.Dirt;
import entity.Enemy;
import entity.Exit;
import entity.IMovable;
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
	
	private IMovable move;
	private int crystal = 15;
	private static final int       timeLoop            = 300;
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 * @throws InterruptedException 
	 */
	public Controller() throws InterruptedException {
		this.model = new Model();
		try {
			model.loadLevel(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.view = new View(model);
		this.view.startPopup(crystal);
		view.setController(this);
		this.move();
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
				}
			break;
			case DOWN:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY()+1) {
					element = pawn;
				}
			break;
			case RIGHT:
				if (pawn.getX() == mob.getX()+1 && pawn.getY() == mob.getY()) {
					element = pawn;
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
		else if (element instanceof Dirt && mob instanceof Enemy) {
			canMove = false;
		}
		else if(element instanceof Crystal && mob instanceof Bob) {
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
		
		else if (element instanceof Enemy || element instanceof Bob) {
			canMove = true;
			this.view.lose();
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			mob.setImage(null);
			this.model.getLevel().popPawn(mob);
			System.exit(0);
		}
		
		else {
			canMove = true;
		}
		return canMove;
		
	}

	public final void move() throws InterruptedException {
    	final Random random = new Random();
    	ControllerOrder controllerOrder;
        for (;;) {
            for (final ActiveEntity pawn : this.model.getLevel().getPawns()) {
            	if(pawn instanceof Enemy) {
	            		switch (random.nextInt()%4) {	
	            	case 0:
	            		controllerOrder = ControllerOrder.UP;
	    				((Enemy) pawn).moveUp(this.testFront(pawn, controllerOrder));
	    			break;
	    			case 1:
	    				controllerOrder = ControllerOrder.DOWN;
	    				((Enemy) pawn).moveDown(this.testFront(pawn, controllerOrder));
	    			break;
	    			case 2:
	    				controllerOrder = ControllerOrder.RIGHT;
	    				((Enemy) pawn).moveRight(this.testFront(pawn, controllerOrder));
	    			break;
	    			case 3:
	    				controllerOrder = ControllerOrder.LEFT;
	    				((Enemy) pawn).moveLeft(this.testFront(pawn, controllerOrder));
	    			break;            	
	            	}
            	}
            	else if (pawn instanceof Rock) {
            		controllerOrder = ControllerOrder.DOWN;
            		((Rock) pawn).moveDown(this.testDown(pawn, controllerOrder, "Rock"));
            	}
            	else if (pawn instanceof Crystal) {
            		controllerOrder = ControllerOrder.DOWN;
            		((Crystal) pawn).moveDown(this.testDown(pawn, controllerOrder, "Crystal"));
            	}
        	}       
            model.note();
            Thread.sleep(timeLoop);
        }         
 	}
	
	private boolean testDown(ActiveEntity mob, final ControllerOrder controllerOrder, String type) {
		boolean canMove = true;
		for (ActiveEntity pawn : this.model.getLevel().getPawns()){
			if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY()+1) {
				canMove = false;
			}
			
			switch (type) {
			case "Crystal":
				if (!(pawn instanceof Bob) && ((Crystal) mob).getFalling() > 0 && !canMove) {
					((Crystal) mob).razFalling();
				}
				
				if (pawn instanceof Bob &&((Crystal) mob).getFalling() > 0 && !canMove) {
					((Crystal) mob).razFalling();
					System.exit(0);
				}
			break;
			case "Rock":
				if (!(pawn instanceof Bob) && ((Rock) mob).getFalling() > 0 && !canMove) {
					System.out.println(((Rock) mob).getFalling());
					((Rock) mob).razFalling();
				}
				
				if (pawn instanceof Bob &&((Rock) mob).getFalling() > 0 && !canMove) {
					((Rock) mob).razFalling();
					System.exit(0);
				}
			break;
			}
		}
		return canMove;
	}
}



