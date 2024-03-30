package com.elishai.chess;

import com.elishai.chess.board.Board;
import com.elishai.chess.board.BoardRenderer;
import com.elishai.chess.gamestatedeterminers.CheckMateGameStateDeterminer;
import com.elishai.chess.gamestatedeterminers.GameState;
import com.elishai.chess.gamestatedeterminers.GameStateDeterminer;
import com.elishai.chess.gamestatedeterminers.StaleMateGameDeterminer;

import java.util.List;

public class Game {

    private final Board board;
    private final BoardRenderer renderer;
    private final List<GameStateDeterminer> determiners;

    public Game(Board board) {
        this.board  = board;
        renderer    = new BoardRenderer();
        determiners = List.of(new StaleMateGameDeterminer(),
                              new CheckMateGameStateDeterminer());
    }

    public void gameLoop() {
        Color colorToMove = Color.WHITE;
        GameState state = determineGameState(board, colorToMove);

        while(state == GameState.ONGOING) {
            renderer.render(board);

            if(colorToMove == Color.WHITE)
                System.out.println("White turn.");
            else
                System.out.println("Black turn.");

            Move move = InputPosition.getInputMove(board, colorToMove, renderer);
            board.movePiece(move);

            colorToMove = colorToMove.opposite();

            state = determineGameState(board, colorToMove);
        }

        renderer.render(board);
        System.out.println("The game is ended!");

        switch (state) {
            case STALEMATE -> System.out.println("STALEMATE");
            case CHECKMATE_WKING -> System.out.println("BLACKS WIN!");
            case CHECKMATE_BKING -> System.out.println("WHITES WIN!");
            default -> System.out.println("How did you get this far?");
        }
    }

    private GameState determineGameState(Board board, Color color) {
        for(GameStateDeterminer determiner : determiners) {
            GameState state = determiner.determine(board, color);

            if(state != GameState.ONGOING)
                return state;
        }

        return GameState.ONGOING;
    }
}