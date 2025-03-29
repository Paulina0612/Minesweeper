package minesweeper;

import javax.swing.ImageIcon;

import minesweeper.images.MineType;

public class Mine extends ImageIcon {
    //protected ImageIcon untriggeredMine, triggeredMine, mineError;
    private MineType type;

    public Mine(MineType type){
        this.type = type;
        //switch (type) {
        //    case UNTRIGGERED_MINE: untriggeredMine = new ImageIcon(
        //        imageHandler.getIcon(TileType.UNTRIGGERED_MINE)); break;
        //    case TRIGGERED_MINE: triggeredMine = new ImageIcon(
        //        imageHandler.getIcon(TileType.TRIGGERED_MINE)); break;
        //    case MINE_ERROR: mineError = new ImageIcon(
        //        imageHandler.getIcon(TileType.MINE_ERROR)); break;
        //    default: break;
        //}
    }

    public MineType GetMineType(){
        return type;
    } 
}
