package game;

public class Player {
	
	public String name = null;
	public boolean type = true; // True = Player1, False = Player2
	
	public Player(String name, boolean type) {
		this.name = name;
		this.type = type;
	}

	public String getPlayerName() {
		return name;
	}

	public void setPlayerName(String name) {
		this.name = name;
	}

	public boolean isPlayerType() {
		return type;
	}

	public void setPlayerType(boolean type) {
		this.type = type;
	}
	
}
