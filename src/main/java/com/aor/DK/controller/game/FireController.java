package com.aor.DK.controller.game;


import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.OnFloor;
import com.aor.DK.controller.rules.UnderStairs;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Fire;

import java.util.List;

public class FireController extends GameController {

    private long lastSpawn;
    private long lastMovement;

    public FireController(Arena arena) {
        super(arena);
        lastSpawn = 0;
        lastMovement = 0;
    }

    private void moveFireDown(Fire fire) {
        fire.setPosition(new Position(fire.getPosition().getX(), fire.getPosition().getY() + 1));
    }

    private void moveFireUp(Fire fire) {
        fire.setPosition(new Position(fire.getPosition().getX(), fire.getPosition().getY() - 1));
    }

    private void moveFireLeft(Fire fire) {
        fire.setPosition(new Position(fire.getPosition().getX() - 1, fire.getPosition().getY()));
    }

    private void moveFireRight(Fire fire) {
        fire.setPosition(new Position(fire.getPosition().getX() + 1, fire.getPosition().getY()));
    }

    private void moveFire(Fire fire) {
        if (fire.getDirection().equals("up")) {
            moveFireUp(fire);
            return;
        }
        if (fire.getDirection().equals("down")) {
            moveFireDown(fire);
            return;
        }
        if (fire.movingRight()) {
            moveFireRight(fire);
            return;
        }
        if (fire.movingLeft()) {
            moveFireLeft(fire);
        }
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) {
        // spawn fires
        if (time - lastSpawn > 10000 && getModel().getFireMonsters().size() < 10) {
            getModel().spawnFire();
            lastSpawn = time;
        }

        // move fires
        if (time - lastMovement > 1000) {
            for (Fire fire : getModel().getFireMonsters()) {
                Arena arena =getModel();
                Position positionFire = fire.getPosition();
                boolean isOnStairs = arena.checkStairs(positionFire);
                boolean isOverStairs = new UnderStairs(positionFire,arena).isValid();
                boolean isOnFloor = new OnFloor(positionFire,arena).isValid();

                // go up
                if (isOnStairs && (fire.isSmart() || fire.getDirection().equals("up")) && !fire.getDirection().equals("down")) {
                    fire.setDirection("up");
                    moveFire(fire);
                    continue;
                }

                // go down
                if (isOverStairs && (fire.isSmart() || fire.getDirection().equals("down")) && !fire.getDirection().equals("up")) {
                    fire.setDirection("down");
                    moveFire(fire);
                    continue;
                }

                // go left
                if (isOnFloor && !fire.getDirection().equals("right")) {
                    fire.setDirection("left");
                    moveFire(fire);
                    continue;
                }

                // go right
                if (isOnFloor && !fire.getDirection().equals("left")) {
                    fire.setDirection("right");
                    moveFire(fire);
                    continue;
                }

                // not on floor
                if(!isOnFloor && !isOnStairs) {
                    fire.switchDirection();
                    moveFire(fire);
                }
            }
            lastMovement = time;
        }
    }


}
