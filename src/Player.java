
public class Player {
	
	public String playerName = null;
	public boolean playerType = true; // True = Player1, False = Player 2
	
	public Player(String name, boolean type) {
		this.playerName = name;
		this.playerType = type;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean isPlayerType() {
		return playerType;
	}

	public void setPlayerType(boolean playerType) {
		this.playerType = playerType;
	}
	
}
