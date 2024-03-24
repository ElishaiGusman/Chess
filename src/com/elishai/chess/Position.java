package com.elishai.chess;

import java.util.Objects;

public class Position {
    private final Column column;
    private final int    row;

    public Position(Column column, int row) {
        this.column = column;
        this.row = row;
    }

    public Position shift(PositionShift shift) {
        return new Position(Column.values()[this.getColumn().ordinal() + shift.getColumnShift()],
                            this.getRow() + shift.getRowShift());
    }

    public boolean isShiftPossible(PositionShift shift) {
        int c = this.getColumn().ordinal() + shift.getColumnShift();
        int r = this.getRow() + shift.getRowShift();

        if(c < 0 || c > 7)
            return false;
        return r >= 1 && r <= 8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    public Column getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
