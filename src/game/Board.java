package game;
public class Board {

	public boolean[][] movablePositions;
	public Pieces[][] piecePositions;
	
	public Board() {
		super();

		// Static positions of game pieces.
		piecePositions = new Pieces[][] { 
			{ Pieces.NONE , Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, }, 
			{ Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, }, 
			{ Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, Pieces.NONE, Pieces.WHITE, },
			{ Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, }, 
			{ Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, Pieces.NONE, }, 
			{ Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, },
			{ Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, }, 
			{ Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, Pieces.BLACK, Pieces.NONE, }, };

		// Positions that is valid to have a game piece on.
		movablePositions = new boolean[][] { 
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false },
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false },
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false },
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false }, };
	}

	public void drawBoard() {

		System.out.printf(" ", "");
		for (int i = 0; i < piecePositions[0].length; i++) {
			System.out.printf("   " + i);
		}
		
		System.out.println("");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int i = 0; i < piecePositions.length; i++) {
			System.out.print(i + " |");
			for (int j = 0; j < piecePositions.length; j++) {
				if (piecePositions[i][j].equals(Pieces.NONE)) {
					System.out.print(" " + " ");
				}
				if (piecePositions[i][j].equals(Pieces.WHITE)) {
					System.out.print(" " + "X");
				}
				if (piecePositions[i][j].equals(Pieces.BLACK)) {
					System.out.print(" " + "o");
				}
				System.out.print(" " + "|");			
			}
			System.out.println("\n  +---+---+---+---+---+---+---+---+");
		}
	}
}
