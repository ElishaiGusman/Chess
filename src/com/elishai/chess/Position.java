package com.elishai.chess;

import java.util.Objects;

public class Position {
    private final Column column;
    private final int    row;

    public Position(Column column, int row) {
        this.column = column;
        this.row = row;
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
