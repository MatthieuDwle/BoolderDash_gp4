package entity;

import java.util.ArrayList;





public class Bob extends ActiveEntity implements IPop{
private int crystalCount = 0;
public boolean End;

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
	

	public void addCrystal() {
		this.crystalCount++;
		System.out.println(crystalCount);
		if (this.crystalCount >= 5) {
			System.out.println("You Win escape now !");
			
		
		
			
	
		}
	
	}


/*	public void setCrystalCount(int crystalCount) {
		this.crystalCount = crystalCount;
	}
*/

	public int getCrystalCount() {
		return crystalCount;
	}
}
