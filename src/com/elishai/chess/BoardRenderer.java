package com.elishai.chess;

import java.awt.*;

public class BoardRenderer {

    //ANSI colors constants:
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String WHITE_PIECE = "\u001B[97m";     //White high intensity
    public static final String BLACK_PIECE = "\u001B[30m";     //Black regular
    public static final String WHITE_CELL  = "\u001B[47m";      //White Background
    public static final String BLACK_CELL  = "\u001B[0;100m";   //Black high intensity

    public void render(Board board) {
        for(int row = 8; row >=1; row--) {

            StringBuilder boardRow = new StringBuilder();
            for(Column column: Column.values()) {

                Position position = new Position(column, row);
                if (board.isCellEmpty(position)) {
                    boardRow.append(getEmptyCellSprite(position));
                } else {
                    boardRow.append(getChessPieceSprite(board.getChessPiece(position)));
                }
            }

            boardRow.append(RESET_COLOR);
            System.out.println(boardRow.toString());
        }
    }

    private String getEmptyCellSprite(Position position) {
        return colorSprite("    ", Color.WHITE, Board.isCellBlack(position));
    }

    private String getChessPieceSprite(ChessPiece chessPiece) {
        return colorSprite(" " + selectSpriteForChessPiece(chessPiece) + " ",
                chessPiece.getColor(), Board.isCellBlack(chessPiece.getPosition()));
    }

    private String selectSpriteForChessPiece(ChessPiece chessPiece) {
        return switch (chessPiece.getClass().getSimpleName()) {
            case "Pawn"   -> "♙";
            case "Knight" -> "♘";
            case "Bishop" -> "♗";
            case "Rook"   -> "♖";
            case "Queen"  -> "♕";
            case "King"   -> "♔";
            default       -> "";
        };

    }

    private String colorSprite(String sprite, Color pieceColor, boolean isCellBlack) {
        StringBuilder result = new StringBuilder(sprite);

        if(pieceColor == Color.WHITE)
            result.insert(0, WHITE_PIECE);
        else
            result.insert(0, BLACK_PIECE);

        if(isCellBlack)
            result.insert(0, BLACK_CELL);
        else
            result.insert(0, WHITE_CELL);

        return result.toString();
    }
}
