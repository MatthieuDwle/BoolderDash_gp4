package entity;

/**
 * The Class Board.
 *
 * @author Kosbur
 */
public class Board {
	/**The width of the board */
	private int width; 
	/**The height of the board*/
	private int height;
	
	/**
	 *  Instantiate width and height
	 * @param width
	 * @param height
	 */
	public Board(final int width, final int height) {
		this.setWidth(width);
		this.setHeight(height);
	}
	
	/**
	 * Gets the width
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Set the width
	 * 
	 * @param width the new width
	 */
	public void setWidth(final int width) {
		this.width = width; 
	}
	
	
	/**
	 * Gets the Height
	 * 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the Height
	 * 
	 * @param height the new height
	 */
	public void setHeight(final int height) {
		this.height = height;
	}
	
}
