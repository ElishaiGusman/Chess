package com.elishai.chess.pieces;

import com.elishai.chess.*;

import java.util.Set;

public class Bishop extends LongRangeChessPiece implements IBishop {
    public Bishop(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        return getBishopMoves();
    }
}
