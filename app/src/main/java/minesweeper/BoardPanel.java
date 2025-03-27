package minesweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    private Board board = null;
    
    public BoardPanel(){
        this.setLayout(null);
        this.setSize(Frame.PANEL_WIDTH, Frame.PANEL_HEIGHT);
        this.setLayout(null);
        //this.setForeground(Color.BLACK);
        this.setBackground(Color.LIGHT_GRAY);
        //this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setLocation(new Point(Frame.MENU_WIDTH, 0));
    }

    public void GenerateBoard(BoardSize boardSize){
        this.board = new Board(boardSize);
    }
}
