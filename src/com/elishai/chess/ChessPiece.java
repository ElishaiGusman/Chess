package com.elishai.chess;

/*Every single chess piece has:
* 1) com.elishai.chess.Color
* 2) Position on a board
*    Position is a pair of two values: - a letter from 'A' to 'F'
*                                      - a number from  1  to  8*/
abstract class ChessPiece {
    Color color;
    Position position;

    public ChessPiece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }
}
