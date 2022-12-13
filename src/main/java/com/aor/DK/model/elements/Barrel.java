package com.aor.DK.model.elements;

import java.util.Random;

public class Barrel extends Element {
    public Barrel(int x, int y) {
        super(x, y);
    }

    public boolean isHeavy() {
        Random random = new Random();
        return random.nextInt() % 6 == 0;
    }
}
