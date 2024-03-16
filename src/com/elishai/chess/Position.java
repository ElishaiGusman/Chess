package com.elishai.chess;

public class Position {
    private Column column;
    private int    row;

    public Position(Column column, int row) {
        this.column = column;
        this.row = row;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
