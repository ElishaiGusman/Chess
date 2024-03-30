package com.elishai.chess.gamestatedeterminers;

import com.elishai.chess.*;
import com.elishai.chess.board.Board;
import com.elishai.chess.board.BoardFactory;
import com.elishai.chess.pieces.ChessPiece;
import com.elishai.chess.pieces.King;

import java.util.List;
import java.util.Set;

public class CheckMateGameStateDeterminer extends GameStateDeterminer {

    @Override
    public GameState determine(Board board, Color colorToMove) {

        ChessPiece king = board.getAllChessPiecesByColor(colorToMove).stream().filter(chessPiece -> chessPiece instanceof King).findFirst().get();

        if(!board.isCellUnderAttack(king.getPosition(), colorToMove.opposite()))
            return GameState.ONGOING;

        List<ChessPiece> chessPieces = board.getAllChessPiecesByColor(colorToMove);
        for(ChessPiece chessPiece : chessPieces) {
            Set<Position> availableCells = chessPiece.getAvailableCells(board);

            for (Position availableCell : availableCells) {
                Board cloneBoard = (new BoardFactory()).cloneBoard(board);
                cloneBoard.movePiece(new Move(chessPiece.getPosition(), availableCell));

                king = cloneBoard.getAllChessPiecesByColor(colorToMove).stream().filter(chessPiece1 -> chessPiece1 instanceof King).findFirst().get();
                if(!cloneBoard.isCellUnderAttack(king.getPosition(), colorToMove.opposite()))
                    return GameState.ONGOING;
            }
        }

        if(colorToMove == Color.WHITE)
            return GameState.CHECKMATE_WKING;
        else
            return GameState.CHECKMATE_BKING;
    }
}
