
public interface IGameService {
	
	public boolean changePlayerTurn(boolean turn);
	public boolean validPosition(Pieces[][] p, boolean[][] m, boolean turn, int x, int y, int x2, int y2);
	public boolean validPieceOnCoordinate(Pieces[][] p, boolean turn, int x, int y);
}
