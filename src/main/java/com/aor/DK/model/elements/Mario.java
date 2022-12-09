package com.aor.DK.model.elements;

public class Mario extends Element{

    private float vy;
    private char letter;

    public Mario(int x, int y) {
        super(x, y);
        stationaryRight();
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

    public char getLetter() {
        return letter;
    }

    public void stationaryRight() {
        this.letter = ',';
    }

    public void stationaryLeft() {
        this.letter = '-';
    }
    public void runningLeft() {
        this.letter = '.';
    }

    public void runningRight() {
        this.letter = '*';
    }

    public void goingUp() {
        this.letter = '/';
    }

    public void goingUp2() {
        this.letter = ':';
    }

    public void movingRight() {
        if(letter == ',') {
            runningRight();
            return;
        }
        stationaryRight();
    }

    public void movingLeft() {
        if(letter == '-') {
            runningLeft();
            return;
        }
        stationaryLeft();
    }

    public void climbingStairs() {
        if(letter == '/') {
            goingUp2();
            return;
        }
        goingUp();
    }

    public void stationary() {
        if(letter == '*') {
            stationaryRight();
            return;
        }
        if(letter == '.') {
            stationaryLeft();
            return;
        }
        stationaryRight();
    }
}
