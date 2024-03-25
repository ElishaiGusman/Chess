package com.elishai.chess.pieces;

import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.pieces.*;

public class ChessPieceFactory {

    public ChessPiece fromChar(char c, Position position) {
        switch (c) {
            case 'p':
                return new Pawn(Color.BLACK, position);
            case 'P':
                return new Pawn(Color.WHITE, position);

            case 'r':
                return new Rook(Color.BLACK, position);
            case 'R':
                return new Rook(Color.WHITE, position);

            case 'n':
                return new Knight(Color.BLACK, position);
            case 'N':
                return new Knight(Color.WHITE, position);

            case 'b':
                return new Bishop(Color.BLACK, position);
            case 'B':
                return new Bishop(Color.WHITE, position);

            case 'q':
                return new Queen(Color.BLACK, position);
            case 'Q':
                return new Queen(Color.WHITE, position);

            case 'k':
                return new King(Color.BLACK, position);
            case 'K':
                return new King(Color.WHITE, position);

            default:
                throw new RuntimeException("Unknown char for a chess piece!");
        }
    }
}
