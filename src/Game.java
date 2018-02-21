import java.util.ArrayList;

public class Game {
	
	private Board board;
	private GameService service;
	
	private ArrayList<Player> players; 
	
	public Game() {
		super();
		
		board = new Board();
		service = new GameService();
	}
	
	public void startGame() {
		// Get player details
		players = service.getPlayerDetails();
		
		// Start game
		
	}
	
}
