package com.aor.DK.model.arena;

import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Floor;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Stair;

import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder{

    private final int width;
    private final int height;

    LoaderArenaBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    protected List<Stair> createStairs() {
        List<Stair> stairs = new ArrayList<>();
        stairs.add(new Stair(width/3,2));
        stairs.add(new Stair(2*width/3,2));
        stairs.add(new Stair(width/3,height-3));
        stairs.add(new Stair(2*width/3,height-3));
        return stairs;
    }

    @Override
    protected List<Floor> createFloor() {
        List<Floor> floors = new ArrayList<>();
        for(int i = 1; i<width-1; i++) {
            floors.add(new Floor(i,1));
        }
        for(int i = 2; i<width-2; i++) {
            floors.add(new Floor(i,height-4));
        }
        return floors;
    }

    @Override
    protected List<Barrel> createBarrels() {
        List<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(1,height-3));
        return barrels;
    }

    @Override
    protected Mario createMario() {
        return new Mario(2,2);
    }



}
