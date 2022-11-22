package com.aor.DK.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PositionTest {
    private Position position;

    @Test
    void getLeft(int x, int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Test
    void getRight(int x, int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Test
    void getUp(int x, int y) {
        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Test
    void getDown(int x, int y) {
        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }
}

