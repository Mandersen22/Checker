package game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameService implements IGameService {

	private boolean correctInput = false;

	public GameService() {
		super();
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

	@Override
	public int getCoordinateInput_X(Pieces[][] piecePositions) {
		correctInput = false;

		while (!correctInput) {
			int input;
			Scanner scan = new Scanner(System.in);

			try {
				System.out.print("Enter x coordinate of piece: ");
				input = scan.nextInt();

				if (input <= piecePositions.length) {
					correctInput = true;
					return input;
				}
				else if (input < piecePositions.length - piecePositions.length || input > piecePositions.length) {
					System.out.println("\nWrong coordinate entered, must be within 0-8\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nWrong input receivied\n");
			} catch (Exception e1) {
				System.out.println("\nError happened\n");
			}
		}
		return -1;
	}

	@Override
	public int getCoordinateInput_Y(Pieces[][] piecePositions) {
		correctInput = false;

		while (!correctInput) {
			int input;
			Scanner scan = new Scanner(System.in);

			try {
				System.out.print("Enter y coordinate of piece: ");
				input = scan.nextInt();

				if (input <= piecePositions.length) {
					correctInput = true;
					return input;
				}
				else if (input < piecePositions.length - piecePositions.length || input > piecePositions.length) {
					System.out.println("\nWrong coordinate entered, must be within 0-8\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nWrong input receivied\n");
			} catch (Exception e1) {
				System.out.println("\nError happened\n");
			}
		}
		return -1;
	}

	@Override
	public int getNewCoordinateInput_X(Pieces[][] piecePositions) {
		correctInput = false;

		while (!correctInput) {
			int input;
			Scanner scan = new Scanner(System.in);

			try {
				System.out.print("\nEnter new x coordinate you want your piece moved to: ");
				input = scan.nextInt();

				if (input <= piecePositions.length) {
					correctInput = true;
					return input;
				}
				else if (input < piecePositions.length - piecePositions.length || input > piecePositions.length) {
					System.out.println("\nWrong coordinate entered, must be within 0-8\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nWrong input receivied");
			} catch (Exception e1) {
				System.out.println("\nError happened");
			}
		}
		return -1;
	}

	@Override
	public int getNewCoordinateInput_Y(Pieces[][] piecePositions) {
		correctInput = false;

		while (!correctInput) {
			int input;
			Scanner scan = new Scanner(System.in);

			try {
				System.out.print("\nEnter new y coordinate you want your piece moved to: ");
				input = scan.nextInt();

				if (input <= piecePositions.length) {
					correctInput = true;
					return input;
				}
				else if (input < piecePositions.length - piecePositions.length || input > piecePositions.length) {
					System.out.println("\nWrong coordinate entered, must be within 0-8\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nWrong input receivied");
			} catch (Exception e1) {
				System.out.println("\nError happened");
			}
		}
		return -1;
	}
}
