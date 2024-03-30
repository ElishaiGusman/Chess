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

        if(res)
            return isCellAvailableForAttack(newPosition, board);

        return res;
    }

    @Override
    protected boolean isCellAvailableForAttack(Position position, Board board) {
        List<Position> cells;

        if(this.getPosition().getColumn() == position.getColumn())
            cells = Utils.getVerticalCells(this.getPosition(), position);
        else if(this.getPosition().getRow() == position.getRow())
            cells = Utils.getHorizontalCells(this.getPosition(), position);
        else
            cells = Utils.getDiagonalCells(this.getPosition(), position);

        for(Position pos : cells)
            if(!board.isCellEmpty(pos))
                return false;

        return true;
    }
}
