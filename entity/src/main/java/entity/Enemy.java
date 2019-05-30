package entity;

import java.util.Random;

public class Enemy extends ActiveEntity implements IPop,IMovable{

	
	public Enemy(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}


		@Override
		public void pop() {
			// TODO Auto-generated method stub
		
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


		@Override
		public void move() {
			// TODO Auto-generated method stub
			
		}


	
	
}
