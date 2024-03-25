package com.elishai.chess.pieces;

import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.PositionShift;

import java.util.Set;

public class King extends ChessPiece {
    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        return null;
    }
}
