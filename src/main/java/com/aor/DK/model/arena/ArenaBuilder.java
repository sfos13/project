package com.aor.DK.model.arena;

import com.aor.DK.model.Position;
import com.aor.DK.model.elements.*;
import com.aor.DK.model.ranking.Scores;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setLevelPosition(createLevel());
        arena.setMario(createMario());
        arena.setFloor(createFloor());
        arena.setStairs(createStairs());
        arena.setDonkeyKong(createDonkeyKong());
        arena.setPrincess(createPrincess());
        arena.setSpawnBarrelPosition(getSpawnBarrelPosition());
        arena.setScores(arena.getScores());


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

    protected abstract LV createLevel();



}
