package com.elishai.chess;

import java.util.Set;

public class Game {

    private final Board board;
    private BoardRenderer renderer;

    public Game(Board board) {
        this.board    = board;
        this.renderer = new BoardRenderer();
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while(true) {
            renderer.render(board);

            if(isWhiteToMove)
                System.out.println("White turn.");
            else
                System.out.println("Black turn.");

            Position fromPosition = InputPosition.inputPiecePositionForColor(isWhiteToMove ? Color.WHITE : Color.BLACK, board);
            ChessPiece chessPiece = board.getChessPiece(fromPosition);
            Set<Position> availableCells = chessPiece.getAvailableCells(board);

            renderer.render(board, chessPiece);

            Position targetPosition = InputPosition.inputAvailableCells(availableCells);
            board.movePiece(fromPosition, targetPosition);

            isWhiteToMove =! isWhiteToMove;
        }
    }
}
