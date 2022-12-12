package com.aor.DK.model.arena;

import com.aor.DK.model.Position;
import com.aor.DK.model.elements.*;
import com.aor.DK.model.ranking.Scores;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Position spawnBarrelPosition;
    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;
    private List<Barrel> barrels;
    private List<List<Floor>> floor;
    private List<Stair> stairs;


    private Scores scores;
    private Level lv;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.barrels = new ArrayList<>();
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

    public List<List<Floor>> getFloor() {
        return floor;
    }

    public void setFloor(List<List<Floor>> floor) {
        this.floor = floor;
    }

    public List<Stair> getStairs() {
        return stairs;
    }

    public DonkeyKong getDonkeyKong() {
        return donkeyKong;
    }

    public Princess getPrincess() {
        return princess;
    }



    public void setStairs(List<Stair> stairs) {
        this.stairs = stairs;
    }

    public void setDonkeyKong(DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }

    public void setPrincess(Princess princess) {
        this.princess = princess;
    }

    public void spawnBarrel() {
        barrels.add(new Barrel(spawnBarrelPosition.getX(),spawnBarrelPosition.getY()));
    }


    public int getFloorNumber(Position position) {
        for(int i = 0; i < floor.size(); i++) {
            for(Floor tile : floor.get(i)) {
                if(position.getX() == tile.getPosition().getX() && position.getY() + 1 == tile.getPosition().getY()) {
                    return i;
                }
            }
        }
        return -1;
    }
    public Position getSpawnBarrelPosition() {
        return spawnBarrelPosition;
    }

    public void setSpawnBarrelPosition(Position spawnBarrelPosition) {
        this.spawnBarrelPosition = spawnBarrelPosition;
    }



    public void setLevelPosition(Level level) {
        this.lv=level;
    }

    public Level getLevelPosition() {
        return lv;
    }


    public Scores getScores() { return scores;}

    public void setScores(Scores scores){
        this.scores= scores;
    }

}
