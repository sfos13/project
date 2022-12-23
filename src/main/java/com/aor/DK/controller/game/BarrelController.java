package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.UnderStairs;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class BarrelController extends GameController {

    private long lastMovement;

    public BarrelController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {
        timeBarrel(time);
        List<Barrel> barrels = getModel().getBarrels();
        for (Barrel barrel : barrels) {
            moveBarrel(barrel);
        }
    }

    private void moveBarrel(@NotNull Barrel barrel) {
        Position barrelPosition = barrel.getPosition();
        boolean isUnderStairs = new UnderStairs(barrelPosition, getModel()).isValid();
        if (getModel().getFloorNumber(barrelPosition) == -1 || (isUnderStairs && barrel.isHeavy())) {
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

    private void timeBarrel(long time) {
        if (time - lastMovement > 3000) {
            getModel().spawnBarrel();
            lastMovement = time;
        }
    }
}

