package entity;

import java.util.ArrayList;

public class Level extends Entity{
	private Board board;
	private ArrayList<ActiveEntity> pawns;
	
	public Level () {
		board = new Board();
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	private void setBoard(Board board) {
		this.board = board;
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
	
}
