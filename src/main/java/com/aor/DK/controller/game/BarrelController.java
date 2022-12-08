package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.UnderStairs;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;

public class BarrelController extends GameController{

    private long lastMovement;
    Arena arena;
    public BarrelController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        this.arena=arena;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        if(time - lastMovement > 2000) {
            getModel().spawnBarrel();
            lastMovement = time;
        }
        for (Barrel barrel : getModel().getBarrels()) {
            Boolean checkUnderStairs = new UnderStairs(barrel.getPosition(),arena).isValid();
            if (getModel().getFloorNumber(barrel.getPosition()) == -1 || (checkUnderStairs && barrel.isHeavy()))  {
                barrel.setPosition(barrel.getPosition().getDown());
            }
            if (getModel().getFloorNumber(barrel.getPosition()) % 2 == 0) {
                barrel.setPosition(barrel.getPosition().getLeft());
            }
            if (getModel().getFloorNumber(barrel.getPosition()) % 2 == 1) {
                    barrel.setPosition(barrel.getPosition().getRight());
            }
        }

    }
}

