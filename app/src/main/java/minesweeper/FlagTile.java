package minesweeper;

import javax.swing.ImageIcon;

public class FlagTile extends Tile {
    protected int x, y;

    public FlagTile(int x, int y){
        this.icon = new ImageIcon(imageHandler.getIcon(TileType.FLAG));
        this.x = x;
        this.y = y;
        
    }
}
