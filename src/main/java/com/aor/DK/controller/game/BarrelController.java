package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Floor;

import java.io.IOException;
import java.util.List;

public class BarrelController extends GameController{

    private long lastMovement, barrelStepTime;
    public BarrelController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        this.barrelStepTime = 0;

    }

    private int getFloorNumber(Position position) {
        List<List<Floor>> storeys = getModel().getFloor();
        for(int i = 0; i < storeys.size(); i++) {
            for(Floor floor : storeys.get(i)) {
                if(position.getX() == floor.getPosition().getX() && position.getY() + 1 == floor.getPosition().getY()) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isOutOfBounds(Position position) {
        return position.getX() < 0 || position.getX() > getModel().getWidth() || position.getY() < 0 || position.getY() > getModel().getHeight();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(time - lastMovement > 5000) {
            getModel().spawnBarrel();
            lastMovement = time;
        }
        if(time - barrelStepTime > 500) {
            barrelStepTime = time;
            for (Barrel barrel : getModel().getBarrels()) {
                if (getFloorNumber(barrel.getPosition()) == -1) barrel.setPosition(barrel.getPosition().getDown());
                if (getFloorNumber(barrel.getPosition()) % 2 == 0) {
                    barrel.setPosition(barrel.getPosition().getLeft());
                }
                if (getFloorNumber(barrel.getPosition()) % 2 == 1) {
                    barrel.setPosition(barrel.getPosition().getRight());
                }

            }
        }

    }
}
