package entity;


/**
 * The Class Enemy.
 *
 * @author Kosbur
 */
public class Enemy extends ActiveEntity{

	/**
	 * Instantiates a new Enemy
	 * 
	 * @param imageName
	 * 			The image name 
	 */		
	
	public Enemy(String imageName) {
		super(imageName);
	}

	/**
	 * Move up for enemy movements
	 * @param test
	 * if it's true Enemy go up 
	 */
		public void moveUp(boolean test) {
			if (test == true) {
				this.setPosition(this.getX(), this.getY()-1);
			}
		}
		/**
		 * Move Down for enemy movements
		 * @param test
		 * if it's true Enemy go Down 
		 */
		public void moveDown(boolean test) {
			if (test == true) {
				this.setPosition(this.getX(), this.getY()+1);
			}
		}
		
		/**
		 * Move Right for enemy movements
		 * @param test
		 * if it's true Enemy go Right 
		 */
		public void moveRight(boolean test) {
			if (test == true) {
				this.setPosition(this.getX()+1, this.getY());
			}
		}
		
		/**
		 * Move Left for enemy movements
		 * @param test
		 * if it's true Enemy go left 
		 */
		public void moveLeft(boolean test) {
			if (test == true) {
				this.setPosition(this.getX()-1, this.getY());
			}
		}	
}
