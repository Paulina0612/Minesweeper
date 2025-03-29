package minesweeper;

import javax.swing.ImageIcon;

//import minesweeper.Tile;
import minesweeper.images.FaceType;

public class FaceButton extends Tile {
    public FaceButton(FaceType type){
        switch (type) {
            case SMILE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SMILE)); break;
            case PRESSED_SMILE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.PRESSED_SMILE)); break;
            case SHOCKED_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SHOCKED_FACE)); break;
            case SUNGLASSES_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SUNGLASSES_FACE)); break;
            case SAD_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SAD_FACE)); break;
            default: break;
        }
    }
}
