package entity;

import java.util.ArrayList;



public class Bob extends ActiveEntity implements IPop,IMovable{
private int crystalCount = 10;

private static final int       imageBobNumber = 2;

	public Bob(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}

	public void move(int direction) {
	/*
		switch(direction) {
		//RIGHT
		case 1:
			if (this.getPosition().x != level.getBoard().getWidth()) {
			
			 for (int i = 1; i <= imageBobNumber; i++) {
			final Bob bob = new Bob("BobRight" + ((i % imageBobNumber) + ".png"));
            bob.loadImage();
            bob.getPosition().x++;
          
			  }
			 }
		break;
		//LEFT
		case 2:
			if (this.getPosition().x != Level.width - 1) {
			this.getPosition().x--;
			}
		break;
		//UP
		case 3:
			  if (this.getPosition().y != Board.height){
			this.getPosition().y++;
			  }
		break;
		//DOWN
		case 4:
			 if (this.getPosition().y != Board.height - 1){
			this.getPosition().y--;
			 }
		break;
		}
*/
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
