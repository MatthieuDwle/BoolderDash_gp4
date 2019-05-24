package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.exia.showboard.ISquare;

public class GraphicEntity extends Entity implements ISquare{
	
private Image image ;
private String imageName;
	
	public GraphicEntity(String imageName) {
		// TODO Auto-generated constructor stub
		  this.setImageName(imageName);
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		 return this.image;
	}

	private String getImageName() {
		return imageName;
	}

	private void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void loadImage() throws IOException {
		 this.setImage(ImageIO.read(new File("images/" + this.getImageName())));
		
	}
	
}
