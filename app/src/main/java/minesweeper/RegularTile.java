package minesweeper;

import javax.swing.ImageIcon;

public class RegularTile extends ImageIcon {
    protected int x, y;
    private TileType type;

    public RegularTile(TileType type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public TileType GetType(){
        return type;
    }
}
