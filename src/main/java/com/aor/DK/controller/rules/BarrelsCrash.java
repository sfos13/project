package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.elements.Barrel;

import java.util.List;

public class BarrelsCrash implements MarioValidation{
    Position positionMario;
    private List<Barrel> barrels;

    public BarrelsCrash(Position positionMario, List<Barrel> barrels) {
        this.positionMario=positionMario;
        this.barrels = barrels;
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

