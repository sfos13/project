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

    public LoaderArenaBuilder(int width, int height) {
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
        for(int i = 4; i <8; i++){
            stairs.add(new Stair(3,i));
            stairs.add(new Stair(7,i));
        }

        return stairs;
    }

    @Override
    protected List<List<Floor>> createFloor() {
        List<List<Floor>> floors = new ArrayList<>();
        floors.add(new ArrayList<Floor>());
        for(int i = 1; i<width-1; i++) {
            floors.get(0).add(new Floor(i,height-3));
        }
        floors.add(new ArrayList<Floor>());
        for(int i = 2; i<width-2; i++) {
            floors.get(1).add(new Floor(i,4));
        }
        return floors;
    }

    @Override
    protected List<Barrel> createBarrels() {
        List<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(3,1));
        return barrels;
    }

    @Override
    protected Mario createMario() {
        return new Mario(2,height-4);
    }



}
