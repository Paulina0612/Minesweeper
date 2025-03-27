package minesweeper.tiles;

import javax.swing.ImageIcon;

public class FlagTile extends Tile {
    public FlagTile(){
        this.icon = new ImageIcon(imageHandler.getIcon(TileType.FLAG));
        
    }
}
