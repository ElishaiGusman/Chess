package com.elishai.chess;

import java.util.Set;
public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.setupChessPieces();

        Game game = new Game(board);
        game.gameLoop();
    }
}