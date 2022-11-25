package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Floor;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Stair;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;

import java.util.Arrays;
import java.util.List;

public class MarioController extends GameController {

    private final float GRAVITY = 0.20f;

    public MarioController(Arena arena) {
        super(arena);
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
        if (!getModel().outOfBounds(position) || checkStairs(getModel().getMario().getPosition())) {
            getModel().getMario().setPosition(position);
        }
    }

    private boolean isOnFloor(Position position) {
        for(List<Floor> storey : getModel().getFloor()) {
            for(Floor floor : storey)
                if(position.getY()+1 == (floor.getPosition().getY()) && position.getX() == floor.getPosition().getX()) {
                    return true;
            }
        }
        return false;
    }


    private void jumpMario() {
        if (isOnFloor(getModel().getMario().getPosition()) && !checkStairs(getModel().getMario().getPosition())) {
            Position position = getModel().getMario().getPosition();
            position.setY(position.getY() - 2);
            getModel().getMario().setPosition(position);

        }
    }

    private boolean checkStairs(Position position) {
        for(Stair stair : getModel().getStairs()) {
            if((position.equals(stair.getPosition()))){
                return true;
            }
        }
        return false;
    }

    private boolean checkUnderStairs(Position position) {
        return checkStairs(new Position(position.getX(), position.getY()+1));
    }

    private boolean barrelCrash(Position position) {
        for(Barrel barrel : getModel().getBarrels()) {
            if(barrel.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOutOfBoundsY(Position position) {
        return position.getY() <= -1 || position.getY() > getModel().getHeight();
    }

    private boolean isOutOfBoundsX(Position position) {
        return position.getX() >= getModel().getWidth()-2 ;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        if (action == GUI.ACTION.UP) {
            if(checkStairs(getModel().getMario().getPosition())) {
                moveMarioUp();
            }
        }

        if (action == GUI.ACTION.DOWN) {
            if (checkUnderStairs(getModel().getMario().getPosition())) {
                moveMarioDown();
            }
        }
        if (action == GUI.ACTION.LEFT) {
            moveMarioLeft();
        }

        if ((action == GUI.ACTION.RIGHT) && !isOutOfBoundsX(getModel().getMario().getPosition())){
            moveMarioRight();
        }

        if (action == GUI.ACTION.SPACE) jumpMario();

        if(!isOnFloor(getModel().getMario().getPosition()) && !checkStairs(getModel().getMario().getPosition())) {
            Mario mario = getModel().getMario();
            moveMario(new Position(mario.getPosition().getX(),mario.getPosition().getY()+(int)mario.getVy()));
            mario.incrementVy(GRAVITY);
        }
        else{
            getModel().getMario().setVy(0);
        }
        if((barrelCrash(getModel().getMario().getPosition()))|| isOutOfBoundsY(getModel().getMario().getPosition()))  {
            getModel().end();
        }
        if(getModel().getFloorNumber(getModel().getMario().getPosition())==0){
            game.setState(new MenuState(new Menu(Arrays.asList("Play again", "Exit"), "\t\t  You won!")));
        }
    }


}
