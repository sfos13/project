package com.aor.DK.model.arena;

import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Floor;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Stair;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setMario(createMario());
        arena.setBarrels(createBarrels());
        arena.setFloor(createFloor());
        arena.setStairs(createStairs());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();
    protected abstract List<Stair> createStairs();

    protected abstract List<Floor> createFloor();

    protected abstract List<Barrel> createBarrels();

    protected abstract Mario createMario();

}
