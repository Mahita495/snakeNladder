import java.util.*;

public class Game {
    private int noOfSnakes;
    private int noOfLadders;
    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Dice dice;
    private Board board;

    public Game(int noOfSnakes, int noOfLadders, int boardSize) {
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        this.players = new ArrayDeque<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        dice = new Dice();
        board = new Board(boardSize);
        inBoard();
    }

    private void inBoard() {
        Set<String> s1 = new HashSet<>();
        for (int i = 0; i < noOfSnakes; i++) {
            while (true) {
                Random r = new Random();
                int snakeStart = r.nextInt(board.getStart(), board.getSize());
                int snakeEnd = r.nextInt(board.getStart(), board.getSize());
                if (snakeStart > snakeEnd) {
                    continue;
                }
                String startEndPair = String.valueOf(snakeStart) + snakeEnd;
                if (!s1.contains(startEndPair)) {
                    Snake snake = new Snake(snakeStart, snakeEnd);
                    snakes.add(snake);
                    s1.add(startEndPair);
                    break;
                }

            }
        }
        for (int i = 0; i < noOfLadders; i++) {
            while (true) {
                Random r = new Random();
                int ladderStart = r.nextInt(board.getStart(), board.getSize());
                int ladderEnd = r.nextInt(board.getStart(), board.getSize());
                if (ladderStart > ladderEnd) {
                    continue;
                }
                String startEndPair = String.valueOf(ladderStart) + ladderEnd;
                if (!s1.contains(startEndPair)) {
                    Ladder ladder = new Ladder(ladderStart, ladderEnd);
                    ladders.add(ladder);
                    s1.add(startEndPair);
                    break;
                }
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playGame() {
        while (true) {
            Player player = players.poll();
            int value = dice.roll();
            int newPos = player.getPos() + value;
            if (newPos > board.getEnd()) {
                player.setPos(player.getPos());
                players.offer(player);
            } else {
                player.setPos(getNewPos(newPos));
                if (player.getPos() == board.getEnd()) {
                    System.out.println("Player " + player.getName() + " Won. ");
                } else {
                    System.out.println(player.getName() + "'s new position at " + player.getPos());
                    players.offer(player);
                }
            }
            if (players.size() < 2) {
                break;
            }
        }
    }

    private int getNewPos(int newPos) {
        for (Snake i : snakes) {
            if (i.getHead() == newPos) {
                System.out.println("Snake Bit");
                return i.getTail();
            }
        }
        for (Ladder i : ladders) {
            if (i.getStart() == newPos) {
                System.out.println("Climbed ladder");
                return i.getEnd();
            }
        }
        return newPos;
    }
}
