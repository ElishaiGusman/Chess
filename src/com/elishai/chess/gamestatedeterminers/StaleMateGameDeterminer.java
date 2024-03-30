package com.elishai.chess.gamestatedeterminers;

import com.elishai.chess.board.Board;
import com.elishai.chess.Color;
import com.elishai.chess.Position;
import com.elishai.chess.pieces.ChessPiece;

import java.util.List;
import java.util.Set;

public class StaleMateGameDeterminer extends GameStateDeterminer {

    @Override
    public GameState determine(Board board, Color colorToMove) {
        List<ChessPiece> chessPieces = board.getAllChessPiecesByColor(colorToMove);

        for (ChessPiece chessPiece : chessPieces) {
            Set<Position> availableCells = chessPiece.getAvailableCells(board);

            if(!availableCells.isEmpty())
                return GameState.ONGOING;
        }

        return GameState.STALEMATE;
    }
}
