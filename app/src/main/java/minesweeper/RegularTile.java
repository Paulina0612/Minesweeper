package minesweeper;

import javax.swing.ImageIcon;

public class RegularTile extends ImageIcon {
    private TileType type;

    public RegularTile(TileType type){
        this.type = type;
    }

    public TileType GetType(){
        return type;
    }
}
