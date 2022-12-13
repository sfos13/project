package com.aor.DK.model.arena;

import com.aor.DK.model.Position;
import com.aor.DK.model.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setMario(createMario());
        arena.setFloor(createFloor());
        arena.setStairs(createStairs());
        arena.setDonkeyKong(createDonkeyKong());
        arena.setPrincess(createPrincess());
        arena.setSpawnBarrelPosition(getSpawnBarrelPosition());
        arena.setScores(arena.getScores());
        arena.setSpawnFirePosition(getSpawnFirePosition1(),1);
        arena.setSpawnFirePosition(getSpawnFirePosition2(),2);
        arena.setSwitches(createSwitches());
        arena.setLevel(getLevel());
        return arena;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract List<Stair> createStairs();
    protected abstract List<List<Floor>> createFloor();
    protected abstract Mario createMario();
    protected abstract DonkeyKong createDonkeyKong();
    protected abstract Princess createPrincess();
    protected abstract Position getSpawnBarrelPosition();

    protected abstract Position getSpawnFirePosition1();
    protected abstract Position getSpawnFirePosition2();
    protected abstract List<Switch> createSwitches();

    protected abstract int getLevel();
}
