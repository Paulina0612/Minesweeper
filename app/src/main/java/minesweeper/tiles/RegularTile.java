package minesweeper.tiles;

import javax.swing.ImageIcon;

public class RegularTile extends Tile {
    public RegularTile(int num){
        this.icon = new ImageIcon(imageHandler.getIcon(
            imageHandler.getNumberedTileType(num)));
        
    }
}
