import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Board b;
	private Scanner s;
	private ArrayList<Player> p;
	
	public Game() {
		super();
		
		b = new Board();
		s = new Scanner(System.in);
		p = new ArrayList<Player>();
	}
	
	public void startGame() {
		
		// Load players
		getPlayerDetails();
		
		// Load game board
		
		
		// Run game
		while(true) {
			
		}
	}

	private void getPlayerDetails() {
		for (int i = 1; i < 3; i++) {
			System.out.print("Enter name of player " + i + ": ");
			String name = s.next();
			
			if (i == 1) {
				p.add(new Player(name, true));
				System.out.println(name + " has been added as player 1\n");
			}
			else {
				p.add(new Player(name, false)); 
				System.out.println(name + " has been added as player 2\n");
			}
		}

	}
	
}
