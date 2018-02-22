import java.util.InputMismatchException;
import java.util.Scanner;

public class GameService implements IGameService {

	private Scanner s;
	private boolean correctInput = false;

	public GameService() {
		super();

		s = new Scanner(System.in);
	}

	@Override
	public boolean changePlayerTurn(boolean turn) {
		if (turn)
			return false;
		else
			return true;
	}

	@Override
	public boolean validPosition(Pieces[][] p, boolean[][] m, boolean turn, int x, int y, int x2, int y2) {
		int allowedMove = Math.abs(y - y2);

		// Don't let player move piece to position, if it already
		if (p[y2][x2] != Pieces.NONE) {
			return false;
		}

		// If field is movable
		if (m[y2][x2]) {
			// If new position goes in the right direction for player 1 (downwards)
			if (turn == true && y2 > y && allowedMove == 1) {
				p[y][x] = Pieces.NONE;
				p[y2][x2] = Pieces.WHITE;
				return true;
			}
			// If new position goes in the right direction for player 2 (upwards)
			if (turn == false && y2 < y && allowedMove == 1) {
				p[y][x] = Pieces.NONE;
				p[y2][x2] = Pieces.BLACK;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean pieceOnCoordinate(Pieces[][] p, boolean turn, int x, int y) {
		if (turn == true && p[y][x] == Pieces.WHITE) {
			return true;
		} else if (turn == false && p[y][x] == Pieces.BLACK) {
			return true;
		} else {
			return false;
		}
	}

	public int getCoordinateInput_X(Pieces[][] piecePositions) {
		int coordinate = -1;
		correctInput = false;

		while (!correctInput) {
			try {
				System.out.print("Enter x coordinate of piece: ");
				coordinate = s.nextInt();

				if (coordinate <= piecePositions.length) {
					correctInput = true;
					return coordinate;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n");
				System.out.println("Wrong input receivied");
			}
		}

		return 0;
	}

	public int getCoordinateInput_Y(Pieces[][] piecePositions) {
		int coordinate = -1;
		correctInput = false;

		while (!correctInput) {
			try {
				System.out.print("Enter y coordinate of piece: ");
				coordinate = s.nextInt();

				if (coordinate <= piecePositions.length) {
					correctInput = true;
					return coordinate;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n");
				System.out.println("Wrong input receivied");
			}
		}

		return 0;
	}

	public int getNewCoordinateInput_X(Pieces[][] piecePositions) {
		int coordinate;

		System.out.print("\nEnter new x coordinate you want your piece moved to: ");

		coordinate = s.nextInt();

		if (coordinate <= piecePositions.length) {
			return coordinate;
		}
		return 0;
	}

	public int getNewCoordinateInput_Y(Pieces[][] piecePositions) {
		int coordinate;

		try {
			System.out.print("Enter new y coordinate you want your piece moved to: ");
			coordinate = s.nextInt();

			if (coordinate <= piecePositions.length) {
				return coordinate;
			}
		} catch (Exception e) {

		}
		return 0;
	}
}
