package com.elishai.chess;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Position> getDiagonalCells(Position from, Position to) {
        List<Position> res = new ArrayList<>();

        int columnShift = from.getColumn().ordinal() < to.getColumn().ordinal() ? 1 : -1;
        int rowShift    = from.getRow() < to.getRow() ? 1 : -1;

        for (int i = from.getColumn().ordinal() + columnShift,
                 j = from.getRow() + rowShift;
                 //loop exit conditions
                 i != to.getColumn().ordinal() && j != to.getRow();
                 //iterators
                 i+=columnShift, j+=rowShift
        ) {
            res.add(new Position(Column.values()[i], j));
        }

        return res;
    }

    public static List<Position> getVerticalCells(Position from, Position to) {
        List<Position> res = new ArrayList<>();

        int rowShift       = from.getRow() < to.getRow() ? 1 : -1;

        for (int i = from.getRow() + rowShift;
            //loop exit conditions
             i!= to.getRow();
            //iterators
             i+=rowShift
        ) {
            res.add(new Position(from.getColumn(), i));
        }

        return res;
    }

    public static List<Position> getHorizontalCells(Position from, Position to) {
        List<Position> res = new ArrayList<>();

        int columnShift = from.getColumn().ordinal() < to.getColumn().ordinal() ? 1 : -1;

        for (int i = from.getColumn().ordinal() + columnShift;
            //loop exit conditions
             i != to.getColumn().ordinal();
            //iterators
             i+=columnShift
        ) {
            res.add(new Position(Column.values()[i], from.getRow()));
        }

        return res;
    }
}
