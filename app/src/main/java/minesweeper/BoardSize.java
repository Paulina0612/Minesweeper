package minesweeper;

public enum BoardSize {
    SMALL(9, 9),
    MEDIUM(16, 16),
    LARGE(16, 30);

    private int columns;
    private int rows;

    BoardSize(int c, int r){
        this.columns = c;
        this.rows = r;
    }

    public int getColumns(){ return columns; }
    public int getRows(){ return rows; }
}
