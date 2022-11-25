package com.aor.DK.model.elements;

public class Mario extends Element{

    private float vy;

    public Mario(int x, int y) {
        super(x, y);
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }
    public void incrementVy(float value) {
        this.vy += value;
    }
}
