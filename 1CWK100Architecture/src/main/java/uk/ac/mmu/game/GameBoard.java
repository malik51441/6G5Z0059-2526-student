package uk.ac.mmu.game;

public class GameBoard {
    public final static int HOME = 0;
    public final static int END = 20;
    public final static int LENGTH = END - HOME + 1;
    private int index;
    private int moves;


    public GameBoard() {
        this.index = HOME;
        this.moves = 0;
    }

    public int getIndex() {
        return index;
    }
    private void setIndex(int newIndex) {
        if (newIndex >= HOME && newIndex <= END) {
            index = newIndex;
        } else {
            throw new IndexOutOfBoundsException(newIndex);
        }
    }

    public int getMoves() {
        return moves;
    }

    public void advance(int count) {
        int newIndex = index + count;
        setIndex(newIndex % LENGTH);
        moves++;
    }
    public boolean isHome() {
        return index == HOME;
    }

    public int getCurrentPosition() {
        return index + 1;
    }


}
