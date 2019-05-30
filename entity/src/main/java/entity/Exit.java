package entity;

public class Exit extends ActiveEntity {
	
private boolean canWin;

	
public Exit(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}

	public void unlock() {
		// TODO Auto-generated constructor stub
		this.canWin = true;
	}

}
