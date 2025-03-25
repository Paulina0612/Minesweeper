package minesweeper;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    private BoardSize boardSize = null;
    
    public BoardPanel(){
        this.setLayout(null);
    }

    public void SetBoardSize(BoardSize boardSize){
        this.boardSize = boardSize;
        System.out.println(boardSize);
    }
}
