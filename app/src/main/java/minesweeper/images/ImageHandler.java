package minesweeper.images;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import minesweeper.TileType;

public class ImageHandler {
    private BufferedImage img;
    private final int NUM_W=15, NUM_H=25;
    private final int FACE_SIDE=26, TILE_SIDE=18;


    public ImageHandler(){
        try {
        this.img = ImageIO.read(new FileInputStream(
            "app\\src\\main\\java\\minesweeper\\images\\SpriteSheet.png"));
        } 
        catch (IOException e) {e.printStackTrace();}
    }

    public int getNumberedIconWidth(){ return NUM_W; }
    public int getNumberedIconHeight(){ return NUM_H; }
    public int getFaceSide(){ return FACE_SIDE; }
    public int getTileSide(){ return TILE_SIDE; }
    
    public TileType getNumberType(String num){
        switch (num) {
            case "0":          return TileType.NUMBER_0;
            case "1":          return TileType.NUMBER_1;
            case "2":          return TileType.NUMBER_2;
            case "3":          return TileType.NUMBER_3;
            case "4":          return TileType.NUMBER_4;
            case "5":          return TileType.NUMBER_5;
            case "6":          return TileType.NUMBER_6;
            case "7":          return TileType.NUMBER_7;
            case "8":          return TileType.NUMBER_8;
            case "9":          return TileType.NUMBER_9;
            case "-":          return TileType.NUMBER_MINUS;
            case "null":       return TileType.NUMBER_NULL;
            default:         return null;
        }
    }

    public static TileType getNumberedTileType(int num){
        switch (num) {
            case 0:          return TileType.EMPTY_TILE;
            case 1:          return TileType.TILE_1;
            case 2:          return TileType.TILE_2;
            case 3:          return TileType.TILE_3;
            case 4:          return TileType.TILE_4;
            case 5:          return TileType.TILE_5;
            case 6:          return TileType.TILE_6;
            case 7:          return TileType.TILE_7;
            case 8:          return TileType.TILE_8;
            default:         return null;
        }
    }

    public BufferedImage getIcon(TileType type){
        switch (type) {
            case NUMBER_0:          return img.getSubimage(12+NUM_W*9-1*7, 145, NUM_W, NUM_H);
            case NUMBER_1:          return img.getSubimage(13, 145, NUM_W, NUM_H);
            case NUMBER_2:          return img.getSubimage(12+NUM_W, 145, NUM_W, NUM_H);
            case NUMBER_3:          return img.getSubimage(12+NUM_W*2, 145, NUM_W, NUM_H);
            case NUMBER_4:          return img.getSubimage(12+NUM_W*3-1, 145, NUM_W, NUM_H);
            case NUMBER_5:          return img.getSubimage(12+NUM_W*4-1*2, 145, NUM_W, NUM_H);
            case NUMBER_6:          return img.getSubimage(12+NUM_W*5-1*3, 145, NUM_W, NUM_H);
            case NUMBER_7:          return img.getSubimage(12+NUM_W*6-1*4, 145, NUM_W, NUM_H);
            case NUMBER_8:          return img.getSubimage(12+NUM_W*7-1*5, 145, NUM_W, NUM_H);
            case NUMBER_9:          return img.getSubimage(12+NUM_W*8-1*6, 145, NUM_W, NUM_H);
            case NUMBER_MINUS:      return img.getSubimage(12+NUM_W*10-1*8, 145, NUM_W, NUM_H);
            case NUMBER_NULL:       return img.getSubimage(12+NUM_W*11-1*9, 145, NUM_W, NUM_H);
            case SMILE:             return img.getSubimage(13, 169, FACE_SIDE, FACE_SIDE);
            case PRESSED_SMILE:     return img.getSubimage(13+FACE_SIDE, 169, FACE_SIDE, FACE_SIDE);
            case SHOCKED_FACE:      return img.getSubimage(13+FACE_SIDE*2, 169, FACE_SIDE, FACE_SIDE);
            case SUNGLASSES_FACE:   return img.getSubimage(13+FACE_SIDE*3-1, 169, FACE_SIDE, FACE_SIDE);
            case SAD_FACE:          return img.getSubimage(13+FACE_SIDE*4-2, 169, FACE_SIDE, FACE_SIDE);
            case COVERED_TILE:      return img.getSubimage(13, 194, TILE_SIDE, TILE_SIDE);
            case EMPTY_TILE:        return img.getSubimage(13+TILE_SIDE, 194, TILE_SIDE, TILE_SIDE);
            case FLAG:              return img.getSubimage(13+TILE_SIDE*2-1, 194, TILE_SIDE, TILE_SIDE);
            case UNTRIGGERED_MINE:  return img.getSubimage(13+TILE_SIDE*5-4, 194, TILE_SIDE, TILE_SIDE);
            case TRIGGERED_MINE:    return img.getSubimage(13+TILE_SIDE*6-5, 194, TILE_SIDE, TILE_SIDE);
            case MINE_ERROR:        return img.getSubimage(13+TILE_SIDE*7-6, 194, TILE_SIDE, TILE_SIDE);
            case TILE_1:            return img.getSubimage(13, 211, TILE_SIDE, TILE_SIDE);
            case TILE_2:            return img.getSubimage(13+TILE_SIDE, 211, TILE_SIDE, TILE_SIDE);
            case TILE_3:            return img.getSubimage(13+TILE_SIDE*2-1, 211, TILE_SIDE, TILE_SIDE);
            case TILE_4:            return img.getSubimage(13+TILE_SIDE*3-2, 211, TILE_SIDE, TILE_SIDE);
            case TILE_5:            return img.getSubimage(13+TILE_SIDE*4-3, 211, TILE_SIDE, TILE_SIDE);
            case TILE_6:            return img.getSubimage(13+TILE_SIDE*5-4, 211, TILE_SIDE, TILE_SIDE);
            case TILE_7:            return img.getSubimage(13+TILE_SIDE*6-5, 211, TILE_SIDE, TILE_SIDE);
            case TILE_8:            return img.getSubimage(13+TILE_SIDE*7-6, 211, TILE_SIDE, TILE_SIDE);
            default:                return null;
        }
        
    }
}
