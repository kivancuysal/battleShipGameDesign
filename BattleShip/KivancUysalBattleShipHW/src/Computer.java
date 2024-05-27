import java.util.List;
import java.util.Random;

public class Computer extends Players{
    private String difficulty;

    // constructors

    public Computer(String[][] board, List<Ship> ships, String difficulty) {
        super(board, ships);
        this.difficulty = difficulty;
    }

    //getters and setters
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    //methods
    @Override
    public Coordinate attackCoordinate() {
        // bilgisayar random olarak bir koordinat seçer
        // seçilen difficulty'e göre burada daha akıllı bir yapı kurulabilir

        Coordinate coordinate = new Coordinate();

        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        coordinate.setCoordinates(x, y);

        if (coordinateIsSelected(coordinate))
        // seçilen koordinatın daha önce seçilip seçilmediğini kontrol eder
        // while döngüsü ile oyuncu daha önce seçilmemiş olan koordinatı seçene kadar bu bilgi istenmeye devam eder
        {
            System.out.print("Bu koordinat daha önce seçilmiş..");
        }
        else {
            super.getSelectedCoordinates().add(coordinate);
            // daha önce seçilen koordinatları tekrar seçmeye izin vermemek için seçili koordinatların listesine
            // her koordinat seçimi sonrası koordinatları ekliyoruz
        }
        return coordinate;
    }
}