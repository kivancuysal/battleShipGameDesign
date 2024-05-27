import java.util.List;

public class Player extends Players{

    private String playerName;

    // constructors
    public Player(String[][] board, List<Ship> ships, String playerName) {
        super(board, ships);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
