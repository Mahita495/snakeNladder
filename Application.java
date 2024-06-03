import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter board size:");
        int boardSize = sc.nextInt();
        System.out.println("Enter No.of.Players:");
        int noOfPlayers = sc.nextInt();
        System.out.println("Enter No.of.Snakes:");
        int noSnakes = sc.nextInt();
        System.out.println("Enter No.of.Ladders:");
        int noLadders = sc.nextInt();

        Game game = new Game(noSnakes, noLadders, boardSize);
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter Player Name:");
            String p = sc.next();
            Player player = new Player(p);
            game.addPlayer(player);
        }
        game.playGame();
    }
}
