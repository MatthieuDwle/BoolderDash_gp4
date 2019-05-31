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
		// TODO Auto-generated constructor stub
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
	 * Instantiate resetFalling
	 * 
	 * @param falling to 0
	 */
	public void resetFalling() {
		this.falling = 0;
	}

	/**
	 * Gets the Image Name.
	 *
	 * @return the ImageName
	 */
	@Override
	public int getFalling() {
		// TODO Auto-generated method stub
		return this.falling;
	}
	
	/**
	 * Sets the Image Name.
	 *
	 * @param imageName
	 *          the new imageName
	 */
	@Override
	public void setFalling() {
		// TODO Auto-generated method stub
		this.falling++;
	}

}
