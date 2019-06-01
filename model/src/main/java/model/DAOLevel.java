package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.*;

public class DAOLevel extends DAOEntity<Level> {

	/**
	 *  Instantiate DAO Level 
	 *  
	 * @param connection
	 * @throws SQLException
	 */
	public DAOLevel(Connection connection) throws SQLException {
		super(connection);
	}

	/**
	 * Creates Level entity.
	 *
	 * @param entity
	 *          the entity
	 * @return boolean
	 */
	@Override
	public boolean create(Level entity) {
		//Not implemented
		return false;
	}

	/**
	 * Delete Level.
	 *
	 * @param entity
	 *          the entity
	 * @return boolean
	 */
	@Override
	public boolean delete(Level entity) {
		//Not implemented
		return false;
	}

	/**
	 * Update Level.
	 *
	 * @param entity
	 *          the entity
	 * @return boolean
	 */
	@Override
	public boolean update(Level entity) {
		//Not implemented
		return false;
	}
	
	/**
	 * Load level entity images 
	 * 
	 * * <h2>Explanation of how the method works.</h2>
     * <p>
     * A try to catch exceptions and set the height,width and Level from level number.
     * </p>
     *
     * <pre>
     * {@code
     *       try {
			Level level = null;
			final LVLProperties lvlProperties = new LVLProperties();
			ResultSet resultSetHeight = callPrepare("Height",lvlNb);
			ResultSet resultSetWidth = callPrepare("Width",lvlNb);
			ResultSet resultSetLevel = callPrepare("Level",lvlNb);
     * }
     * </pre>
     * <p>
     * Initialisation of the height and width of the kind of level
     * 
     * </p>
     *
     *
     * <pre>
     * {@code
     * if (resultSetHeight.first() && resultSetWidth.first()) {
	 *
	 *		    int width = resultSetWidth.getInt("NbColum")+2;
	 *			int height = resultSetHeight.getInt("NbLigne")+3;
	 *			level = new Level(width, height);      
     * }
     * </pre>
     * <p>
     * Instantiation of the background 
     * </p>
     *
     * <pre>
     * {@code
     *         	DigDirt fond = new DigDirt("Nothing.png");
	 *			fond.loadImage();
	 *			level.setBackground(fond);
	 *		    int x, y;
     * }
     * </pre>
     * <p>
     * To have wall on the border.
     * </p>
     *
     * <pre>
     * {@code
     *      if ((x == 0) || (x == (width - 1)) || (y == 0) || (y == (height - 1))) {
	 *						Wall wall = new Wall("Wall.png");
	 *						wall.loadImage();
	 *						wall.setPosition(x, y);
	 *						level.putPawn(wall);
	 *					}
     * }
     * </pre>
     * <p>
     * Browse data base 
     * </p>
     *
     * <pre>
     * {@code
     *  else {
	 *						resultSetLevel.next();
	 *						char Element = resultSetLevel.getString("Element").charAt(0);
	 *						int Ligne = resultSetLevel.getInt("Ligne");
	 *}
	 *
	 *
     * </pre>
     * <p>
     * Listen the key
     * </p>
     *
     * <pre>
     * {@code
     *     	this.boardFrame.addKeyListener(this);
     * }
     * </pre>
     *
     *
     *  </pre>
     * <p>
     * 
	 * Match the pattern to an image in the database
     * </p>
     *
     * <pre>
     * {@code
     *  		if (Element == lvlProperties.getWall()) {
	 *							Wall wall = new Wall("Wall.png");
	 *							wall.loadImage();
	 *							wall.setPosition(x, y);
	 *							level.putPawn(wall);
	 *						}
	 *						else if (Element == lvlProperties.getDirt()) {
	 *							Dirt dirt = new Dirt("Dirt.png");
	 *							dirt.loadImage();
	 *							dirt.setPosition(x, y);
	 *							level.putPawn(dirt);
	 *						}
	 *						else if (Element == lvlProperties.getBob()) {
	 *							Bob bob = new Bob("Bob1.png");
	 *							bob.loadImage();
	 *							bob.setPosition(x, y);
	 *							level.putPawn(bob);
	 *						}
	 *						else if (Element == lvlProperties.getCrystal()) {
	 *							Crystal crystal = new Crystal("Crystal.png");
	 *							crystal.loadImage();
	 *							crystal.setPosition(x, y);
	 *							level.putPawn(crystal);
	 *						}
	 *						else if (Element == lvlProperties.getEnemy()) {
	 *							Enemy enemy = new Enemy("Enemy1.png");
	 *							enemy.loadImage();
	 *							enemy.setPosition(x, y);
	 *							level.putPawn(enemy);
	 *						}
	 *						else if (Element == lvlProperties.getRock()) {
	 *							Rock rock = new Rock("Rock.png");
	 *							rock.loadImage();
	 *							rock.setPosition(x, y);
	 *							level.putPawn(rock);
	 *						}
	 *						else if (Element == lvlProperties.getExit()) {
	 *							Exit exit = new Exit("END1.png");
	 *							exit.loadImage();
	 *							exit.setPosition(x, y);
	 *							level.putPawn(exit);
	 *						}
     * </pre>
     * 
     * 
     *  </pre>
     * <p>
     * Nothing to do 
     * </p>
     *
     * <pre>
     * {@code
     *        else if (Element == lvlProperties.getGap()) {
	 *						
	 *					}
	 *					else {
	 *						System.out.println("Caractère inconnue");
     * }
     * 
     * 
     * </pre>
     * 
     * 
     *  </pre>
     * <p>
     * Return level at the end of try
     * </p>
     *
     * <pre>
     * {@code
     *        		return level;
	 *		} catch (final SQLException e) {
	 *			e.printStackTrace();
	 *		}
	 *		return null;
     * }
     *
     * 
	 * 
	 * @param lvlNb
	 * @return level
	 * @throws IOException
	 */
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
				level = new Level(width, height);
				
				//instantiation of the background
				
				DigDirt fond = new DigDirt("Nothing.png");
				fond.loadImage();
				level.setBackground(fond);
				
				int x, y;
				
				
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
							
							}
							else {
								System.out.println("Unknown Character");
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
	
	
	/**
	 * 
	 * Search in database the level
	 * 
	 * @param type
	 * @param lvlNb
	 * @return resultSet
	 */
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
