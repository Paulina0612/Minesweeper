package minesweeper.tiles;

import javax.swing.ImageIcon;

import minesweeper.images.ImageType;
import minesweeper.images.MineType;

public class Mine extends Tile {
    protected ImageIcon untriggeredMine, triggeredMine, mineError;

    public Mine(MineType type){
        switch (type) {
            case UNTRIGGERED_MINE: untriggeredMine = new ImageIcon(
                imageHandler.getIcon(ImageType.UNTRIGGERED_MINE)); break;
            case TRIGGERED_MINE: triggeredMine = new ImageIcon(
                imageHandler.getIcon(ImageType.TRIGGERED_MINE)); break;
            case MINE_ERROR: mineError = new ImageIcon(
                imageHandler.getIcon(ImageType.MINE_ERROR)); break;
            default: break;
        }
    }
}
