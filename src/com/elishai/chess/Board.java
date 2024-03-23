package com.elishai.chess;
import com.elishai.chess.pieces.*;

import java.util.HashMap;

public class Board {
    HashMap<Position, ChessPiece> board = new HashMap<>();

    public void setPiece(Position position, ChessPiece chessPiece) {
        chessPiece.setPosition(position);
        board.put(position, chessPiece);
    }

    public void removePiece(Position position) {
        board.remove(position);
    }

    public void movePiece(Position from, Position to) {
        ChessPiece piece = getChessPiece(from);

        removePiece(from);
        setPiece(to, piece);
    }

    public void setupChessPieces() {
        for(Column column : Column.values()) {
            setPiece(new Position(column, 2), new Pawn(Color.WHITE, new Position(column, 2)));
            setPiece(new Position(column, 7), new Pawn(Color.BLACK, new Position(column, 7)));
        }

        //set rooks
        setPiece(new Position(Column.A, 1), new Rook(Color.WHITE, new Position(Column.A, 1)));
        setPiece(new Position(Column.H, 1), new Rook(Color.WHITE, new Position(Column.H, 1)));
        setPiece(new Position(Column.A, 8), new Rook(Color.BLACK, new Position(Column.A, 8)));
        setPiece(new Position(Column.H, 8), new Rook(Color.BLACK, new Position(Column.H, 8)));

        //set knights
        setPiece(new Position(Column.B, 1), new Knight(Color.WHITE, new Position(Column.B, 1)));
        setPiece(new Position(Column.G, 1), new Knight(Color.WHITE, new Position(Column.G, 1)));
        setPiece(new Position(Column.B, 8), new Knight(Color.BLACK, new Position(Column.B, 8)));
        setPiece(new Position(Column.G, 8), new Knight(Color.BLACK, new Position(Column.G, 8)));

        //set bishops
        setPiece(new Position(Column.C, 1), new Bishop(Color.WHITE, new Position(Column.C, 1)));
        setPiece(new Position(Column.F, 1), new Bishop(Color.WHITE, new Position(Column.F, 1)));
        setPiece(new Position(Column.C, 8), new Bishop(Color.BLACK, new Position(Column.C, 8)));
        setPiece(new Position(Column.F, 8), new Bishop(Color.BLACK, new Position(Column.F, 8)));

        //set queens
        setPiece(new Position(Column.D, 1), new Queen(Color.WHITE, new Position(Column.D, 1)));
        setPiece(new Position(Column.D, 8), new Queen(Color.BLACK, new Position(Column.D, 8)));

        //set kings
        setPiece(new Position(Column.E, 1), new King(Color.WHITE, new Position(Column.E, 1)));
        setPiece(new Position(Column.E, 8), new King(Color.BLACK, new Position(Column.E, 8)));
    }

    public boolean isCellEmpty(Position position) {
        return !board.containsKey(position);
    }

    public ChessPiece getChessPiece(Position position) {
        return board.get(position);
    }

    public static boolean isCellBlack(Position position) {
        return (((position.getColumn().ordinal() + 1) + position.getRow())%2)==0;
    }
}
