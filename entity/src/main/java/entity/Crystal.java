package entity;

/**
 * The Class Crystal.
 *
 * @author Kosbur
 */
public class Crystal extends ActiveEntity implements IMovable{
	/**The Falling*/
	private int falling;
	
	 /**
     * Instantiates a new Crystal.
     *
     * @param imageName
     *            the image name
     */
	public Crystal(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Move Down for crystal
	 * @param test
	 * if it's true crystal move down
	 */
	public void moveDown(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()+1);
			this.setFalling();
		}
	}
	
	
	/**
	 * Sets the Falling
	 * 
	 * @param falling the new falling
	 */
	public void razFalling() {
		this.falling = 0;
	}

	/**
	 * Gets the Falling
	 * 
	 * @return falling
	 */
	@Override
	public int getFalling() {
		// TODO Auto-generated method stub
		return this.falling;
	}
	
	/**
	 * Sets the Falling
	 * 
	 * @param falling increment
	 */
	@Override
	public void setFalling() {
		// TODO Auto-generated method stub
		this.falling++;
	}
}
