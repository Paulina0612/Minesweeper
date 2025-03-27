package minesweeper.tiles;

import javax.swing.ImageIcon;

import minesweeper.images.ImageType;

public class TileCover extends Tile {
    public TileCover(){
        this.icon = new ImageIcon(imageHandler.getIcon(ImageType.COVERED_TILE));
        
    }
}
