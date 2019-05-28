package entity;

import java.awt.Point;

import showboard.IPawn;
/**
 * The Class View.
 *
 * @author Kosbur
 */
public class ActiveEntity extends GraphicEntity implements IPawn{
	/** The position. */
	private Point position;

	/**
     * Instantiates a new ActiveEntity.
     *
     * @param imageName
     *            the image name
     */
	public ActiveEntity(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}
	/**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
	public Point getPosition() {
		return this.position;
	}
	  /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
	private void setPosition(Point position) {
		this.position = position;
	}
	 /**
     * Sets the position.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     */
	  public final void setPosition(final int x, final int y) {
	        this.position = new Point(x, y);
	    }
	  /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getX()
     */
    @Override
	   public int getX() {
	        return this.getPosition().x;
	    }
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getY()
     */
    @Override
	   public int getY() {
	        return this.getPosition().y;
	    }
}
