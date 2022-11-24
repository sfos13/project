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
        for(int i = 4; i <7; i++){
            stairs.add(new Stair(3,i));
            stairs.add(new Stair(7,i));
        }
        for(int i=1;i<4;i++){
            stairs.add(new Stair(5,i));
        }

        return stairs;
    }

    @Override
    protected List<List<Floor>> createFloor() {
        int many_floor =3;
        List<List<Floor>> floors = new ArrayList<>();
        for(int x=0; x<many_floor;x++){
            floors.add(new ArrayList<Floor>());
            for(int i = x; i<width-x-1; i++) {
                floors.get(x).add(new Floor(i+1,height-(x*3+3)));
            }

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
