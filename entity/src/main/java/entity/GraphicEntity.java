	package entity;


import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.ISquare;

/**
 * The Class GraphicEntity.
 *
 * @author Kosbur
 */
public class GraphicEntity extends Entity implements ISquare{

	/**The image of the entity */	
private Image image ;
	/**The Image Name */
private String imageName;

	 /**
     * Instantiates a new Graphic Entity.
     *
     * @param imageName
     *            the image name
     */
	public GraphicEntity(String imageName) {
		  this.setImageName(imageName);
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImage() {
		 return this.image;
	}

	/**
	 * Gets the Image Name.
	 *
	 * @return the ImageName
	 */
	private String getImageName() {
		return imageName;
	}
	
	/**
	 * Sets the Image Name.
	 *
	 * @param imageName
	 *          the new imageName
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * Sets the Image.
	 *
	 * @param image
	 *          the new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * The load Image with his path
	 * 
	 * @throws IOException
	 * 			the throws exception
	 */			
	public void loadImage() throws IOException {
		 this.setImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/" + this.getImageName())));
		
	}
	
}
