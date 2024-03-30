package com.elishai.chess.gamestatedeterminers;

import com.elishai.chess.board.Board;
import com.elishai.chess.Color;

public abstract class GameStateDeterminer {
    public abstract GameState determine(Board board, Color colorToMove);
}
