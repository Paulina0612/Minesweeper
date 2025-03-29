package minesweeper;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import minesweeper.images.ImageHandler;

public class BoardPanel extends JPanel {
    private Board board = null;
    private List<RegularTile> tiles = new ArrayList<>();
    private List<JLabel> icons = new ArrayList<>();
    private ImageHandler imageHandler = new ImageHandler();
    private int xOffset, yOffset;
    
    public BoardPanel(){
        this.setLayout(null);
        this.setSize(Frame.PANEL_WIDTH, Frame.PANEL_HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(new Point(Frame.MENU_WIDTH, 0));
    }

    public void GenerateBoard(BoardSize boardSize){
        this.board = new Board(boardSize);

        xOffset=(Frame.PANEL_WIDTH-boardSize.getColumns()*imageHandler.getTileSide())/2;
        yOffset=100;

        DrawBoard(boardSize);

        this.revalidate(); // Layout updated
        this.repaint(); 
    }

    private void DrawBoard(BoardSize boardSize){
        if(icons.size()>0){
            for (JLabel icon : icons) 
                this.remove(icon);
            icons.clear();
            tiles.clear();
        }
        
        for(int i=0; i<boardSize.getRows(); i++){
            for(int j=0; j<boardSize.getColumns(); j++){
                tiles.add(new RegularTile(board.getTileBoard()[j][i], j, i));
            }
        }

        for(int i=0; i<boardSize.getRows(); i++){
            for(int j=0; j<boardSize.getColumns(); j++){
                JLabel icon = new JLabel(new ImageIcon(
                    imageHandler.getIcon(tiles.get(i*boardSize.getColumns()+j).GetType()))); 
            
                icon.setBounds(xOffset+i*18, yOffset+j*18, 18, 18);
                icons.add(icon);
                this.add(icons.get(i*boardSize.getColumns()+j));
            }
        }
    }
}
