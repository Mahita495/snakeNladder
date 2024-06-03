public class Player {
    private String name;
    private int pos;

    public Player(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    public void setPos(int endPos) {
        pos = endPos;
    }
}
