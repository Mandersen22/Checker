package game;
public interface IGameService {
	public boolean changePlayerTurn(boolean turn);
	public boolean validPosition(Pieces[][] p, boolean[][] m, boolean turn, int x, int y, int x2, int y2);
	public boolean pieceOnCoordinate(Pieces[][] p, boolean turn, int x, int y);
	public int getCoordinateInput_X(Pieces[][] piecePositions);
	public int getCoordinateInput_Y(Pieces[][] piecePositions);
	public int getNewCoordinateInput_X(Pieces[][] piecePositions);
	public int getNewCoordinateInput_Y(Pieces[][] piecePositions);
}
