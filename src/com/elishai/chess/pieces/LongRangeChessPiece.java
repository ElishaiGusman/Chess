package com.elishai.chess.pieces;

import com.elishai.chess.*;

import java.util.List;
import java.util.Set;

public class LongRangeChessPiece extends ChessPiece{

    public LongRangeChessPiece(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        return null;
    }

    @Override
    protected boolean isCellAvailableForMove(Position newPosition, Board board) {
        boolean res = super.isCellAvailableForMove(newPosition, board);

        if(res) {
            List<Position> cells;

            if(this.getPosition().getColumn() == newPosition.getColumn())
                cells = Utils.getVerticalCells(this.getPosition(), newPosition);
            else if(this.getPosition().getRow() == newPosition.getRow())
                cells = Utils.getHorizontalCells(this.getPosition(), newPosition);
            else
                cells = Utils.getDiagonalCells(this.getPosition(), newPosition);

            for(Position pos : cells)
                if(!board.isCellEmpty(pos))
                    return false;
        }

        return res;
    }
}
