
public class Board {

	public int[][] positions;
	public boolean[][] movableField;

	public Board() {
		super();

		// Positions of player pieces
		positions = new int[][] { { 0, 1, 0, 1, 0, 1, 0, 1, }, { 1, 0, 1, 0, 1, 0, 1, 0, }, { 0, 1, 0, 1, 0, 1, 0, 1, },
				{ 0, 0, 0, 0, 0, 0, 0, 0, }, { 0, 0, 0, 0, 0, 0, 0, 0, }, { 2, 0, 2, 0, 2, 0, 2, 0, },
				{ 0, 2, 0, 2, 0, 2, 0, 2, }, { 2, 0, 2, 0, 2, 0, 2, 0, }, };

		// Positions that is movable for every piece
		movableField = new boolean[][] { { false, true, false, true, false, true, false, true },
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
		for (int i = 0; i < positions[0].length; i++) {
			System.out.printf("   " + i);
		}
		System.out.println("");
		System.out.println("  +---+---+---+---+---+---+---+---+");

		for (int i = 0; i < positions.length; i++) {
			System.out.print(i + " |");
			for (int j = 0; j < positions.length; j++) {
				if (positions[i][j] == 0) {
					System.out.print(" " + " ");
				}
				if (positions[i][j] == 1) {
					System.out.print(" " + "W");
				}
				if (positions[i][j] == 2) {
					System.out.print(" " + "B");
				}
				System.out.print(" " + "|");
				
			}
			System.out.println("\n  +---+---+---+---+---+---+---+---+");
		}
	}
}
