package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;

import java.util.List;

public class BarrelsCrash implements MarioValidation{
    Position positionMario;


    List<Barrel> barrels;

    public BarrelsCrash(Position positionMario, Arena arena) {
        this.positionMario=positionMario;
        this.barrels = arena.getBarrels();
    }


    @Override
    public boolean isValid() {
            for(Barrel barrel : barrels) {
                if(barrel.getPosition().equals(positionMario)) {
                    return true;
                }
            }
            return false;
        }
    }

