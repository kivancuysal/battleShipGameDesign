import java.util.List;
import java.util.Scanner;

public abstract class Players {
    private String[][] board = new String[10][10];
    private List<Ship> ships;

    private List<Coordinate> selectedCoordinates;

    //constructors
    public Players() {
    }

    public Players(String[][] board, List<Ship> ships) {
        this.board = board;
        this.ships = ships;
    }

    //getters and setters
    public String[][] getBoard() {
        return board;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Coordinate> getSelectedCoordinates() {
        return selectedCoordinates;
    }

    public void setSelectedCoordinates(List<Coordinate> selectedCoordinates) {
        this.selectedCoordinates = selectedCoordinates;
    }

    //methods
    public Coordinate attackCoordinate() {
        Coordinate coordinate = new Coordinate();
        // oyuncular kendi sırası geldiğinde koordinat seçerek ilerler

        Scanner scanner = new Scanner(System.in);

        System.out.print("Saldırı yapmak istediğiniz x koordinatını girin: ");
        int x = scanner.nextInt();

        System.out.print("Saldırı yapmak istediğiniz y koordinatını girin: ");
        int y = scanner.nextInt();
        coordinate.setCoordinates(x, y);

        if (coordinateIsSelected(coordinate))
            // seçilen koordinatın daha önce seçilip seçilmediğini kontrol eder
            // while döngüsü ile oyuncu daha önce seçilmemiş olan koordinatı seçene kadar bu bilgi istenmeye devam eder
        {
            System.out.print("Bu koordinat daha önce seçilmiş..");
        }
        else {
            selectedCoordinates.add(coordinate);
            // daha önce seçilen koordinatları tekrar seçmeye izin vermemek için seçili koordinatların listesine
            // her koordinat seçimi sonrası koordinatları ekliyoruz
        }
        return coordinate;
    }

    public boolean coordinateIsSelected(Coordinate coordinate) {

        // selectedCoordinates listesi içinde seçilen koordinatın daha önce eklenip eklenmediğini (yani
        // seçilip seçilmediğini) kontrol eder ve buna göre true/false değer döndürür

        return false;
    }

    public void placeShip(String[][] board, Ship ship) {
        // aldığı ship inputunun ship size'ına göre board üzerinde ship'i yerleştirebileceği yerleri kontrol eder
        // kontrollere uygun random koordinatlar üreterek koordinat bilgileri ile ship objesinin setCoordinates
        // metodunu çağırarak ship'in koordinatlarını set eder

        // ship type'ına göre gemiyi temsil eden bir karakteri board'a yerleştirir
        // CARRIER için CA, BATTLESHIP için BA, CRUISER, için CR, DESTROYER için DE yerleştirir
        // board[x][y] = 'CA'; şeklinde seçili koordinatları board'a set eder
    }

    public void initializeBoard(String[][] board) {
        // board'u başlangıç durumuna getirmek için array'in her bir elemanını '-' karakteri ile doldurur

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = String.valueOf('-');
            }
        }
    }

    public void updateBoard(String[][] board, Coordinate coordinate, char symbol) {

        // karşı oyuncu oynadığında board'un durumunu günceller
        // eğer gemi vurulmuş ise X, boş alan vurulmuş ise + olarak board güncellenir

    }

    public boolean checkAttackResult(String[][] board, Coordinate coordinate) {

        // saldırılan koordinatı board'da herhangi bir gemiye gelmiş mi kontrol eder ve eğer gemi vurulmuş ise true
        // vurulmamış ise false değer döndürür

        return false;
    }
}
