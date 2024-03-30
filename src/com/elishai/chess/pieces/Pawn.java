package com.elishai.chess.pieces;

import com.elishai.chess.Board;
import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.PositionShift;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends ChessPiece {
    public Pawn(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        Set<PositionShift> res = new HashSet<>();
        if(this.getColor() == Color.WHITE) {
            res.add(new PositionShift(0, 1));

            if(this.getPosition().getRow() == 2)
                res.add(new PositionShift(0, 2));

            res.add(new PositionShift(-1, 1));
            res.add(new PositionShift(1, 1));
        }
        else {
            res.add(new PositionShift(0, -1));

            if(this.getPosition().getRow() == 7)
                res.add(new PositionShift(0, -2));

            res.add(new PositionShift(-1, -1));
            res.add(new PositionShift(1, -1));
        }
        return res;
    }

    @Override
    protected boolean isCellAvailableForMove(Position newPosition, Board board) {
        if(this.getPosition().getColumn() == newPosition.getColumn())
            return board.isCellEmpty(newPosition);
        else {
            if(board.isCellEmpty(newPosition))
                return false;
            else
                return board.getChessPiece(newPosition).getColor() != this.getColor();
        }
    }

    @Override
    protected Set<PositionShift> getPieceAttacks() {
        Set<PositionShift> res = new HashSet<>();

        if(getColor() == Color.WHITE) {
            res.add(new PositionShift(-1, 1));
            res.add(new PositionShift(1, 1));
        } else {
            res.add(new PositionShift(-1, -1));
            res.add(new PositionShift(1, -1));
        }
        return res;
    }
}
