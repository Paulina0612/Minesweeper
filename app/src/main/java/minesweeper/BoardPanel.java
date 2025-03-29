package minesweeper;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    private Board board = null;
    private List<Tile> tiles;
    
    public BoardPanel(){
        this.setLayout(null);
        this.setSize(Frame.PANEL_WIDTH, Frame.PANEL_HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(new Point(Frame.MENU_WIDTH, 0));
    }

    public void GenerateBoard(BoardSize boardSize){
        this.board = new Board(boardSize);
        DrawBoard(boardSize);
    }

    private void DrawBoard(BoardSize boardSize){
        for(int i=0; i<boardSize.getRows(); i++){
            for(int j=0; j<boardSize.getColumns(); j++){
                RegularTile tile = new RegularTile(board.getTileBoard()[i][j]);

            }
        }
    }
}
