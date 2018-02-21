import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Board b;
	private Scanner s;
	private ArrayList<Player> p;
	private boolean playerTurn;

	private Scanner x, y;

	public Game() {
		super();

		b = new Board();
		s = new Scanner(System.in);
		p = new ArrayList<Player>();

		x = new Scanner(System.in);
		y = new Scanner(System.in);

		// Set start player to player 1
		playerTurn = true;
	}

	public void startGame() {

		// Load players
		getPlayerDetails();

		// Run game
		while (true) {
			b.drawBoard();
			loadTurn();
		}
	}

	public void loadTurn() {

		int x1 = -1;
		int y1 = -1;
		int x2 = -1;
		int y2 = -1;

		if (playerTurn)
			System.out.println("\n" + p.get(0).getPlayerName() + " its your turn");
		else
			System.out.println("\n" + p.get(1).getPlayerName() + " its your turn");

		System.out.println("Coordinate of piece to move");
		System.out.print("Enter x cordinate: ");
		x1 = x.nextInt();
		System.out.print("Enter y cordinate: ");
		y1 = y.nextInt();

		if (validPlayerCordinates(x1, y1)) {
			System.out.println("\nCoordinate of new position");
			System.out.print("Enter x cordinate: ");
			x2 = x.nextInt();
			System.out.print("Enter y cordinate: ");
			y2 = y.nextInt();

			if (positionValid(x1, y1, x2, y2)) {
				if (playerTurn)
					System.out.println("\nPlayer 1 moved piece to position: " + x2 + "," + y2 + "\n");
				else
					System.out.println("\nPlayer 2 moved piece to position: " + x2 + "," + y2 + "\n");

				// Change player when success turn is over
				changePlayerTurn();
				return;
			} else {
				System.out.println("\nThat move cannot be made because of game rules");
				loadTurn();
			}
		} else {
			System.out.println("\nNo piece found on selected cordinates, try again");
			loadTurn();
		}

	}
	
	public void changePlayerTurn() {
		if (playerTurn)
			playerTurn = false;
		else
			playerTurn = true;
	}

	public boolean positionValid(int x, int y, int x2, int y2) {

		int allowedMove = y - y2;

		// Don't let player move piece to position, if it already
		if (b.positions[y2][x2] != 0) {
			return false;
		}

		// If field is movable
		if (b.movableField[y2][x2]) {
			// If new position goes in the right direction for player 1 (downwards)
			if (playerTurn == true && y2 > y && (allowedMove == 1 || allowedMove == -1)) {
				b.positions[y][x] = 0;
				b.positions[y2][x2] = 1;
				return true;
			}
			// If new position goes in the right direction for player 2 (upwards)
			if (playerTurn == false && y2 < y && (allowedMove == 1 || allowedMove == -1)) {
				b.positions[y][x] = 0;
				b.positions[y2][x2] = 2;
				return true;
			}
		}
		return false;
	}

	public boolean validPlayerCordinates(int x, int y) {

		if (playerTurn == true && b.positions[y][x] == 1) {
			return true;
		} else if (playerTurn == false && b.positions[y][x] == 2) {
			return true;
		} else {
			return false;
		}
	}

	private void getPlayerDetails() {
		for (int i = 1; i < 3; i++) {
			System.out.print("Enter name of player " + i + ": ");
			String name = s.next();

			if (i == 1) {
				p.add(new Player(name, true));
				System.out.println(name + " is added as player 1\n");
			} else {
				p.add(new Player(name, false));
				System.out.println(name + " is added as player 2\n");
			}
		}
	}

}
