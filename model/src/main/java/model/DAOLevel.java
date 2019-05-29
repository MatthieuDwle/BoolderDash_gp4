package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.*;

public class DAOLevel extends DAOEntity<Level> {

	public DAOLevel(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public boolean create(Level entity) {
		//Not implemented
		return false;
	}

	@Override
	public boolean delete(Level entity) {
		//Not implemented
		return false;
	}

	@Override
	public boolean update(Level entity) {
		//Not implemented
		return false;
	}
	
	public Level load(final int lvlNb) throws IOException {
		try {
			Level level = null;
			final LVLProperties lvlProperties = new LVLProperties();
			ResultSet resultSetHeight = callPrepare("Height",lvlNb);
			ResultSet resultSetWidth = callPrepare("Width",lvlNb);
			ResultSet resultSetLevel = callPrepare("Level",lvlNb);
			if (resultSetHeight.first() && resultSetWidth.first()) {
				
				int width = resultSetWidth.getInt("NbColum")+2;
				int height = resultSetHeight.getInt("NbLigne")+3;
				//instantiation of level
				level = new Level(width, height);
				
				//instantiation of the background
				
				DigDirt fond = new DigDirt("Nothing.png");
				fond.loadImage();
				level.setFond(fond);
				
				int x, y, previous = 0;
				
				
				for (y = 0; y < height; y++) {
					for (x = 0; x < width; x++) {
						if ((x == 0) || (x == (width - 1)) || (y == 0) || (y == (height - 1))) {
							Wall wall = new Wall("Wall.png");
							wall.loadImage();
							wall.setPosition(x, y);
							level.putPawn(wall);
						}
						else {
							resultSetLevel.next();
							char Element = resultSetLevel.getString("Element").charAt(0);
							int Ligne = resultSetLevel.getInt("Ligne");
							
							
							if (Element == lvlProperties.getWall()) {
								Wall wall = new Wall("Wall.png");
								wall.loadImage();
								wall.setPosition(x, y);
								level.putPawn(wall);
							}
							else if (Element == lvlProperties.getDirt()) {
								Dirt dirt = new Dirt("Dirt.png");
								dirt.loadImage();
								dirt.setPosition(x, y);
								level.putPawn(dirt);
							}
							else if (Element == lvlProperties.getBob()) {
								Bob bob = new Bob("Bob1.png");
								bob.loadImage();
								bob.setPosition(x, y);
								level.putPawn(bob);
							}
							else if (Element == lvlProperties.getCrystal()) {
								Crystal crystal = new Crystal("Crystal.png");
								crystal.loadImage();
								crystal.setPosition(x, y);
								level.putPawn(crystal);
							}
							else if (Element == lvlProperties.getEnemy()) {
								Enemy enemy = new Enemy("Enemy1.png");
								enemy.loadImage();
								enemy.setPosition(x, y);
								level.putPawn(enemy);
							}
							else if (Element == lvlProperties.getRock()) {
								Rock rock = new Rock("Rock.png");
								rock.loadImage();
								rock.setPosition(x, y);
								level.putPawn(rock);
							}
							else if (Element == lvlProperties.getExit()) {
								Exit exit = new Exit("END1.png");
								exit.loadImage();
								exit.setPosition(x, y);
								level.putPawn(exit);
							}
							else if (Element == lvlProperties.getGap()) {
								// There is nothing to do
							}
							else {
								System.out.println("Caractère inconnue");
							}
						}
					}
				}
			}
				return level;
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	private ResultSet callPrepare(String type, int lvlNb) {
		try {
			final String sql = "{call get" + type + "ByNb(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, lvlNb);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			return resultSet;
			
		}catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
