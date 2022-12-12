package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BarrelController extends GameController{

    private long lastMovement;
    public BarrelController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        time_barrel(time);
        List<Barrel> barrels = getModel().getBarrels();
        for (Barrel barrel : barrels) {
            move_barrel(barrel);
        }

    }

    private void move_barrel(@NotNull Barrel barrel) {
        if (getModel().getFloorNumber(barrel.getPosition()) == -1 || (getModel().checkUnderStairs(barrel.getPosition()) && barrel.isHeavy())) {
            Position down = barrel.getPosition().getDown();
            barrel.setPosition(down);
        }
        if (getModel().getFloorNumber(barrel.getPosition()) % 2 == 0) {
                barrel.setPosition(barrel.getPosition().getLeft());
        }
        if (getModel().getFloorNumber(barrel.getPosition()) % 2 == 1) {
            Position right = barrel.getPosition().getRight();
            barrel.setPosition(right);
        }
    }

    private void time_barrel(long time) {
        if(time - lastMovement > 2000) {
            getModel().spawnBarrel();
            lastMovement = time;
        }
    }
}

