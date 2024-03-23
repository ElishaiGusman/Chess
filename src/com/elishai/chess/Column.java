package com.elishai.chess;

public enum Column {
    A, B, C, D, E, F, G, H;

    public static Column fromChar(char c) {
        try {
            return Column.valueOf(String.valueOf(c));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
