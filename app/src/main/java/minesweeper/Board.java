package minesweeper;

import java.util.Random;
import minesweeper.images.ImageHandler;

public class Board {
    private BoardSize size = null;
    private TileType tiles[][] = null;
    private Boolean coverBoard[][] = null;
    private Random rand = new Random();

    public Board(BoardSize size){
        this.size = size;
        tiles = new TileType[size.getRows()][size.getColumns()];
        coverBoard = new Boolean[size.getRows()][size.getColumns()];

        for (int i=0; i<size.getRows(); i++) {
            for (int j=0; j<size.getColumns(); j++) {
                coverBoard[i][j] = true; 
            }
        }
        for (int i=0; i<size.getRows(); i++) {
            for (int j=0; j<size.getColumns(); j++) {
                tiles[i][j] = TileType.EMPTY_TILE; 
            }
        }
        GenerateBoard();
    }

    private void GenerateBoard(){
        for(int i=0; i<size.getAmountOfMines(); i++){
            int x = rand.nextInt(size.getColumns());
            int y = rand.nextInt(size.getRows());

            if(tiles[y][x] == TileType.EMPTY_TILE) 
                tiles[y][x] = TileType.UNTRIGGERED_MINE;
            else i--;
        }

        for(int i=0; i<size.getRows(); i++){
            for(int j=0; j<size.getColumns(); j++){
                PutTileNumber(j, i);
            }
        }
    }

    private void PutTileNumber(int x, int y){
        if(tiles[x][y] == TileType.UNTRIGGERED_MINE)
            return;
                
            int counter=0;

            for(int a=-1; a<2; a++){
                for(int b=-1; b<2; b++){
                    if(a==0 && b==0) continue;
                    else if(x+a<0 || y+b<0 || 
                        x+a>size.getColumns()-1 || y+b>size.getRows()-1)
                            continue;
                    else if (tiles[x+a][y+b]==TileType.UNTRIGGERED_MINE)
                        counter++;
                }
            }

        tiles[x][y] = ImageHandler.getNumberedTileType(counter);
    }

    public TileType[][] getTileBoard(){
        return tiles;
    }

    public Boolean[][] getCoveredBoard(){
        return coverBoard;
    }

    public Position GetPosition(int index){
        // Find position 
        int x=0, y=0;
        for(int i=0;;i++){
            if(index-(i+1)*size.getColumns() < 0) {
                x=i;
                y=index-(x*size.getColumns());
                break;
            }
        }
        
        return new Position(x, y);
    }

    public void MoveMine(int index){
        Position minePosition = GetPosition(index);

        tiles[minePosition.y][minePosition.x] = TileType.EMPTY_TILE;

        // Generate new mine 
        while (true){
            int x = rand.nextInt(size.getColumns());
            int y = rand.nextInt(size.getRows());

            if(tiles[y][x] != TileType.UNTRIGGERED_MINE) {
                tiles[y][x] = TileType.UNTRIGGERED_MINE;
                break;
            }
            else continue;
        }

        for(int i=0; i<size.getRows(); i++){
            for(int j=0; j<size.getColumns(); j++){
                PutTileNumber(j, i);
            }
        }
    }

    public BoardSize GetSize(){
        return size;
    }
}
