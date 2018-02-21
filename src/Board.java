
public class Board {
	
	public int[][] positions;
	public boolean[][] movableField;
	
	public Board() {
		super();
		
		// Positions of player pieces
		positions = new int[][] { 
			{ 0, 1, 0, 1, 0, 1, 0, 1, }, 
			{ 1, 0, 1, 0, 1, 0, 1, 0, }, 
			{ 0, 1, 0, 1, 0, 1, 0, 1, },
			{ 0, 0, 0, 0, 0, 0, 0, 0, }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, }, 
			{ 2, 0, 2, 0, 2, 0, 2, 0, },
			{ 0, 2, 0, 2, 0, 2, 0, 2, }, 
			{ 2, 0, 2, 0, 2, 0, 2, 0, }, };
		
		// Positions that is movable for every piece
		movableField = new boolean[][] { 
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false },
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false },
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false },
			{ false, true, false, true, false, true, false, true },
			{ true, false, true, false, true, false, true, false }, };
	}
	
	public void loadBoard() {
		
	}
	
}
