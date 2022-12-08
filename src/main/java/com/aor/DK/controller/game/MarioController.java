package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.*;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;



public class MarioController extends GameController {
    public Arena arena;
    public Position positionMario;

    public MarioController(Arena arena) {
        super(arena);
        this.arena=arena;
        this.positionMario=arena.getMario().getPosition();

    }

    public void moveMarioLeft() {
        moveMario(positionMario.getLeft());
    }

    public void moveMarioRight() {
        moveMario(positionMario.getRight());
    }

    public void moveMarioUp() {
        moveMario(positionMario.getUp());
    }

    public void moveMarioDown() {
        moveMario(positionMario.getDown());
    }

    private void moveMario(Position position) {
        Boolean isOutOfBonds= new OutOfBonds(positionMario, arena).isValid();

        if (!isOutOfBonds ){
            positionMario=position;
            getModel().getMario().setPosition(position);
        }
    }


    private void jumpMario() {
        Boolean isOnFloor= new OnFloor(positionMario,arena).isValid();
        Boolean checkStairs = new CheckStairs(positionMario,arena).isValid();

        if (isOnFloor && !checkStairs) {
            positionMario.setY(positionMario.getY()-2);
            getModel().getMario().setPosition(positionMario);

        }
    }
    private void gravityPush() {
        Boolean isOnFloor= new OnFloor(positionMario,arena).isValid();
        Boolean checkStairs = new CheckStairs(positionMario,arena).isValid();

        float GRAVITY = 0.25f;
        if(!isOnFloor && !checkStairs) {
            Mario mario = arena.getMario();
            Position position = new Position(positionMario.getX(), positionMario.getY()+(int)mario.getVy());
            moveMario(position);
            mario.incrementVy(GRAVITY);

        }
        else{
            arena.getMario().setVy(0);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        Boolean isOutOfBonds= new OutOfBonds(positionMario, arena).isValid();
        Boolean isDonkeyKongCrash = new DonkeyCrash(positionMario,arena).isValid();
        Boolean isBarrelsCrash = new BarrelsCrash(positionMario, arena).isValid();
        Boolean checkStairs = new CheckStairs(positionMario,arena).isValid();
        Boolean underStairs = new UnderStairs(positionMario, arena).isValid();

        gravityPush();

        if (action == GUI.ACTION.UP) {
            if(checkStairs) {
                moveMarioUp();
            }
        }

        if (action == GUI.ACTION.DOWN) {
            if (underStairs) {
                moveMarioDown();
            }
        }
        if (action == GUI.ACTION.LEFT) {
            moveMarioLeft();
        }

        if ((action == GUI.ACTION.RIGHT) && !isOutOfBonds){
            moveMarioRight();
        }

        if (action == GUI.ACTION.SPACE) jumpMario();



        if(isBarrelsCrash||isOutOfBonds||isDonkeyKongCrash ) {
            game.setState(new MenuState(new Menu("Lost")));
        }

        Position positionPrincess= getModel().getPrincess().getPosition();
        int winFloor = getModel().getFloorNumber(positionPrincess);

        if(getModel().getFloorNumber(positionMario)==winFloor){
            game.setState(new MenuState(new Menu("Lost")));
        }
    }

}
