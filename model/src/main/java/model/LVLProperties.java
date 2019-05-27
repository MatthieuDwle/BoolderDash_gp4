package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LVLProperties extends Properties{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7399585872466234911L;
	private static final String PROPERTIES_FILE_NAME = "model.properties";
	private char bob;
	private char wall;
	private char enemy;
	private char rock;
	private char crystal;
	private char dirt;
	private char gap;
	private char exit;
	public LVLProperties () {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
		
		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setBob(this.getProperty("bob").charAt(0));
			this.setWall(this.getProperty("wall").charAt(0));
			this.setEnemy(this.getProperty("enemy").charAt(0));
			this.setRock(this.getProperty("rock").charAt(0));
			this.setCrystal(this.getProperty("crystal").charAt(0));
			this.setDirt(this.getProperty("dirt").charAt(0));
			this.setGap(this.getProperty("gap").charAt(0));
			this.setExit(this.getProperty("exit").charAt(0));
		}
	}
	
	/**
	 * @return the bob
	 */
	
	public char getBob() {
		return this.bob;
	}

	/**
	 * @param bob the bob to set
	 */
	public void setBob(char bob) {
		this.bob = bob;
	}
	
	/**
	 * @return the wall
	 */
	public char getWall() {
		return this.wall;
	}

	/**
	 * @param wall the wall to set
	 */
	
	public void setWall(char wall) {
		this.wall = wall;
	}
	
	/**
	 * @return the enemy
	 */
	
	public char getEnemy() {
		return this.enemy;
	}
	
	/**
	 * @param enemy the enemy to set
	 */
	
	public void setEnemy(char enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * @return the rock
	 */
	
	public char getRock() {
		return this.rock;
	}
	
	/**
	 * @param rock the rock to set
	 */
	
	public void setRock(char rock) {
		this.rock = rock;
	}
	
	/**
	 * @return the crystal
	 */
	
	public char getCrystal() {
		return this.crystal;
	}
	
	/**
	 * @param crystal the crystal to set
	 */
	
	public void setCrystal(char crystal) {
		this.crystal = crystal;
	}
	
	/**
	 * @return the dirt
	 */
	
	public char getDirt() {
		return this.dirt;
	}
	
	/**
	 * @param dirt the dirt to set
	 */
	
	public void setDirt(char dirt) {
		this.dirt = dirt;
	}

	/**
	 * @return the gap
	 */
	
	public char getGap() {
		return this.gap;
	}

	/**
	 * @param gap the gap to set
	 */
	
	public void setGap(char gap) {
		this.gap = gap;
	}

	/**
	 * @return the exit
	 */
	
	public char getExit() {
		return this.exit;
	}

	/**
	 * @param exit the exit to set
	 */
	
	public void setExit(char exit) {
		this.exit = exit;
	}
	
	
}
