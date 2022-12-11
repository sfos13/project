package com.aor.DK.model.arena;

import com.aor.DK.model.Position;
import com.aor.DK.model.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Position spawnFirePosition1;

    private Position spawnFirePosition2;
    private Position spawnBarrelPosition;
    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;
    private List<Barrel> barrels;
    private List<List<Floor>> floor;
    private List<Stair> stairs;
    private List<Fire> fireMonsters;
    private boolean spawnFlag;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.barrels = new ArrayList<>();
        this.fireMonsters = new ArrayList<>();
        spawnFlag = true;
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
        if(spawnBarrelPosition == null) return;
        barrels.add(new Barrel(spawnBarrelPosition.getX(),spawnBarrelPosition.getY()));
    }

    public boolean outOfBounds(Position position) {
        return !(position.getX() >= 0 && position.getX() < width);
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
    public boolean isOnFloor(Position position) {
        for(List<Floor> storey : floor) {
            for(Floor floor : storey)
                if(position.getY()+1 == (floor.getPosition().getY()) && position.getX() == floor.getPosition().getX()) {
                    return true;
                }
        }
        return false;
    }

    public boolean checkStairs(Position position) {
        for(Stair stair : stairs) {
            if((position.equals(stair.getPosition()))){
                return true;
            }
        }
        return false;
    }

    public boolean checkUnderStairs(Position position) {
        return checkStairs(new Position(position.getX(), position.getY()+1));
    }

    public boolean crash(Position position) {
        if(getDonkeyKong().getPosition().equals(position)) {
            return true;
        }
        if(barrels != null) for(Barrel barrel : barrels) {
            if(barrel.getPosition().equals(position)) {
                return true;
            }
        }
        if(fireMonsters != null ) for (Fire fire : fireMonsters) {
            if(fire.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }


    public List<Fire> getFireMonsters() {
        return fireMonsters;
    }


    public void spawnFire() {
        if(spawnFirePosition1 == null) return;
        if(spawnFlag) {
            fireMonsters.add(new Fire(spawnFirePosition1.getX(),spawnFirePosition1.getY()));
            spawnFlag = false;
            return;
        }
        fireMonsters.add(new Fire(spawnFirePosition2.getX(),spawnFirePosition2.getY()));
        spawnFlag = true;
    }

    public void setSpawnFirePosition(Position spawnFirePosition, int spawnNumber) {
        if(spawnNumber == 1) this.spawnFirePosition1 = spawnFirePosition;
        if(spawnNumber == 2) this.spawnFirePosition2 = spawnFirePosition;
    }
}
