package minesweeper;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class Board {
    private Frame frame = new Frame();
    private BoardSize size = null;

    public Board(BoardSize size){
        this.size = size;
        frame.setLayout(null);

    }
}
