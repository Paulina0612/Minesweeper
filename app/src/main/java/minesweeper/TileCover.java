package minesweeper;

import javax.swing.ImageIcon;

public class TileCover extends Tile {
    private boolean ifFlag=false;

    public TileCover(int x, int y){
        this.icon = new ImageIcon(imageHandler.getIcon(TileType.COVERED_TILE));
        this.x = x;
        this.y = y;
    }

    public void PutFlag(){
        ifFlag = true;
    }

    public void RemoveFlag(){
        ifFlag = false;
    }

    public boolean IsFlag(){
        return ifFlag;
    }
}
