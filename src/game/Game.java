package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Board board;
	private IGameService service;
	private ArrayList<Player> players;
	private boolean playerTurn;
	private int x1, y1, x2, y2 = -1;
	private boolean validCoordinates = false;
	private boolean validNewCoordinates = false;

	private Scanner s;

	public Game() {
		super();

		board = new Board();
		players = new ArrayList<Player>();

		s = new Scanner(System.in);

		// Set start player to player 1
		playerTurn = true;

		// Initialise helper service
		service = new GameService();
	}

	public void startGame() {

		// Load players
		getPlayerDetails();

		// Run game
		while (true) {
			board.drawBoard();
			takeTurn();
		}
	}

	private void takeTurn() {
		
		validCoordinates = false;
		validNewCoordinates = false;
		
		if (playerTurn)
			System.out.println("\n" + players.get(0).getPlayerName() + " its your turn");
		else
			System.out.println("\n" + players.get(1).getPlayerName() + " its your turn");

		// Get first set of coordinates
		while (!validCoordinates) {
			x1 = service.getCoordinateInput_X(board.piecePositions);
			y1 = service.getCoordinateInput_Y(board.piecePositions);

			if (service.pieceOnCoordinate(board.piecePositions, playerTurn, x1, y1)) {
				validCoordinates = true;
			} else {
				System.out.println("\nCoordinates are not valid, try again\n");
			}
		}

		// Get new set of coordinates
		while (!validNewCoordinates) {
			x2 = service.getNewCoordinateInput_X(board.piecePositions);
			y2 = service.getNewCoordinateInput_Y(board.piecePositions);

			if (service.validPosition(board.piecePositions, board.movablePositions, playerTurn, x1, y1, x2, y2)) {
				System.out.println("\nPiece has been moved to position: " + x2 + "," + y2 + "\n");
				playerTurn = service.changePlayerTurn(playerTurn);
				validNewCoordinates = true;
				return;
			} else {
				System.out.println("\nThat move cannot be made because of game rules");
				takeTurn();
			}
		}
	}

	private void getPlayerDetails() {
		for (int i = 1; i < 3; i++) {
			System.out.print("Enter name of player " + i + ": ");
			String name = s.next();

			if (i == 1) {
				players.add(new Player(name, true));
				System.out.println(name + " is added as player 1\n");
			} else {
				players.add(new Player(name, false));
				System.out.println(name + " is added as player 2\n");
			}
		}
	}

}
