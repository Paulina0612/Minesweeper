package minesweeper.tiles;

import javax.swing.ImageIcon;

public class TileCover extends Tile {
    public TileCover(){
        this.icon = new ImageIcon(imageHandler.getIcon(TileType.COVERED_TILE));
        
    }
}
