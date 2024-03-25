package com.elishai.chess;

import com.elishai.chess.pieces.ChessPiece;

import java.util.Scanner;
import java.util.Set;

public class InputPosition {

    private static final Scanner scanner = new Scanner(System.in);

    public static Position input() {

        while(true) {
            String line = scanner.nextLine();

            if(line.length() != 2) {
                System.out.println("Invalid input!");
                continue;
            }

            char columnPos = line.charAt(0);
            char rowPos    = line.charAt(1);
            columnPos = Character.isLowerCase(columnPos) ? Character.toUpperCase(columnPos) : columnPos;

            if('A' > columnPos || columnPos > 'H') {
                System.out.println("Invalid input!");
                continue;
            }

            if('0' > rowPos || rowPos > '8') {
                System.out.println("Invalid input!");
                continue;
            }
            rowPos -= '0';
            return new Position(Column.fromChar(columnPos), rowPos);
        }
    }

    public static Position inputPiecePositionForColor(Color color, Board board) {
        while(true) {
            System.out.println("Please enter the coordinates for the piece to move(ex. A1 or A8): ");
            Position position = input();

            if(board.isCellEmpty(position)) {
                System.out.println("The cell " + position.getColumn().toString() + position.getRow() + " is empty.");
                continue;
            }

            ChessPiece chessPiece = board.getChessPiece(position);
            if(chessPiece.getColor() != color) {
                System.out.println("Wrong color!");
                continue;
            }

            Set<Position> availableCells = chessPiece.getAvailableCells(board);
            if(availableCells.isEmpty()) {
                System.out.println("There are no available cells to move.");
                continue;
            }

            return position;
        }
    }

    public static Position inputAvailableCells(Set<Position> positions) {
        while(true) {
            System.out.println("Enter the cell to move for the selected piece: ");
            Position input = input();

            if(!positions.contains(input)) {
                System.out.println("The cell " + input.getColumn().toString() + input.getRow() + " is not available.");
                continue;
            }

            return input;
        }
    }
}
