package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Stair;

import java.util.List;

public class CheckStairs implements MarioValidation {

    Position positionMario;
    List<Stair> stairs;

    public CheckStairs(Position position, Arena arena) {
        this.positionMario = position;
        this.stairs = arena.getStairs();

    }

    @Override
    public boolean isValid() {
        for (Stair stair : stairs) {
            if ((positionMario.equals(stair.getPosition()))) {
                return true;
            }
        }
        return false;
    }
}
