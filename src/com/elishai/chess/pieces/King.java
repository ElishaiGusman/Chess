package com.elishai.chess.pieces;

import com.elishai.chess.Board;
import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.PositionShift;

import java.util.HashSet;
import java.util.Set;

public class King extends ChessPiece {
    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        Set<PositionShift> res = new HashSet<>();

        for(int i = -1; i <= 1; i++)
            for(int j = -1; j<=1; j++) {
                if (i == 0 && j == 0)
                    continue;
                res.add(new PositionShift(i, j));
            }

        return res;
    }

    @Override
    protected boolean isCellAvailableForMove(Position newPosition, Board board) {
        boolean res = super.isCellAvailableForMove(newPosition, board);

        if(res) {
            return !board.isCellUnderAttack(newPosition, this.getColor().opposite());
        }

        return res;
    }
}
