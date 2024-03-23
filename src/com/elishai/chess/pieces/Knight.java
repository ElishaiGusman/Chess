package com.elishai.chess.pieces;

import com.elishai.chess.ChessPiece;
import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.PositionShift;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends ChessPiece {
    public Knight(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Set<PositionShift> getAvailableMoves() {
        return new HashSet<>(Arrays.asList(
                //First quarter
                new PositionShift(1,2),
                new PositionShift(2,1),
                //Second quarter
                new PositionShift(2,-1),
                new PositionShift(1,-2),
                //Third quarter
                new PositionShift(-1,-2),
                new PositionShift(-2,-1),
                //Fourth quarter
                new PositionShift(-2,1),
                new PositionShift(-1,2)
        ));
    }


}
