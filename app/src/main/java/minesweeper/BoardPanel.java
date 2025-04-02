package minesweeper;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import minesweeper.images.ImageHandler;

public class BoardPanel extends JPanel implements ActionListener, MouseListener {
    private Board board = null;
    private List<RegularTile> tiles = new ArrayList<>();
    private List<JLabel> icons = new ArrayList<>();
    private List<TileCover> tileCovers = new ArrayList<>();
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
            this.removeAll();
            icons.clear();
            tiles.clear();
            tileCovers.clear();
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
                icon.addMouseListener(this);
                icons.add(icon);
                //this.add(icons.get(i*boardSize.getColumns()+j));
            }
        }

        ImageIcon icon = new ImageIcon(imageHandler.getIcon(TileType.COVERED_TILE));
        for(int i=0; i<boardSize.getColumns(); i++){
            for(int j=0; j<boardSize.getRows(); j++){
                tileCovers.add(new TileCover(j, i));
                tileCovers.get(i*boardSize.getColumns()+j).setBounds(xOffset+i*18, yOffset+j*18, 18, 18);
                tileCovers.get(i*boardSize.getColumns()+j).setIcon(icon);
                tileCovers.get(i*boardSize.getColumns()+j).addActionListener(this);
                this.add(tileCovers.get(i*boardSize.getColumns()+j));
            }
        }
    }

    //TODO: Optimize two methods
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int index = -1;

        // Find the index of the clicked TileCover
        for (int i = 0; i < tileCovers.size(); i++) {
            if (tileCovers.get(i) == source) {
                index = i;
                break;
            }
        }

        this.remove(tileCovers.get(index));
        this.add(icons.get(index));
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        int index = -1;

        // Find the index of the clicked TileCover
        for (int i = 0; i < icons.size(); i++) {
            if (icons.get(i) == source) {
                index = i;
                break;
            }
        }

        System.out.println(index);
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
