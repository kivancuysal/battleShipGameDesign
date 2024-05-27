import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        // oyuncudan zorluk ve isim bilgileri alınarak start game metoduna gönderilir
        Scanner scanner = new Scanner(System.in);

        System.out.print("İsminizi girin: ");
        String name = scanner.toString();
        System.out.print("Zorluk girin (Kolay / Orta / Zor): ");
        String difficulty = scanner.toString();

        game.startGame(name, difficulty);

        // döngü ile game içerisindeki playTurn metodu çağrılır ve isGameOver metodu True dönene kadar oyun devam eder
        // oyun sonunda oyuncular ve oyun kazananı konsolda yazdırılır
    }
}
