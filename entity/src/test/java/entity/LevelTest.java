package entity;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * The class LevelTest
 * @author asus
 *
 */
public class LevelTest {
	
	/**
	 * 
	 *Testing of PutPawn add 1 pawn 
	 *
	 */
	@Test
	public void testPutPawn() {
		ActiveEntity pawn = new ActiveEntity("Wall.png");
		Level level = new Level(0,0);
		level.putPawn(pawn);
		assertTrue("The level should be have 1 pawn", level.getPawns().size() == 1);
	}

	/**
	 * Testing of PopPawn if he remove a pawn
	 * 
	 */
	@Test
	public void testPopPawn() {
		ActiveEntity pawn = new ActiveEntity("Wall.png");
		Level level = new Level(0,0);
		level.putPawn(pawn);
		level.popPawn(pawn);
		assertTrue("The level should be have 0 pawn", level.getPawns().size() == 0);
	}
}
