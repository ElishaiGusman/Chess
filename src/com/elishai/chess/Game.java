package com.elishai.chess;

import com.elishai.chess.pieces.ChessPiece;

import java.util.Set;

public class Game {

    private final Board board;
    private final BoardRenderer renderer;

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

            Move move = InputPosition.getInputMove(this.board, isWhiteToMove ? Color.WHITE : Color.BLACK, this.renderer);
            board.movePiece(move);

            isWhiteToMove =! isWhiteToMove;
        }
    }
}