package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;

import java.util.List;

public class BarrelController extends GameController{

    private long lastMovement;
    public BarrelController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) {
        if(time - lastMovement > 2000) {
            getModel().spawnBarrel();
            lastMovement = time;
        }
        for (Barrel barrel : getModel().getBarrels()) {
            if (getModel().getFloorNumber(barrel.getPosition()) == -1 || (getModel().checkUnderStairs(barrel.getPosition()) && barrel.isHeavy()))  barrel.setPosition(barrel.getPosition().getDown());
            if (getModel().getFloorNumber(barrel.getPosition()) % 2 == 0) {
                    barrel.setPosition(barrel.getPosition().getLeft());
            }
            if (getModel().getFloorNumber(barrel.getPosition()) % 2 == 1) {
                    barrel.setPosition(barrel.getPosition().getRight());
            }
        }

    }
}

