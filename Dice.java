import java.util.*;

public class Dice {
    public int roll() {
        Random r = new Random();
        return r.nextInt(0, 6);

    }
}
