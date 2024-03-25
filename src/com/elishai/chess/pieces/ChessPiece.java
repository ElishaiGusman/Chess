package com.elishai.chess.pieces;

import com.elishai.chess.Board;
import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.PositionShift;

import java.util.HashSet;
import java.util.Set;

/*Every single chess piece has:
* 1) com.elishai.chess.Color
* 2) Position on a board
*    Position is a pair of two values: - a letter from 'A' to 'F'
*                                      - a number from  1  to  8*/
public abstract class ChessPiece {
    private final Color color;
    private Position position;

    public ChessPiece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Set<Position> getAvailableCells(Board board) {
        Set<Position> result = new HashSet<>();

        for(PositionShift shift: getAvailableMoves())
            if(this.getPosition().isShiftPossible(shift)) {
                Position newPosition = this.getPosition().shift(shift);
                if(isCellAvailableForMove(newPosition, board))
                    result.add(newPosition);
            }
        return result;
    }

    protected boolean isCellAvailableForMove(Position newPosition, Board board) {
        return board.isCellEmpty(newPosition) || board.getChessPiece(newPosition).getColor() != this.getColor();
    }

    protected abstract Set<PositionShift> getAvailableMoves();


    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
