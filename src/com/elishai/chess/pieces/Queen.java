package com.elishai.chess.pieces;

import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.PositionShift;

import java.util.Set;

public class Queen extends LongRangeChessPiece implements IBishop, IRook {
    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        Set<PositionShift> cells = getBishopMoves();
        cells.addAll(getRookMoves());

        return cells;
    }
}
