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
        DisplayCoveredMap();
        DisplayMap();
    }

    private void GenerateBoard(){
        for(int i=0; i<size.getAmountOfMines(); i++){
            int x = rand.nextInt(size.getColumns());
            int y = rand.nextInt(size.getRows());

            if(tiles[y][x] == TileType.EMPTY_TILE) 
                tiles[y][x] = TileType.UNTRIGGERED_MINE;
            else i--;
        }
        
        DisplayMap();

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

        tiles[x][y] = new ImageHandler().getNumberedTileType(counter);
    }

    public TileType[][] getTileBoard(){
        return tiles;
    }

    public Boolean[][] getCoveredBoard(){
        return coverBoard;
    }

    //TODO: do usunieicia
    private void DisplayCoveredMap(){
        for(int i=0; i<size.getRows(); i++){
            for(int j=0; j<size.getColumns(); j++){
                int num;
                if(coverBoard[i][j]) num=1; else num=0;
                System.out.print("[" + num + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    //TODO: do usunieicia
    private void DisplayMap(){
        for(int i=0; i<size.getRows(); i++){
            for(int j=0; j<size.getColumns(); j++){
                char num=' ';
                if(tiles[i][j]==TileType.FLAG) num='f';
                else if (tiles[i][j]==TileType.EMPTY_TILE) num=' ';
                else if (tiles[i][j]==TileType.MINE_ERROR) num='e';
                else if (tiles[i][j]==TileType.TILE_1) num='1';
                else if (tiles[i][j]==TileType.TILE_2) num='2';
                else if (tiles[i][j]==TileType.TILE_3) num='3';
                else if (tiles[i][j]==TileType.TILE_4) num='4';
                else if (tiles[i][j]==TileType.TILE_5) num='5';
                else if (tiles[i][j]==TileType.TILE_6) num='6';
                else if (tiles[i][j]==TileType.TILE_7) num='7';
                else if (tiles[i][j]==TileType.TILE_8) num='8';
                else if (tiles[i][j]==TileType.TRIGGERED_MINE) num='M';
                else if (tiles[i][j]==TileType.UNTRIGGERED_MINE) num='m';
                

                System.out.print("[" + Character.toString(num) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
}
