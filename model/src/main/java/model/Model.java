package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Level;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	/** The Level. */
private Level level ;

	/**
	 * 
	 * @param levelNumber
	 * 			the level number
	 */
	public Model(int levelNumber) {
		try {
			this.loadLevel(levelNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the level.
     *
     * @return the level
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getLevel()
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
     * Sets the level.
     *
     * @param level
     *            the new level
     */
	private void setLevel(Level level) {
		this.level = level;
		this.note();
	}

	/**
     * Load level.
     *
     * @param levelNumber
     *            the levelNumber
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getLevel(java.lang.String)
	 */
	public void loadLevel (int levelNumber) throws IOException{
		try {
			final DAOLevel daoLevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setLevel(daoLevel.load(levelNumber));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	/**
	 * The Observer method
	 */
	@Override
	public void note() {
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers();
	}
	
}
