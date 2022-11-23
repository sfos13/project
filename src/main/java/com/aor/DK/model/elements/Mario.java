package com.aor.DK.model.elements;

public class Mario extends Element{

    private float vy;
    private boolean inAir;

    public Mario(int x, int y) {
        super(x, y);
        inAir = false;
    }


    public boolean isInAir() {
        return inAir;
    }

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
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
