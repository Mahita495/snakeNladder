public class Board {
    private int size;
    private int start = 1;
    private int end;

    public Board(int size) {
        this.size = size;
        this.end = start + size - 1;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }
}
