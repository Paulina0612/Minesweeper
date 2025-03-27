package minesweeper;

public enum BoardSize {
    SMALL(9, 9, 10),
    MEDIUM(16, 16, 40),
    LARGE(16, 30, 99);

    private int columns;
    private int rows;
    private int amountOfMines;

    BoardSize(int c, int r, int m){
        this.columns = c;
        this.rows = r;
        this.amountOfMines = m;
    }

    public int getColumns(){ return columns; }
    public int getRows(){ return rows; }
    public int getAmountOfMines(){ return amountOfMines; }
}
