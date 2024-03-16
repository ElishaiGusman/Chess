package com.elishai.chess;

import com.elishai.chess.pieces.Pawn;

import java.util.HashMap;

public class Board {
    HashMap<Position, ChessPiece> board = new HashMap<>();

    public void setPiece(Position position, ChessPiece chessPiece) {
        chessPiece.setPosition(position);
        board.put(position, chessPiece);
    }

    public void setupChessPieces() {
        for(Column column : Column.values()) {
            setPiece(new Position(column, 2), new Pawn(Color.WHITE, new Position(column, 2)));
            setPiece(new Position(column, 7), new Pawn(Color.BLACK, new Position(column, 7)));
        }
    }
}
