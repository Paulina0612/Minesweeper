package minesweeper.tiles;

import javax.swing.ImageIcon;

import minesweeper.images.ImageType;

public class FlagTile extends Tile {
    public FlagTile(){
        this.icon = new ImageIcon(imageHandler.getIcon(ImageType.FLAG));
        
    }
}
