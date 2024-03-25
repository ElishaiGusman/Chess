package com.elishai.chess.pieces;

import com.elishai.chess.PositionShift;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {

    default Set<PositionShift> getBishopMoves() {
        Set<PositionShift> res = new HashSet<>();

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            res.add(new PositionShift(i, i));
        }

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            res.add(new PositionShift(i, -i));
        }

        return res;
    }
}
