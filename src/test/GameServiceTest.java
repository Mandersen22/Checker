package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import game.GameService;
import game.IGameService;
import game.Pieces;

public class GameServiceTest {

	private boolean[][] movablePositions;
	private Pieces[][] piecePositions;
	private IGameService service;

	@Before
	public void createBoard() {
		
		// Set new GameService
		service = new GameService();
		
		// Static positions of game pieces.
		piecePositions = new Pieces[][] {
				{ Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE,
						Pieces.WHITE, },
				{ Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE,
						Pieces.NONE, },
				{ Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE,
						Pieces.WHITE, },
				{ Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE,
						Pieces.NONE, },
				{ Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE,
						Pieces.NONE, },
				{ Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK,
						Pieces.NONE, },
				{ Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE,
						Pieces.BLACK, },
				{ Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK,
						Pieces.NONE, }, };

		// Positions that is valid to have a game piece on.
		movablePositions = new boolean[][] { { false, true, false, true, false, true, false, true },
				{ true, false, true, false, true, false, true, false },
				{ false, true, false, true, false, true, false, true },
				{ true, false, true, false, true, false, true, false },
				{ false, true, false, true, false, true, false, true },
				{ true, false, true, false, true, false, true, false },
				{ false, true, false, true, false, true, false, true },
				{ true, false, true, false, true, false, true, false }, };
	}

	@Test
	public void testChangePlayerTurn() {	
		// Test that playerTurn switches from true to false
		boolean playerTurn = true;
		playerTurn = service.changePlayerTurn(playerTurn);
		assertTrue("Should change the player turn", playerTurn == false);
		
		// Test that playerTurn switches from false to true
		playerTurn = false;
		playerTurn = service.changePlayerTurn(playerTurn);
		assertTrue("Should change the player turn", playerTurn == true);
	}

	@Test
	public void testValidPosition() {
		// Test a valid position when the turn is player 1
		boolean validation = service.validPosition(piecePositions, movablePositions, true, 1, 2, 2, 3);
		assertTrue("This move should be valid for player 1", validation == true);
		
		// Test a invalid position when the turn is player 1
		validation = service.validPosition(piecePositions, movablePositions, true, 1, 2, 1, 3);
		assertTrue("This move should be valid for player 1", validation == false);
	}

	@Test
	public void testPieceOnCoordinate() {
		// Test that valid piece is found on coordinate when player 1
		boolean validation = service.pieceOnCoordinate(piecePositions, true, 1, 2);
		assertTrue("Should return true, as coordinates points on a player 1 piece", validation == true);
		
		// Test that coordinate to an empty field should return false
		validation = service.pieceOnCoordinate(piecePositions, true, 0, 0);
		assertTrue("Should return false, as no piece is found on given coordinates", validation == false);
		
		// Test that player 1 pieces shouldn't count in validation when turn is player 2
		validation = service.pieceOnCoordinate(piecePositions, false, 1, 2);
		assertTrue("Should return false, as coordinates points on player 1 piece", validation == false);
	}

}
