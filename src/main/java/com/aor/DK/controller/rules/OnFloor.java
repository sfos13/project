package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Floor;

import java.util.List;

public class OnFloor implements Validation {
    Position positionMario;
    List<List<Floor>> floors;

    public OnFloor (Position positionMario, Arena arena) {
        this.positionMario=positionMario;
        this.floors=arena.getFloor();
    }

    @Override
    public boolean isValid() {
        int positionX = positionMario.getX();
        int positionY = positionMario.getY();

        for(List<Floor> storey : floors) {
            for(Floor floor : storey)
                if(positionY+1 == (floor.getPosition().getY()) && positionX == floor.getPosition().getX()) {
                    return true;
                }
        }
        return false;
    }
}
