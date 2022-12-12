package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.*;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.menu.Level;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.model.ranking.Scores;
import com.aor.DK.states.LevelState;
import com.aor.DK.states.MenuState;
import java.util.List;

public class MarioController extends GameController {
    public Arena arena;
    public Position positionMario;

    public Scores scores;

    public long lastMovement;
    public MarioController(Arena arena) {
        super(arena);
        this.arena=arena;
        this.positionMario=arena.getMario().getPosition();
        scores= new Scores(0,1);
        scores.setTimeScore();
        this.lastMovement = System.currentTimeMillis();
        arena.setScores(scores);

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
        boolean isOutOfBonds= new OutOfBonds(positionMario, arena).isValid();
        if (!isOutOfBonds ){
            positionMario=position;
            getModel().getMario().setPosition(position);
        }
    }


    private void jumpMario() {
        boolean isOnFloor= new OnFloor(positionMario,arena).isValid();
        boolean checkStairs = new CheckStairs(positionMario,arena).isValid();
        boolean isJumpingBarrels = new JumpBarrels(positionMario,arena).isValid();

        if (isOnFloor && !checkStairs) {
            positionMario.setY(positionMario.getY()-2);
            getModel().getMario().setPosition(positionMario);
            if (isJumpingBarrels) {
                scores.setJumpScore();

            }
        }

    }
    private void gravityPush() {
        boolean isOnFloor= new OnFloor(positionMario,arena).isValid();
        boolean checkStairs = new CheckStairs(positionMario,arena).isValid();

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

    public void step(Game game, List<GUI.ACTION> actions, long time){
        boolean isOutOfBonds= new OutOfBonds(positionMario, arena).isValid();
        boolean isDonkeyKongCrash = new DonkeyCrash(positionMario,arena).isValid();
        boolean isBarrelsCrash = new BarrelsCrash(positionMario, arena).isValid();
        boolean checkStairs = new CheckStairs(positionMario,arena).isValid();
        boolean underStairs = new UnderStairs(positionMario, arena).isValid();

        gravityPush();

        for (GUI.ACTION action : actions) {
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


            Position positionPrincess= getModel().getPrincess().getPosition();
            int winFloor = getModel().getFloorNumber(positionPrincess);

            if(getModel().getFloorNumber(positionMario)==winFloor){
                game.setState(new LevelState(new Level(2)));
            }

        }
        if(isBarrelsCrash||isOutOfBonds||isDonkeyKongCrash ) {
            game.setState(new MenuState(new Menu("Lost")));
        }
        if (time - lastMovement > 3000) {
            scores.setTimeScore();
            lastMovement = time;
        }

    }


}
