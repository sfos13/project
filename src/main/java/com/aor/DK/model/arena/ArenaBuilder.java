package com.aor.DK.model.arena;

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

        return arena;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract List<Stair> createStairs();
    protected abstract List<List<Floor>> createFloor();
    protected abstract Mario createMario();
    protected abstract DonkeyKong createDonkeyKong();
    protected abstract Princess createPrincess();

}
