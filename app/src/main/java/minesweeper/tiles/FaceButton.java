package minesweeper.tiles;

import javax.swing.ImageIcon;

//import minesweeper.Tile;
import minesweeper.images.FaceType;
import minesweeper.images.ImageType;

public class FaceButton extends Tile {
    public FaceButton(FaceType type){
        switch (type) {
            case SMILE: icon = new ImageIcon(
                imageHandler.getIcon(ImageType.SMILE)); break;
            case PRESSED_SMILE: icon = new ImageIcon(
                imageHandler.getIcon(ImageType.PRESSED_SMILE)); break;
            case SHOCKED_FACE: icon = new ImageIcon(
                imageHandler.getIcon(ImageType.SHOCKED_FACE)); break;
            case SUNGLASSES_FACE: icon = new ImageIcon(
                imageHandler.getIcon(ImageType.SUNGLASSES_FACE)); break;
            case SAD_FACE: icon = new ImageIcon(
                imageHandler.getIcon(ImageType.SAD_FACE)); break;
            default: break;
        }
    }
}
