import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Board board;
	private IGameService service;
	private ArrayList<Player> players;
	private boolean playerTurn;
	
	private Scanner s;
	private Scanner x, y;

	public Game() {
		super();

		board = new Board();
		players = new ArrayList<Player>();
		
		s = new Scanner(System.in);
		x = new Scanner(System.in);
		y = new Scanner(System.in);

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

	public void takeTurn() {
		int x1, y1, x2, y2 = -1;

		if (playerTurn)
			System.out.println("\n" + players.get(0).getPlayerName() + " its your turn");
		else
			System.out.println("\n" + players.get(1).getPlayerName() + " its your turn");

		System.out.println("Coordinate of piece to move");
		System.out.print("Enter x cordinate: ");
		x1 = x.nextInt();
		System.out.print("Enter y cordinate: ");
		y1 = y.nextInt();

		if (service.validPieceOnCoordinate(board.piecePositions, playerTurn, x1, y1)) {
			System.out.println("\nCoordinate of new position");
			System.out.print("Enter x cordinate: ");
			x2 = x.nextInt();
			System.out.print("Enter y cordinate: ");
			y2 = y.nextInt();

			if (service.validPosition(board.piecePositions, board.movablePositions, playerTurn, x1, y1, x2, y2)) {
				if (playerTurn)
					System.out.println("\nPlayer 1 moved piece to position: " + x2 + "," + y2 + "\n");
				else
					System.out.println("\nPlayer 2 moved piece to position: " + x2 + "," + y2 + "\n");

				// Change player when success turn is over
				playerTurn = service.changePlayerTurn(playerTurn);
				return;
			} else {
				System.out.println("\nThat move cannot be made because of game rules");
				takeTurn();
			}
		} else {
			System.out.println("\nNo piece found on selected cordinates, try again");
			takeTurn();
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
