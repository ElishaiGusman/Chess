package com.elishai.chess.pieces;

import com.elishai.chess.*;

import java.util.HashSet;
import java.util.Set;

public class Rook extends LongRangeChessPiece implements IRook {
    public Rook(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        return getRookMoves();
    }
}
