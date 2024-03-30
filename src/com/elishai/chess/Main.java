package com.elishai.chess;

import com.elishai.chess.board.Board;
import com.elishai.chess.board.BoardFactory;

public class Main {
    public static void main(String[] args) {

        BoardFactory bf = new BoardFactory();
        Board board     = bf.fromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

        Game game = new Game(board);
        game.gameLoop();
    }
}