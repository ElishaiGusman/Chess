package com.elishai.chess;

import com.elishai.chess.pieces.ChessPieceFactory;

public class BoardFactory {
    private final ChessPieceFactory chessPieceFactory = new ChessPieceFactory();

    public Board fromFEN(String fen) {
        Board board = new Board();

        String[] parts     = fen.split(" ");
        String boardState  = parts[0];

        String[] boardRows = boardState.split("/");

        for(int i = 0; i < boardRows.length; i++) {
            String currentRow = boardRows[i];
            int row           = 8 - i;

            int columnIndex = 0;
            for(int j = 0; j < currentRow.length(); j++) {
                char currentChar = currentRow.charAt(j);

                if(Character.isDigit(currentChar)) {
                    columnIndex += Character.getNumericValue(currentChar);
                } else {
                    Column column     = Column.values()[columnIndex];
                    Position position = new Position(column, row);

                    board.setPiece(position, chessPieceFactory.fromChar(currentChar, position));
                    columnIndex++;
                }
            }
        }

        return board;
    }
}