package entity;



import javax.swing.JOptionPane;

/**
 * The Class Bob.
 *
 * @author Kosbur
 */



public class Bob extends ActiveEntity{
	
	/** The crystal Count to 0*/
private int crystalCount = 0;

/**
 * Instantiates a new Bob.
 *
 * @param imageName
 *            the image name
 */
	public Bob(String imageName) {
		super(imageName);
	}

	/**
	 * Move up for playable personnage
	 * @param test
	 * if it's true move Bob to up  
	 */
	public void moveUp(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()-1);
		}
	}
	
	/**
	 * Move Down for playable personnage
	 * @param test
	 * if it's true move Bob to Down 
	 */
	public void moveDown(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()+1);
		}
	}
	
	/**
	 * Move Right for playable personnage
	 * @param test
	 * if it's true move Bob to Right 
	 */
	public void moveRight(boolean test) {
		if (test == true) {
			this.setPosition(this.getX()+1, this.getY());
		}
	}
	
	/**
	 * Move Left for playable personnage
	 * @param test
	 * if it's true move Bob to Left  
	 */
	public void moveLeft(boolean test) {
		if (test == true) {
			this.setPosition(this.getX()-1, this.getY());
		}
	}
	
	/**
 	* Increment the Crystal Count
 	* @param crystal
 	* Count the number of crystal for win the game 
 	*/
	public void addCrystal(int crystal) {
		this.crystalCount++;
		if (this.crystalCount == crystal) {
			JOptionPane.showMessageDialog(null, "YOU HAVE ENOUGH CRYSTALS");
		}
	
	}

	/**
	 * Gets the width
	 * 
	 * @return width
	 */
	public int getCrystalCount() {
		return crystalCount;
	}
}
