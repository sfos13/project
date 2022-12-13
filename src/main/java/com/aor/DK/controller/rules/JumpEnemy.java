package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Fire;

import java.util.List;

public class JumpEnemy implements Validation {
    Position positionMario;
    Arena arena;
    List<Barrel> barrels;
    List<Fire> fireMonsters;

    public JumpEnemy(Position positionMario, Arena arena) {
        this.positionMario = positionMario;
        this.arena = arena;
        this.barrels = arena.getBarrels();
        this.fireMonsters = arena.getFireMonsters();
    }

    @Override
    public boolean isValid() {
        int positionMarioY = positionMario.getY();
        int positionMarioX = positionMario.getX();
        boolean crash = new Crash(positionMario, arena).isValid();
        if (crash) {
            return false;
        }

        for (Barrel barrel : barrels) {
            int barrelY = barrel.getPosition().getY();
            int barrelX = barrel.getPosition().getX();
            if (barrelY == positionMarioY) {
                if (positionMarioX == barrelX) {
                    return true;
                }
                for (int i = 0; i <= 6; i++) {
                    if (positionMarioX == barrelX + i || positionMarioX == barrelX - i) return true;
                }

            }
        }

        for (Fire fire : fireMonsters) {
            int fireY = fire.getPosition().getY();
            int fireX = fire.getPosition().getX();
            if (fireY == positionMarioY) {
                if (positionMarioX == fireX) {
                    return true;
                }
                for (int i = 0; i <= 6; i++) {
                    if (positionMarioX == fireX + i || positionMarioX == fireX - i) return true;
                }

            }
        }

        return false;
    }
}
