package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import java.util.List;

public class JumpBarrels implements MarioValidation {
    Position positionMario;
    Arena arena;
    List<Barrel> barrels;

    public JumpBarrels(Position positionMario, Arena arena) {
        this.positionMario = positionMario;
        this.arena = arena;
        this.barrels = arena.getBarrels();
    }

    @Override
    public boolean isValid() {
        int positionMarioY = positionMario.getY();
        int positionMarioX = positionMario.getX();
        boolean BarrelsCrash = new BarrelsCrash(positionMario, arena).isValid();
        if (BarrelsCrash) {
            return false;
        }

        for (Barrel barrel : barrels) {
            int barrelY = barrel.getPosition().getY();
            int barrelX = barrel.getPosition().getX();
            if (barrelY == positionMarioY) {
                if (positionMarioX == barrelX) {
                    return true;
                }
                for(int i=0; i<=6;i++){
                    if (positionMarioX==barrelX+i || positionMarioX==barrelX-i) return true;
                }

            }
        }
        return false;
    }
}
