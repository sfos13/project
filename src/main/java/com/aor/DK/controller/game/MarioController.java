package com.aor.DK.controller.game;

import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Stair;

public class MarioController extends GameController {
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
        if (getModel().outOfBounds(position)) {
            getModel().getMario().setPosition(position);
            if (getModel().isBarrel(position)) getModel().end();
        }
    }

    private void jumpMario() {
        int n = 2, m = 2;
        while(n-->0) moveMarioUp();
        while(m-->0) moveMarioDown();
    }

    private boolean checkStairs() {
        for(int i = 0; i < getModel().getStairs().size(); i++) {
            Stair stair = getModel().getStairs().get(i);
            if((getModel().getMario().getPosition().getX() == stair.getPosition().getX()) && (getModel().getMario().getPosition().getY() == (stair.getPosition().getY()-1))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {
            if(checkStairs()) {
                moveMarioUp();
            }
        }
        if (action == GUI.ACTION.RIGHT) moveMarioRight();
        if (action == GUI.ACTION.DOWN) {
            if (checkStairs()) {
                moveMarioDown();
            }
        }
        if (action == GUI.ACTION.LEFT) moveMarioLeft();
        if (action == GUI.ACTION.SPACE) jumpMario();
    }
}
