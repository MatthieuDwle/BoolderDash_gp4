package entity;

public class Crystal extends ActiveEntity implements IMovable{
	private int falling;
	public Crystal(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}
	public void moveDown(boolean test) {
		if (test == true) {
			this.setPosition(this.getX(), this.getY()+1);
			this.setFalling();
		}
	}
	public void razFalling() {
		this.falling = 0;
	}

	@Override
	public int getFalling() {
		// TODO Auto-generated method stub
		return this.falling;
	}
	@Override
	public void setFalling() {
		// TODO Auto-generated method stub
		this.falling++;
	}
}
