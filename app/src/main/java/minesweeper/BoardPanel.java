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
import javax.swing.SwingUtilities;

import minesweeper.images.ImageHandler;

public class BoardPanel extends JPanel implements ActionListener, MouseListener {
    private Board board = null;
    private List<RegularTile> tiles = new ArrayList<>();
    private List<JLabel> icons = new ArrayList<>();
    private List<TileCover> tileCovers = new ArrayList<>();
    private ImageHandler imageHandler = new ImageHandler();
    private int xOffset, yOffset;
    private boolean ifGameOn;
    private int clicksCounter=0;
    
    public BoardPanel(){
        this.setLayout(null);
        this.setSize(Frame.PANEL_WIDTH, Frame.PANEL_HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(new Point(Frame.MENU_WIDTH, 0));
    }

    public void GenerateBoard(BoardSize boardSize){
        this.board = new Board(boardSize);

        ifGameOn = true;
        clicksCounter = 0;

        xOffset=(Frame.PANEL_WIDTH-boardSize.getColumns()*imageHandler.getTileSide())/2;
        yOffset=100;

        DrawBoard(boardSize);

        this.revalidate(); // Layout updated
        this.repaint(); 
    }

    private void DrawBoard(BoardSize boardSize){
        this.removeAll();
        tileCovers.clear();
        GenerateIcons();

        ImageIcon icon = new ImageIcon(imageHandler.getIcon(TileType.COVERED_TILE));
        for(int i=0; i<boardSize.getColumns(); i++){
            for(int j=0; j<boardSize.getRows(); j++){
                tileCovers.add(new TileCover(j, i));
                tileCovers.get(i*boardSize.getColumns()+j).setBounds(xOffset+i*18, yOffset+j*18, 18, 18);
                tileCovers.get(i*boardSize.getColumns()+j).setIcon(icon);
                tileCovers.get(i*boardSize.getColumns()+j).addActionListener(this);
                tileCovers.get(i*boardSize.getColumns()+j).addMouseListener(this);
                this.add(tileCovers.get(i*boardSize.getColumns()+j));
            }
        }
    }

    private void MineClicked(){
        ifGameOn = false;
        System.out.println("You lost");
    }

    private int GetIndexOfComponent(List<?> components,Object source){
        int index = -1;

        // Find the index of the clicked Component
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i) == source) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void GenerateIcons(){
        BoardSize boardSize = board.GetSize();

        tiles.clear();

        for(int i=0; i<boardSize.getRows(); i++){
            for(int j=0; j<boardSize.getColumns(); j++){
                tiles.add(new RegularTile(board.getTileBoard()[j][i], j, i));
            }
        }
        icons.clear();
        for(int i=0; i<boardSize.getRows(); i++){
            for(int j=0; j<boardSize.getColumns(); j++){
                JLabel icon = new JLabel(new ImageIcon(
                    imageHandler.getIcon(tiles.get(i*boardSize.getColumns()+j).GetType()))); 
            
                icon.setBounds(xOffset+i*18, yOffset+j*18, 18, 18);
                icon.addMouseListener(this);
                icons.add(icon);
            }
        }
    }

    private void ShowNeighbors(int index){
        int x = board.GetPosition(index).x;
        int y = board.GetPosition(index).y;

        if(tiles.get(index).GetType() == TileType.EMPTY_TILE){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==1 && j==1) continue;
                    else if(x+i-1<0 || y+j-1<0 || 
                        x+i-1>board.GetSize().getColumns()-1 || 
                        y+j-1>board.GetSize().getRows()-1)
                            continue;
                    else if(tileCovers.get((x+i-1)*board.GetSize()
                        .getColumns()+(y+j-1)).IsFlag())
                            continue;
                    else if(tiles.get((x+i-1)*board.GetSize()
                        .getColumns()+(y+j-1)).GetType() != 
                        TileType.UNTRIGGERED_MINE
                        && !tileCovers.get((x+i-1)*board.GetSize()
                        .getColumns()+(y+j-1)).IsFlag() ){
                            this.remove(tileCovers.get((x+i-1)*board
                                .GetSize().getColumns()+(y+j-1)));
                            this.add(icons.get((x+i-1)*board.GetSize()
                                .getColumns()+(y+j-1)));
                    }
                }
            }
        }
        else if (ImageHandler.isNumberedTile(tiles.get(index))) {
            int amountOfMines = 
                ImageHandler.getNumber(tiles.get(index).GetType());
            int counter=0; 

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==1 && j==1) continue;
                    else if(x+i-1<0 || y+j-1<0 || 
                        x+i-1>board.GetSize().getColumns()-1 || 
                        y+j-1>board.GetSize().getRows()-1)
                            continue;
                    else if(tileCovers.get((x+i-1)*board.GetSize()
                        .getColumns()+(y+j-1)).IsFlag())
                            counter++;
                }
            }

            if(counter==amountOfMines){
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(i==1 && j==1) continue;
                        else if(x+i-1<0 || y+j-1<0 || 
                            x+i-1>board.GetSize().getColumns()-1 || 
                            y+j-1>board.GetSize().getRows()-1)
                                continue;
                        else if(tiles.get((x+i-1)*board.GetSize()
                            .getColumns()+(y+j-1)).GetType() != 
                            TileType.UNTRIGGERED_MINE
                            && !tileCovers.get((x+i-1)*board.GetSize()
                            .getColumns()+(y+j-1)).IsFlag() ){
                                this.remove(tileCovers.get((x+i-1)*board
                                    .GetSize().getColumns()+(y+j-1)));
                                this.add(icons.get((x+i-1)*board.GetSize()
                                    .getColumns()+(y+j-1)));
                        }
                    }
                }
            }
        }
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(tileCovers.contains(source)){
            int index = GetIndexOfComponent(tileCovers, source);

            board.GetPosition(index);

            if(ifGameOn){
                if(!tileCovers.get(index).IsFlag()){
                    // First click
                    clicksCounter++;
                    
                    // Action 
                    switch (tiles.get(index).GetType()) {
                        case UNTRIGGERED_MINE:
                            if(clicksCounter==1) {
                                board.MoveMine(index);
                                GenerateIcons();
                            }
                            else MineClicked(); 
                            break;
                        case EMPTY_TILE:
                            ShowNeighbors(index);
                            break;
                        default: break;
                    }

                    this.remove(tileCovers.get(index));
                    this.add(icons.get(index));
                    this.repaint();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();

        if (icons.contains(source)){
            int index = GetIndexOfComponent(icons, source);

            System.out.println(index);
            if(tiles.get(index).GetType() != TileType.UNTRIGGERED_MINE){
                ShowNeighbors(index);
            }
            this.repaint();
        }
        else if(tileCovers.contains(source) && SwingUtilities.isRightMouseButton(e)){
            int index = GetIndexOfComponent(tileCovers, source);
            System.out.println(index);
            if(!tileCovers.get(index).IsFlag()){
                tileCovers.get(index).PutFlag();
                tileCovers.get(index).setIcon(new ImageIcon(imageHandler.getIcon(TileType.FLAG)));;
            }
            else{
                tileCovers.get(index).RemoveFlag();
                tileCovers.get(index).setIcon(new ImageIcon(imageHandler.getIcon(TileType.COVERED_TILE)));;
            
            }
            
            this.repaint();
        }
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



/*
 * TODO: Displaying all mines when fail
 * TODO: Inform when win
 * TODO: Finish interface
 */