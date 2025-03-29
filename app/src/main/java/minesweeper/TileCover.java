package minesweeper;

import javax.swing.ImageIcon;

public class TileCover extends Tile {
    public TileCover(int x, int y){
        this.icon = new ImageIcon(imageHandler.getIcon(TileType.COVERED_TILE));
        this.x = x;
        this.y = y;
    }
}
