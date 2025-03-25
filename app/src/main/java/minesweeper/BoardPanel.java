package minesweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    private BoardSize boardSize = null;
    
    public BoardPanel(){
        this.setLayout(null);
        this.setSize(Frame.PANEL_WIDTH, Frame.PANEL_HEIGHT);
        this.setLayout(null);
        //this.setForeground(Color.BLACK);
        this.setBackground(Color.LIGHT_GRAY);
        //this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setLocation(new Point(Frame.MENU_WIDTH, 0));
    }

    public void SetBoardSize(BoardSize boardSize){
        this.boardSize = boardSize;
    }
}
