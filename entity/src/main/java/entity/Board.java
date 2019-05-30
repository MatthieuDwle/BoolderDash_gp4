package entity;

public class Board {
	private int width; 
	private int height;
	
	public Board(final int width, final int height) {
		this.setWidth(width);
		this.setHeight(height);
	}
	
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(final int width) {
		this.width = width; 
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(final int height) {
		this.height = height;
	}
	
}
