package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;

public class UnderStairs implements Validation {

    Arena arena;
    Position positionMario;
    public UnderStairs(Position positionMario, Arena arena){
        this.positionMario=positionMario;
        this.arena=arena;
    }

    @Override
    public boolean isValid() {
        int x= positionMario.getX();
        int y= positionMario.getY()+1;
        Position position = new Position(x,y);
        return  new CheckStairs(position, arena).isValid();
    }
}
