package com.elishai.chess;

import java.util.HashMap;

public class Board {
    HashMap<Position, ChessPiece> board = new HashMap<>();

    public void setPiece(Position position, ChessPiece chessPiece) {
        chessPiece.position = position;
        board.put(position, chessPiece);
    }

    public void setupChessPieces() {
        //TO-DO
    }
}
