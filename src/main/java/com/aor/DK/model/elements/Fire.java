package com.aor.DK.model.elements;

import java.util.Random;

public class Fire extends Element {

    private final Random random = new Random();

    private String direction;

    private char letter;

    public Fire(int x, int y) {
        super(x, y);
        direction = "right";
        letter = ';';
    }

    public boolean isSmart() {
        return random.nextInt() % 3 == 0;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean movingRight() {
        return direction.equals("right");
    }

    public boolean movingLeft() {
        return direction.equals("left");
    }

    public void switchDirection() {
        if (movingRight()) {
            direction = "left";
            letter = '_';
            return;
        }
        direction = "right";
        letter = ';';
    }

    public char getLetter() {
        return letter;
    }
}