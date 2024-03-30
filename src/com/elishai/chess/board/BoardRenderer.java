package com.elishai.chess.board;

import com.elishai.chess.Color;
import com.elishai.chess.Column;
import com.elishai.chess.Position;
import com.elishai.chess.board.Board;
import com.elishai.chess.pieces.ChessPiece;

import java.util.Set;

import static java.util.Collections.emptySet;

public class BoardRenderer {

    //ANSI colors constants:
    public static final String RESET_COLOR      = "\u001B[0m";
    public static final String WHITE_PIECE      = "\u001B[97m";      //White high intensity
    public static final String BLACK_PIECE      = "\u001B[30m";      //Black regular
    public static final String WHITE_CELL       = "\u001B[47m";      //White Background
    public static final String BLACK_CELL       = "\u001B[0;100m";   //Black high intensity
    public static final String HIGHLIGHTED_CELL = "\u001B[45m";

    public void render(Board board, ChessPiece pieceToMove) {
        for(int row = 8; row >=1; row--) {
            Set<Position> availableCells = emptySet();

            if(pieceToMove != null)
                availableCells = pieceToMove.getAvailableCells(board);

            StringBuilder boardRow = new StringBuilder();
            for(Column column: Column.values()) {

                Position position   = new Position(column, row);
                boolean isHighlighted = availableCells.contains(position);

                if (board.isCellEmpty(position)) {
                    boardRow.append(getEmptyCellSprite(position, isHighlighted));
                } else {
                    boardRow.append(getChessPieceSprite(board.getChessPiece(position), isHighlighted));
                }
            }

            boardRow.append(RESET_COLOR);
            System.out.println(boardRow.toString());
        }
    }

    public void render(Board board) {
        render(board, null);
    }

    private String getEmptyCellSprite(Position position, boolean isHighlighted) {
        return colorSprite("    ", Color.WHITE, Board.isCellBlack(position), isHighlighted);
    }

    private String getChessPieceSprite(ChessPiece chessPiece, boolean isHighlighted) {
        return colorSprite(" " + selectSpriteForChessPiece(chessPiece) + " ",
                chessPiece.getColor(), Board.isCellBlack(chessPiece.getPosition()), isHighlighted);
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

    private String colorSprite(String sprite, Color pieceColor, boolean isCellBlack, boolean isHighlighted) {
        //format = backGround_color + font_color + text

        StringBuilder result = new StringBuilder(sprite);

        if(pieceColor == Color.WHITE)
            result.insert(0, WHITE_PIECE);
        else
            result.insert(0, BLACK_PIECE);

        if(isHighlighted)
            result.insert(0, HIGHLIGHTED_CELL);
        else if(isCellBlack)
            result.insert(0, BLACK_CELL);
        else
            result.insert(0, WHITE_CELL);

        return result.toString();
    }
}
