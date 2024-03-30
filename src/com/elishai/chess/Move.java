package com.elishai.chess;

public class Move {
    private final Position to, from;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Position getFrom() {
        return from;
    }
    public Position getTo() {
        return to;
    }
}
