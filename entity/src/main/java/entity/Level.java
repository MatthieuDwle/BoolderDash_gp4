package entity;

import java.util.ArrayList;

public class Level extends Entity{
	private Board board;
	private GraphicEntity fond;
	private ArrayList<ActiveEntity> pawns;
	
	public Level (final int width, final int height) {
		board = new Board(width, height);
	}
	public Level() {
		this(0,0);
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public ArrayList<ActiveEntity> getPawns(){
		return this.pawns;
	}
	
	public void putPawn(ActiveEntity pawn) {
		pawns.add(pawn);
	}
	
	public void popPawn(ActiveEntity pawn) {
		pawns.remove(pawn);
	}
	public GraphicEntity getFond() {
		return fond;
	}
	public void setFond(GraphicEntity fond) {
		this.fond = fond;
	}
}
