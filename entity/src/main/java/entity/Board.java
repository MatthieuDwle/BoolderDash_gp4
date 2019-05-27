package entity;

public class Board {
	private static int width; 
	private static int height;
	
	public Board(int widht, int height) {
		this.setWidth();
		this.setHeight();
	}
	
	public Board() {
		
	}
	
	public static int getWidth() {
		return width;
	}
	
	public void setWidth() {
		this.width = width;
	}
	
	public static int getHeight() {
		return height;
	}
	
	public void setHeight() {
		this.height = height;
	}
}
