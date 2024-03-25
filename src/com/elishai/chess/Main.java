package com.elishai.chess;

public class Main {
    public static void main(String[] args) {

        BoardFactory bf = new BoardFactory();
        Board board     = bf.fromFEN("k7/4r1R1/8/4Q3/6n1/6n1/4B3/1K6 w - - 0");

        Game game = new Game(board);
        game.gameLoop();
    }
}