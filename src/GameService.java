
public class GameService implements IGameService {
	
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
	public boolean validPieceOnCoordinate(Pieces[][] p, boolean turn, int x, int y) {
		if (turn == true && p[y][x] == Pieces.WHITE) {
			return true;
		} else if (turn == false && p[y][x] == Pieces.BLACK) {
			return true;
		} else {
			return false;
		}
	}
}
