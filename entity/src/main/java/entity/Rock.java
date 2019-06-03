package entity;

/**
 * The Class Rock.
 *
 * @author Kosbur
 */

public class Rock extends ActiveEntity implements IMovable{
	/**The falling*/
	private int falling;
	
	/**
	 * Instantiates a new Rock
	 * 
	 * @param imageName
	 * 			The image name 
	 */	
	public Rock(String imageName) {
		super(imageName);
	}
	
	/**
	 * Move Down for Rock
	 *  
	 * @param test
	 * 
	 * if it's true Rock move down
	 */
	public void moveDown(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()+1);
			this.setFalling();
		}
	}

	/**
	 * Reset the falling value
	 */
	public void resetFalling() {
		this.falling = 0;
	}

	/**
	 * Gets the Image Name.
	 *
	 * @return the ImageName
	 */
	public int getFalling() {
		return this.falling;
	}
	
	/**
	 * Sets the Image Name.
	 */
	public void setFalling() {
		this.falling++;
	}

}
