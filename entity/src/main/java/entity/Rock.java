package entity;

public class Rock extends ActiveEntity implements IMovable{
	private boolean falling;
	public Rock(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}
	public void moveDown(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()+1);
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
	}
	@Override
	public int getFalling() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setFalling() {
		// TODO Auto-generated method stub
		
	}

}
