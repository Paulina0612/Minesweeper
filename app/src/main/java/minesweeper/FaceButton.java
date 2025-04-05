package minesweeper;

import javax.swing.ImageIcon;

import minesweeper.images.FaceType;

public class FaceButton extends Tile {
    private FaceType type;

    public FaceButton(FaceType type){
        this.type = type;

        switch (type) {
            case SMILE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SMILE)); break;
            case SUNGLASSES_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SUNGLASSES_FACE)); break;
            case SAD_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SAD_FACE)); break;
            default: break;
        }
    }

    public FaceType getType(){
        return type;
    }
    public void setType(FaceType type){
        this.type = type;
        switch (type) {
            case SMILE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SMILE)); break;
            case SUNGLASSES_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SUNGLASSES_FACE)); break;
            case SAD_FACE: icon = new ImageIcon(
                imageHandler.getIcon(TileType.SAD_FACE)); break;
            default: break;
        }
    }
}
