package controller;

import java.io.IOException;
import java.util.Random;

import contract.*;
import entity.*;


/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;
	/** The model. */
	private IModel model;
	/** The number of crystal goal. */
	private int crystal;
	/** The time of refresh all entity. */
	private static final int timeLoop = 300;
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 * @param model
	 * @throws InterruptedException				
	 */
	public Controller(final IModel model, final IView view, final int crystal) throws InterruptedException {
		this.setCrystal(crystal);
		this.model = model;
		this.view = view;
		view.setController(this);
		this.move();
	}
	private void setCrystal(final int crystal) {
		this.crystal = crystal;
	}
	/**
	 * Order perform.
	 *
	 * @param controllerOrder 
	 * 
	 * Translated the key pressed in movement of Bob and change Bob image in terms of his direction.
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
			((Bob) bob).setImageName("BobUp1.png");
			try {
				((Bob) bob).loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			((Bob) bob).moveUp(this.testFront(bob, controllerOrder));
			break;
		case DOWN:
			((Bob) bob).setImageName("BobDown1.png");
			try {
				((Bob) bob).loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			((Bob) bob).moveDown(this.testFront(bob, controllerOrder));
			break;
		case RIGHT:
			((Bob) bob).setImageName("BobRight1.png");
			try {
				((Bob) bob).loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			((Bob) bob).moveRight(this.testFront(bob, controllerOrder));
			break;
		case LEFT:
			((Bob) bob).setImageName("BobLeft1.png");
			try {
				((Bob) bob).loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			((Bob) bob).moveLeft(this.testFront(bob, controllerOrder));
			break;
		}
		model.note();
	}

	/**
	 * 
	 * @param mob
	 * @param controllerOrder
	 * @return canMove
	 * 
	 * 
	 * <p> 
	 * 		Test in front of Bob in terms of the Bob direction. 
	 * </p>
	 * <pre>
	 * {@code
	 * 		for (ActiveEntity pawn : this.model.getLevel().getPawns()) {
			switch (controllerOrder) {
			case UP:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY() - 1) {
					element = pawn;
				}
				break;
			case DOWN:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY() + 1) {
					element = pawn;
				}
				break;
			case RIGHT:
				if (pawn.getX() == mob.getX() + 1 && pawn.getY() == mob.getY()) {
					element = pawn;
				}
				break;
			case LEFT:
				if (pawn.getX() == mob.getX() - 1 && pawn.getY() == mob.getY()) {
					element = pawn;
				}
				break;
			}
		}
	 * }
	 * </pre>
	 * <p>
	 * 		Test if is dirt in front of Bob. Then Bod destroy the dirt.
	 * </p>
	 * <pre>
	 * {@code
	 * 		if (element instanceof Dirt && mob instanceof Bob) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
		}
	 * }
	 * </pre>
	 * <p>
	 * 		Test if is dirt in front of Enemies. Then they are blocked.
	 * </p>
	 * <pre>
	 * {@code 
	 * 		else if (element instanceof Dirt && mob instanceof Enemy) {
			canMove = false;
			
	 * 		}
	 * }
	 * </pre>
	 * <p>
	 * 		Test if is Crystal in front of Bob. Then Bob take it.
	 * </p>
	 * <pre>
	 * {@code
	 * 		else if (element instanceof Crystal && mob instanceof Bob) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			((Bob) mob).addCrystal(crystal);
			}
	 * }
	 * </pre>
	 * <p>
	 * 		Don't allow anyone to cross Wall or Rock
	 * </p>
	 * <pre>
	 * {@code
	 * 		else if (element instanceof Wall || element instanceof Rock) {
			canMove = false;
			}
	 * }
	 * </pre>
	 * <p>
	 * 		Test if is the Exit in front of Bob and doesn't have enough crystal. Then he can't pass.
	 * </p>
	 * <pre>
	 * {@code
	 * 		else if (element instanceof Exit && ((Bob) mob).getCrystalCount() < crystal) {
			canMove = false;

			}
	 * }
	 * </pre>
	 * <p>
	 * 		Test if is the Exit in front of Bob and has enough crystal. Then he can't pass.
	 * </p>
	 * <pre>
	 * {@code
	 * 		else if (element instanceof Exit && ((Bob) mob).getCrystalCount() >= crystal) {
			canMove = true;
			this.view.win();
			System.exit(0);
			}
	 * }
	 * </pre>
	 */
	private boolean testFront(ActiveEntity mob, final ControllerOrder controllerOrder) {
		ActiveEntity element = null;
		boolean canMove = false;
		for (ActiveEntity pawn : this.model.getLevel().getPawns()) {
			switch (controllerOrder) {
			case UP:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY() - 1) {
					element = pawn;
				}
				break;
			case DOWN:
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY() + 1) {
					element = pawn;
				}
				break;
			case RIGHT:
				if (pawn.getX() == mob.getX() + 1 && pawn.getY() == mob.getY()) {
					element = pawn;
				}
				break;
			case LEFT:
				if (pawn.getX() == mob.getX() - 1 && pawn.getY() == mob.getY()) {
					element = pawn;
				}
				break;
			}
		}
		if (element instanceof Dirt && mob instanceof Bob) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
		} else if (element instanceof Dirt && mob instanceof Enemy) {
			canMove = false;
		} else if (element instanceof Crystal && mob instanceof Bob) {
			canMove = true;
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			((Bob) mob).addCrystal(crystal);
		} else if (element instanceof Wall || element instanceof Rock) {
			canMove = false;
		}
		else if ((element instanceof Enemy && mob instanceof Bob) || (element instanceof Bob && mob instanceof Enemy)) {
			canMove = true;
			this.view.lose();
			element.setImage(null);
			this.model.getLevel().popPawn(element);
			mob.setImage(null);
			this.model.getLevel().popPawn(mob);
			System.exit(0);
		}
		else if ((element instanceof Enemy && mob instanceof Enemy) || (element instanceof Crystal && mob instanceof Enemy)) {
			canMove = false;
		}
		else if ((element instanceof Exit && mob instanceof Enemy)) {
			canMove = false;
		}
		else if ((element instanceof Exit && mob instanceof Bob) && ((Bob) mob).getCrystalCount() >= crystal) {
			if ( ((Bob) mob).getCrystalCount() < crystal) {
				canMove = false;
			}
			else {
				canMove = true;
				this.view.win();
				element.setImage(null);
				this.model.getLevel().popPawn(element);
				mob.setImage(null);
				this.model.getLevel().popPawn(mob);
				System.exit(0);
			}
		}
		else {
			canMove = true;
		}
		return canMove;

	}
	
	/**
	 * @throws InterruptedException
	 * 
	 * <p>
	 * 		Infinite loop for
	 * </p>
	 * <pre>
	 * {@code
	 * 		for (;;) {
	 * 		}
	 * }
	 * </pre>
	 * <p>
	 * 		Browse all array list
	 * </p>
	 * <pre>
	 * {@code 
	 * 		for (final ActiveEntity pawn : this.model.getLevel().getPawns()) {	
			}
	 * }
	 * </pre>
	 * <p>
	 * 		Move enemies randomly 
	 * </p>
	 * <pre>
	 * {@code
	 * 		if (pawn instanceof Enemy) {
					switch (random.nextInt() % 4) {
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
	 * }
	 * </pre>
	 * <p>
	 * 		Test if a Crystal or a Rock and they fall if they can. 
	 * </p>
	 * <pre>
	 * {@code 
	 * 		else if (pawn instanceof Rock) {
					controllerOrder = ControllerOrder.DOWN;
					((Rock) pawn).moveDown(this.testDown(pawn, controllerOrder, "Rock"));
				} else if (pawn instanceof Crystal) {
					controllerOrder = ControllerOrder.DOWN;
					((Crystal) pawn).moveDown(this.testDown(pawn, controllerOrder, "Crystal"));
			}
	 * } 
	 * </pre>
	 * <p>
	 * 		Run note method and make pause in the loop.
	 * </p>
	 * <pre>
	 * {@code 
	 * 		model.note();
			Thread.sleep(timeLoop);
	 * }
	 * </pre>  
	 */
	public final void move() throws InterruptedException {
		final Random random = new Random();
		ControllerOrder controllerOrder;
		for (;;) {
			for (final ActiveEntity pawn : this.model.getLevel().getPawns()) {
				if (pawn instanceof Enemy) {
					switch (random.nextInt() % 4) {
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
				} else if (pawn instanceof Rock) {
					controllerOrder = ControllerOrder.DOWN;
					((Rock) pawn).moveDown(this.testDown(pawn, controllerOrder, "Rock"));
				} else if (pawn instanceof Crystal) {
					controllerOrder = ControllerOrder.DOWN;
					((Crystal) pawn).moveDown(this.testDown(pawn, controllerOrder, "Crystal"));
				}
			}
			model.note();
			Thread.sleep(timeLoop);
		}
	}

	/**
	 * 
	 * @param mob
	 * @param controllerOrder
	 * @param type
	 * @return canMove
	 * 
	 * <p>
	 * 		Browse all entity in the array-list and test they can fall.
	 * </p>
	 * <pre>
	 * {@code 
	 * 		for (ActiveEntity pawn : this.model.getLevel().getPawns()) {
				if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY() + 1) {
					canMove = false;
				}
			}
		}
	 * }
	 * </pre>
	 * <p>
	 * 		Select if is a Rock or a Crystal. 
	 * </p>
	 * <pre>
	 * {@code 
	 * 		switch (type) {
			case "Crystal":
			
				break;
			case "Rock":
			
				break;
			}
	 * } 
	 * </pre>
	 * <p>
	 * 		reset falling count if they can't fall (reset when they stop falling)
	 * </p>
	 * <pre>
	 * {@code 
	 * 		if (!(pawn instanceof Bob) && ((Crystal) mob).getFalling() > 0 && !canMove) {
					((Crystal) mob).resetFalling();
			}
			
	 * }
	 * {@code 
	 * 		if (!(pawn instanceof Bob) && ((Rock) mob).getFalling() > 0 && !canMove) {
					((Rock) mob).resetFalling();
			}
	 * }
	 * </pre>
	 * <p>
	 * 		Kill Bod if is under them
	 * </p>
	 * <pre>
	 * {@code
	 * 		if (pawn instanceof Bob && ((Crystal) mob).getFalling() > 0 && !canMove) {
					((Crystal) mob).resetFalling();
					this.view.lose();
					mob.setImage(null);
					this.model.getLevel().popPawn(mob);
					System.exit(0);
			}
	 * }
	 * {@code
	 * 		if (pawn instanceof Bob && ((Rock) mob).getFalling() > 0 && !canMove) {
					((Rock) mob).resetFalling();
					this.view.lose();
					mob.setImage(null);
					this.model.getLevel().popPawn(mob);
					System.exit(0);
			}
	 * }
	 * </pre> 
	 */
	private boolean testDown(ActiveEntity mob, final ControllerOrder controllerOrder, String type) {
		boolean canMove = true;
		for (ActiveEntity pawn : this.model.getLevel().getPawns()) {
			if (pawn.getX() == mob.getX() && pawn.getY() == mob.getY() + 1) {
				canMove = false;
			}

			switch (type) {
			case "Crystal":
				if (!(pawn instanceof Bob
						) && ((Crystal) mob).getFalling() > 0 && !canMove) {
					((Crystal) mob).resetFalling();
				}

				if (pawn instanceof Bob && ((Crystal) mob).getFalling() > 0 && !canMove) {
					((Crystal) mob).resetFalling();
					this.view.lose();
					mob.setImage(null);
					this.model.getLevel().popPawn(mob);
					System.exit(0);
				}
				break;
			case "Rock":
				if (!(pawn instanceof Bob) && ((Rock) mob).getFalling() > 0 && !canMove) {
					((Rock) mob).resetFalling();
				}

				if (pawn instanceof Bob && ((Rock) mob).getFalling() > 0 && !canMove) {
					((Rock) mob).resetFalling();
					this.view.lose();
					mob.setImage(null);
					this.model.getLevel().popPawn(mob);
					System.exit(0);
				}
				break;
			}
		}
		return canMove;
	}
}
