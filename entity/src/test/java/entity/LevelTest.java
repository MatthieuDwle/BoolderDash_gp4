package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LevelTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPutPawn() {
		ActiveEntity pawn = new ActiveEntity("Wall.png");
		Level level = new Level(0,0);
		level.putPawn(pawn);
		assertTrue("The level should be have 1 pawn", level.getPawns().size() == 1);
	}

	@Test
	public void testPopPawn() {
		ActiveEntity pawn = new ActiveEntity("Wall.png");
		Level level = new Level(0,0);
		level.putPawn(pawn);
		level.popPawn(pawn);
		assertTrue("The level should be have 0 pawn", level.getPawns().size() == 0);
	}
}
