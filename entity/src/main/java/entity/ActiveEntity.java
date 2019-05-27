package entity;

import java.awt.Point;

import fr.exia.showboard.IPawn;

public class ActiveEntity extends GraphicEntity implements IPawn{
	
	private Point position;

	public ActiveEntity(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}

	public Point getPosition() {
		return this.position;
	}

	private void setPosition(Point position) {
		this.position = position;
	}
	
	 
	   public int getX() {
	        return this.getPosition().x;
	    }
	   public int getY() {
	        return this.getPosition().y;
	    }
}
