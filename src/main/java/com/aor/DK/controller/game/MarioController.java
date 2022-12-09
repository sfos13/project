package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;

import java.util.Arrays;
import java.util.List;

public class MarioController extends GameController {

    private final float GRAVITY = 0.25f;
    private long lastRegistered;

    public MarioController(Arena arena) {
        super(arena);
        lastRegistered = 0;
    }

    public void moveMarioLeft() {
        moveMario(getModel().getMario().getPosition().getLeft());
    }

    public void moveMarioRight() {
        moveMario(getModel().getMario().getPosition().getRight());
    }

    public void moveMarioUp() {
        moveMario(getModel().getMario().getPosition().getUp());
    }

    public void moveMarioDown() {
        moveMario(getModel().getMario().getPosition().getDown());
    }

    private void moveMario(Position position) {
        if (!getModel().outOfBounds(position) || getModel().checkStairs(getModel().getMario().getPosition())) {
            getModel().getMario().setPosition(position);
        }
    }


    private void jumpMario() {
        if (getModel().isOnFloor(getModel().getMario().getPosition()) && !getModel().checkStairs(getModel().getMario().getPosition())) {
            Position position = getModel().getMario().getPosition();
            position.setY(position.getY() - 2);
            getModel().getMario().setPosition(position);

        }
    }
    private void gravityPush() {
        if(!getModel().isOnFloor(getModel().getMario().getPosition()) && !getModel().checkStairs(getModel().getMario().getPosition())) {
            Mario mario = getModel().getMario();
            moveMario(new Position(mario.getPosition().getX(),mario.getPosition().getY()+(int)mario.getVy()));
            mario.incrementVy(GRAVITY);
        }
        else{
            getModel().getMario().setVy(0);
        }
    }
    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) {

        if (time-lastRegistered>70){
            if (actions.contains(GUI.ACTION.UP)) {
                if (getModel().checkStairs(getModel().getMario().getPosition())) {
                    moveMarioUp();
                    getModel().getMario().climbingStairs();
                }
            }

            if (actions.contains(GUI.ACTION.DOWN)) {
                if (getModel().checkUnderStairs(getModel().getMario().getPosition())) {
                    moveMarioDown();
                    getModel().getMario().climbingStairs();
                }
            }
            if (actions.contains(GUI.ACTION.LEFT)) {
                moveMarioLeft();
                getModel().getMario().movingLeft();
            }

            if (actions.contains(GUI.ACTION.RIGHT)) {
                moveMarioRight();
                getModel().getMario().movingRight();
            }

            if (actions.contains(GUI.ACTION.SPACE)) {
                jumpMario();
            }
            lastRegistered = time;
        }
        gravityPush();

        if((getModel().barrelCrash(getModel().getMario().getPosition()))
                || getModel().outOfBounds(getModel().getMario().getPosition())
                || getModel().crashDonkeyKong(getModel().getMario().getPosition()))  {
            game.setState(new MenuState(new Menu(Arrays.asList("Try again", "Exit"), "\t\t  You lost!")));
        }

        int winFloor = getModel().getFloorNumber(getModel().getPrincess().getPosition());
        if(getModel().getFloorNumber(getModel().getMario().getPosition())==winFloor){
            game.setState(new MenuState(new Menu(Arrays.asList("Play again", "Exit"), "\t\t  You won!")));
        }
    }




}
