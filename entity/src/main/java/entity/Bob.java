package entity;

import fr.exia.showboard.IPawn;

public class Bob extends ActiveEntity implements IPawn,IPop,IMovable{
private int crystalCount = 10;

	public Bob(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}

	public void move(int direction) {
		
		switch(direction) {
		//RIGHT
		case 1:
			if (this.getPosition().x != Board.width {
			this.getPosition().x++;
			 }
		break;
		//LEFT
		case 2:
			if (this.getPosition().x != Board.getWidth() - 1) {
			this.getPosition().x--;
			}
		break;
		//UP
		case 3:
			  if (this.getPosition().y != Board.getHeight()){
			this.getPosition().y++;
			  }
		break;
		//DOWN
		case 4:
			 if (this.getPosition().y != Board.getHeight() - 1){
			this.getPosition().y--;
			 }
		break;
		}
		
	}
	
	public void pop() {
		// TODO Auto-generated method stub
		
	}
	public void addCrystal() {
		
		this.crystalCount++;
		/*if(this.crystalCount != 10) {this.canWin = false;}*/
		
	
	}

}
