package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.BarrelsCrash;
import com.aor.DK.controller.rules.DonkeyCrash;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;

import java.util.List;

public class MarioController extends GameController {
    private Arena arena;
    private Position positionMario;
    private Position positionDonkey;
    private List<Barrel> barrels;
    public MarioController(Arena arena) {
        super(arena);
        this.arena=arena;
        this.positionMario=arena.getMario().getPosition();
        this.positionDonkey=arena.getDonkeyKong().getPosition();
        this.barrels = arena.getBarrels();
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


        if (((arena.isOnFloor(arena.getMario().getPosition()) && !arena.checkStairs(arena.getMario().getPosition())))) {
            Position position = getModel().getMario().getPosition();
            position.setY(position.getY() - 2);
            getModel().getMario().setPosition(position);

        }
    }
    private void gravityPush() {
        if(!getModel().isOnFloor(getModel().getMario().getPosition()) && !getModel().checkStairs(getModel().getMario().getPosition())) {
            Mario mario = getModel().getMario();
            moveMario(new Position(mario.getPosition().getX(),mario.getPosition().getY()+(int)mario.getVy()));
            float GRAVITY = 0.25f;
            mario.incrementVy(GRAVITY);
        }
        else{
            getModel().getMario().setVy(0);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        if (action == GUI.ACTION.UP) {
            if(getModel().checkStairs(getModel().getMario().getPosition())) {
                moveMarioUp();
            }
        }

        if (action == GUI.ACTION.DOWN) {
            if (getModel().checkUnderStairs(getModel().getMario().getPosition())) {
                moveMarioDown();
            }
        }
        if (action == GUI.ACTION.LEFT) {
          moveMarioLeft();
        }

        if ((action == GUI.ACTION.RIGHT) && !getModel().outOfBounds(getModel().getMario().getPosition())){
            moveMarioRight();
        }

        if (action == GUI.ACTION.SPACE) jumpMario();

        gravityPush();
        Boolean isDonkeyKongCrash = new DonkeyCrash(positionMario,positionDonkey).isValid();
        Boolean isBarrelsCrash = new BarrelsCrash(positionMario, barrels).isValid();

        if((isBarrelsCrash)|| getModel().outOfBounds(getModel().getMario().getPosition())||  isDonkeyKongCrash ) {
            game.setState(new MenuState(new Menu("Lost")));
        }

        int winFloor = getModel().getFloorNumber(getModel().getPrincess().getPosition());
        if(getModel().getFloorNumber(getModel().getMario().getPosition())==winFloor){
            game.setState(new MenuState(new Menu("Lost")));
        }
    }




}
