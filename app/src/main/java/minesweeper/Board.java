package minesweeper;

public class Board {
    private Frame frame = new Frame();
    private BoardSize size = null;

    public Board(BoardSize size){
        this.size = size;
        frame.setLayout(null);

    }
}
