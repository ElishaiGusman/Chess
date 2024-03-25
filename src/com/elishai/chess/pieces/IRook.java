package com.elishai.chess.pieces;

import com.elishai.chess.PositionShift;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<PositionShift> getRookMoves() {
        Set<PositionShift> res = new HashSet<>();

        //for columns
        for(int i = -7; i <= 7; i++) {
            if(i==0) continue;

            res.add(new PositionShift(i, 0));
        }

        //for rows
        for(int i = -7; i <= 7; i++) {
            if(i==0) continue;

            res.add(new PositionShift(0, i));
        }

        return res;
    }
}
