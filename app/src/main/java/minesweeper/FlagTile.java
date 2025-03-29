package minesweeper;

import javax.swing.ImageIcon;

public class FlagTile extends TileCover {
    public FlagTile(int x, int y){
        super(x, y); // Explicitly call the constructor of TileCover
        this.icon = new ImageIcon(imageHandler.getIcon(TileType.FLAG));
    }
}
