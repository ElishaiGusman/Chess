package com.elishai.chess;

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
