package minesweeper;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import minesweeper.images.ImageHandler;
//import minesweeper.images.MineType;

public class BoardPanel extends JPanel {
    private Board board = null;
    private List<RegularTile> tiles = new ArrayList<>();
    private List<JLabel> icons = new ArrayList<>();
    private ImageHandler imageHandler = new ImageHandler();
    
    public BoardPanel(){
        this.setLayout(null);
        this.setSize(Frame.PANEL_WIDTH, Frame.PANEL_HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(new Point(Frame.MENU_WIDTH, 0));

        //JLabel label = new JLabel("aaaa");
        //label.setBounds(0, 0, 100, 100);
        //this.add(label);
    }

    public void GenerateBoard(BoardSize boardSize){
        this.board = new Board(boardSize);
        tiles.clear();
        icons.clear();
        DrawBoard(boardSize);
        //System.out.println(icons.get(0).getX());
        this.revalidate(); // Ensures the layout is updated
        this.repaint(); 
    }

    private void DrawBoard(BoardSize boardSize){
        for(int i=0; i<boardSize.getRows(); i++){
            for(int j=0; j<boardSize.getColumns(); j++){
                //System.out.println(board.getTileBoard()[i][j]);
                //tiles.add(new Tile())
                //if(board.getTileBoard()[i][j]==TileType.UNTRIGGERED_MINE)
                //    tiles.add(new Mine(MineType.UNTRIGGERED_MINE, j, i));
                //else 
                    tiles.add(new RegularTile(
                        board.getTileBoard()[i][j], j, i));
            }
        }
        BufferedImage img =imageHandler.getIcon(tiles.get(0).GetType());
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel label = new JLabel(imgIcon); 
        label.setBounds(0, 0, 18, 18);
        icons.add(label );
        System.out.println(img.getWidth() + " " + imgIcon.getIconWidth() + " " + label.getHeight());
        //icons.get(0).setBounds(0,0,100,100);
        this.add(icons.get(0));
    }
}
