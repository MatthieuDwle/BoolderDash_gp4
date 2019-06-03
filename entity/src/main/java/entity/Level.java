package entity;

import java.util.ArrayList;
/**
 * The class Level
 * @author asus
 *
 */
public class Level extends Entity{
	/**The Board*/
	private Board board;
	/** The Background*/
	private GraphicEntity background;
	/**The pawns*/
	private ArrayList<ActiveEntity> pawns;
	
	/**
	 * The instance of level
	 * @param width
	 * 			the Level
	 * @param height
	 * 			the Level
	 */
	public Level (final int width, final int height) {
		board = new Board(width, height);
		pawns = new ArrayList<ActiveEntity>();
	}
	
	/**
	 * Gets the Board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return this.board;
	}
	
	/**
	 * Gets the pawns.
	 * 
	 * @return pawns
	 */
	public ArrayList<ActiveEntity> getPawns(){
		return this.pawns;
	}
	
	/**
	 * putPawn add elements to the list pawns
	 * @param pawn
	 * 			the pawn to add
	 */
	public void putPawn(ActiveEntity pawn) {
		pawns.add(pawn);
	}
	
	/**
	 * PopPawn remove from the list pawns
	 * 
	 * @param pawn
	 * 			the pawn to remove
	 */
	public void popPawn(ActiveEntity pawn) {
		pawns.remove(pawn);
	}
	
	/** 
	 * Gets the background
	 * 
	 * @return fond
	 */
	public GraphicEntity getBackground() {
		return background;
	}
	
	/**
	 * Set the background
	 * 
	 * @param background
	 * 			 the background of the frame
	 */
	public void setBackground(GraphicEntity background) {
		this.background = background;
	}
}
