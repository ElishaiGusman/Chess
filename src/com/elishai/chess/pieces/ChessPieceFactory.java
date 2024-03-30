package com.elishai.chess.pieces;

import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.pieces.*;

public class ChessPieceFactory {

    public ChessPiece fromChar(char c, Position position) {
        return switch (c) {
            case 'p' -> new Pawn(Color.BLACK, position);
            case 'P' -> new Pawn(Color.WHITE, position);
            case 'r' -> new Rook(Color.BLACK, position);
            case 'R' -> new Rook(Color.WHITE, position);
            case 'n' -> new Knight(Color.BLACK, position);
            case 'N' -> new Knight(Color.WHITE, position);
            case 'b' -> new Bishop(Color.BLACK, position);
            case 'B' -> new Bishop(Color.WHITE, position);
            case 'q' -> new Queen(Color.BLACK, position);
            case 'Q' -> new Queen(Color.WHITE, position);
            case 'k' -> new King(Color.BLACK, position);
            case 'K' -> new King(Color.WHITE, position);
            default -> throw new RuntimeException("Unknown char for a chess piece!");
        };
    }
}
