package entity;

import java.util.ArrayList;





public class Bob extends ActiveEntity implements IPop{
private int crystalCount = 10;

	public Bob(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}

	
	public void moveUp(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()-1);
		}
	}
	
	public void moveDown(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()+1);
		}
	}
	
	public void moveRight(boolean test) {
		if (test == true) {
			this.setPosition(this.getX()+1, this.getY());
		}
	}
	
	public void moveLeft(boolean test) {
		if (test == true) {
			this.setPosition(this.getX()-1, this.getY());
		}
	}
	
	public void pop() {
		// TODO Auto-generated method stub
	/*	Level.popPawn();*/
	}
	public void addCrystal() {
		
		this.crystalCount++;
		/*if(this.crystalCount != 10) {this.canWin = false;}*/
	
	}
}
