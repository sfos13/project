package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Switch;

import java.util.List;

public class OnSwitches implements Validation {
    Position positionMario;
    List<Switch> switches;

    public OnSwitches(Position positionMario, Arena arena) {
        this.positionMario = positionMario;
        this.switches = arena.getSwitches();
    }

    @Override
    public boolean isValid() {
        int positionX = positionMario.getX();
        int positionY = positionMario.getY();


        for (Switch s : switches)
            if (positionY + 1 == (s.getPosition().getY()) && positionX == s.getPosition().getX()) {
                return true;
            }

        return false;
    }
}
