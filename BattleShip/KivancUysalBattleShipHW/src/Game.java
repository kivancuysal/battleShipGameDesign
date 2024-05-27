import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private String winner;
    private List<Players> Players ;

    // constructors

    public Game() {
    }

    public Game(String winner, List<Players> players) {
        this.winner = winner;
        Players = players;
    }

    //getters and setters
    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public List<Players> getPlayers() {
        return Players;
    }

    public void setPlayers(List<Players> players) {
        Players = players;
    }

    // methods
    public void startGame(String playerName, String difficulty)
    {
        initializeComputerPlayer(difficulty);
        initializeHumanPlayer(playerName);

    }

    private Players initializeComputerPlayer(String difficulty)
    {
        // CARRIER, BATTLESHIP, CRUISER, DESTROYER
        // Vertical, Horizontal

        // ship create ederken direction enumlar içerisinden random olarak set edilir
        // aşağıda örnek objeler oluşturulmuştur
        Ship computerCA = new Ship(ShipType.CARRIER, Direction.Vertical, false);
        Ship computerBA = new Ship(ShipType.BATTLESHIP, Direction.Horizontal, false);
        Ship computerCR = new Ship(ShipType.CRUISER, Direction.Vertical, false);
        Ship computerDE = new Ship(ShipType.DESTROYER, Direction.Vertical, false);

        List<Ship> computerShips = new ArrayList<>();
        computerShips.add(computerCA);
        computerShips.add(computerBA);
        computerShips.add(computerCR);
        computerShips.add(computerDE);

        String[][] boardComputer = new String[10][10];

        Computer computer = new Computer(boardComputer, computerShips, difficulty);
        computer.initializeBoard(boardComputer);
        computer.placeShip(boardComputer, computerCA);
        computer.placeShip(boardComputer, computerBA);
        computer.placeShip(boardComputer, computerCR);
        computer.placeShip(boardComputer, computerDE);

        // bu metotta computer oyuncusu için ship'ler oluşturulmuş ve computer oyuncusunun board'u initialize
        // edilerek oluşturulan ship'ler board'a yerleştirilmiştir
        return computer;
    }

    private Players initializeHumanPlayer(String playerName)
    {
        // CARRIER, BATTLESHIP, CRUISER, DESTROYER
        // Vertical, Horizontal

        // ship create ederken direction enumlar içerisinden random olarak set edilir
        // aşağıda örnek objeler oluşturulmuştur
        Ship humanCA = new Ship(ShipType.CARRIER, Direction.Horizontal, false);
        Ship humanBA = new Ship(ShipType.BATTLESHIP, Direction.Horizontal, false);
        Ship humanCR = new Ship(ShipType.CRUISER, Direction.Vertical, false);
        Ship humanDE = new Ship(ShipType.DESTROYER, Direction.Horizontal, false);

        List<Ship> humanShips = new ArrayList<>();
        humanShips.add(humanCA);
        humanShips.add(humanBA);
        humanShips.add(humanCR);
        humanShips.add(humanDE);

        String[][] boardHuman = new String[10][10];

        Player player = new Player(boardHuman, humanShips, playerName);
        player.initializeBoard(boardHuman);
        player.placeShip(boardHuman, humanCA);
        player.placeShip(boardHuman, humanBA);
        player.placeShip(boardHuman, humanCR);
        player.placeShip(boardHuman, humanDE);

        // bu metotta human player oyuncusu için ship'ler oluşturulmuş ve human player oyuncusunun board'u initialize
        // edilerek oluşturulan ship'ler board'a yerleştirilmiştir
        return player;
    }

    public void playTurn(Computer computer, Player player, boolean isPlayerTurn)
    {
        //oyuncu mu bilgisayar sırası mı kontrol edilerek yazdırılır
        String playerName = isPlayerTurn ? player.getPlayerName() : "Computer";
        System.out.println(playerName + " sırası:");
        boolean attackResult = false;

        // oyuncu ve computer özelleşmiş metotları ile saldırılacak koordinatlar alınır
        Coordinate attackCoordinate;
        if (isPlayerTurn) {
            attackCoordinate = player.attackCoordinate();

            //saldırının isabet edip etmediğini kontrol eder
            attackResult = player.checkAttackResult(computer.getBoard(), attackCoordinate);

            player.updateBoard(computer.getBoard(), attackCoordinate, attackResult ? 'X' : '+');
            // eğer gemi vurulmuş ise X, boş alan vurulmuş ise + olarak board güncellenir
        } else {
            attackCoordinate = computer.attackCoordinate();

            //saldırının isabet edip etmediğini kontrol eder
            attackResult = computer.checkAttackResult(player.getBoard(), attackCoordinate);

            computer.updateBoard(player.getBoard(), attackCoordinate, attackResult ? 'X' : '+');
            // eğer gemi vurulmuş ise X, boş alan vurulmuş ise + olarak board güncellenir
        }

        if (attackResult) {
            System.out.println("İsabet!");
        } else {
            System.out.println("Boş!");
        }

        // turn bitiğinde printBoard metodu çağrılarak board un son durummu oyuncuya gösterilir
    }

    public void printBoard(String[][] board)
    {
        // board bilgisini alarak console'da board bilgisinin detayını kullanıcıya gösterir
    }

    public boolean isGameOver(String[][] playerBoard, String[][] computerBoard)
    {
        // human player ve computer player board bilgilerini alarak board'daki tüm gemilere saldırılmış mı kontrol eder
        // eğer bir oyuncunun tüm gemileri batmış ise karşı taraf oyunu kazanmış demektir

        return false;
    }
}
