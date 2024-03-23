package com.elishai.chess;

public class PositionShift {
    private final int columnShift;
    private final int rowShift;

    public PositionShift(int columnShift, int rowShift) {
        this.columnShift = columnShift;
        this.rowShift = rowShift;
    }

    public int getColumnShift() {
        return columnShift;
    }

    public int getRowShift() {
        return rowShift;
    }
}
