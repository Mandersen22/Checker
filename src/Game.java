import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Board b;
	private Scanner s;
	private ArrayList<Player> p;
	
	private Scanner x1, x2, y1, y2;

	public Game() {
		super();
		
		b = new Board();
		s = new Scanner(System.in);
		p = new ArrayList<Player>();
		
		x1 = new Scanner(System.in);
		y1 = new Scanner(System.in);
		
		x2 = new Scanner(System.in);
		y2 = new Scanner(System.in);
	}
	
	public void startGame() {
		
		// Load players
//		getPlayerDetails();
		
		// Run game
		while(true) {
			b.loadBoard();
			System.exit(1);
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
