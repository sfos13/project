package com.aor.DK.model.arena;

import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Floor;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Stair;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Mario mario;
    private List<Barrel> barrels;
    private List<Floor> floor;
    private List<Stair> stairs;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public List<Barrel> getBarrels() {
        return barrels;
    }

    public void setBarrels(List<Barrel> barrels) {
        this.barrels = barrels;
    }

    public List<Floor> getFloor() {
        return floor;
    }

    public void setFloor(List<Floor> floor) {
        this.floor = floor;
    }

    public List<Stair> getStairs() {
        return stairs;
    }

    public void setStairs(List<Stair> stairs) {
        this.stairs = stairs;
    }

    public void spawnBarrel() {
        barrels.add(new Barrel(1,height-3));
    }
}
