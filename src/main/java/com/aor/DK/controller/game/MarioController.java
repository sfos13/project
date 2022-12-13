package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.rules.*;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.arena.LoaderArenaBuilder;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.menu.Level;
import com.aor.DK.model.menu.RegisterScoreMenu;
import com.aor.DK.model.ranking.Scores;
import com.aor.DK.states.GameState;
import com.aor.DK.states.LevelState;
import com.aor.DK.states.MenuState;

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class MarioController extends GameController {
    public Arena arena;
    public Position positionMario;

    public Scores scores;

    public long lastMovement;
    public long lastTime;
    public Mario mario;

    public MarioController(Arena arena) {
        super(arena);
        this.arena = arena;
        this.positionMario = arena.getMario().getPosition();
        scores = new Scores(0, 1);
        scores.setTimeScore();
        this.lastMovement = System.currentTimeMillis();
        this.lastTime = System.currentTimeMillis();
        arena.setScores(scores);
        mario = arena.getMario();

    }

    public void moveMarioLeft() {

        moveMario(positionMario.getLeft());
        mario.movingLeft();
    }

    public void moveMarioRight() {

        moveMario(positionMario.getRight());
        mario.movingRight();

    }

    public void moveMarioUp() {

        moveMario(positionMario.getUp());
        mario.climbingStairs();


    }

    public void moveMarioDown() {
        moveMario(positionMario.getDown());
        mario.climbingStairs();
    }

    private void moveMario(Position position) {
        boolean isOutOfBonds = new OutOfBonds(positionMario, arena).isValid();
        if (!isOutOfBonds) {
            positionMario = position;
            mario.setPosition(position);
        }
    }


    private void jumpMario() {
        boolean isOnFloor = new OnFloor(positionMario, arena).isValid();
        boolean isOnSwitches = new OnSwitches(positionMario,arena).isValid();
        boolean checkStairs = new CheckStairs(positionMario, arena).isValid();
        boolean isJumpingBarrels = new JumpBarrels(positionMario, arena).isValid();

        if ((isOnFloor || isOnSwitches) && !checkStairs) {
            positionMario.setY(positionMario.getY() - 2);
            getModel().getMario().setPosition(positionMario);
            if (isJumpingBarrels) {
                scores.setJumpScore();

            }
        }

    }

    private void gravityPush() {
        boolean isOnFloor = new OnFloor(positionMario, arena).isValid();
        boolean isOnSwitches = new OnSwitches(positionMario,arena).isValid();
        boolean checkStairs = new CheckStairs(positionMario, arena).isValid();
        float GRAVITY = 0.25f;
        if (!isOnFloor && !checkStairs && !isOnSwitches) {
            Mario mario = arena.getMario();
            Position position = new Position(positionMario.getX(), positionMario.getY() + (int) mario.getVy());
            moveMario(position);
            mario.incrementVy(GRAVITY);

        } else {
            arena.getMario().setVy(0);
        }
    }

    public void step(Game game, List<GUI.ACTION> actions, long time) throws InterruptedException, IOException {
        boolean isOutOfBonds = new OutOfBonds(positionMario, arena).isValid();
        boolean isCrash = new Crash(positionMario, arena).isValid();
        boolean checkStairs = new CheckStairs(positionMario, arena).isValid();
        boolean underStairs = new UnderStairs(positionMario, arena).isValid();

        if(time-lastTime>70){
            lastTime=time;
            if (actions.contains(GUI.ACTION.UP)) {
                    if (checkStairs) {moveMarioUp();}
                }
            if (actions.contains(GUI.ACTION.DOWN)) {
                    if (underStairs) {moveMarioDown();}
                }
            if  (actions.contains(GUI.ACTION.LEFT)) {moveMarioLeft();}

            if (actions.contains(GUI.ACTION.RIGHT)) {moveMarioRight();}

            if ((actions.contains(GUI.ACTION.SPACE))){ jumpMario();}

            }

        gravityPush();
        if(arena.getLevel() == 21) sleep(2000);
        Position positionPrincess = arena.getPrincess().getPosition();
        int winFloor = arena.getFloorNumber(positionPrincess);

        if (getModel().getFloorNumber(positionMario) == winFloor || actions.contains(GUI.ACTION.WIN)) {

            int level = arena.getLevel();
            if (level == 1){
                game.setState(new LevelState(new Level(level+1)));
            }
            else if(level == 2) {
                game.setState(new GameState(new LoaderArenaBuilder(21).createArena()));
                System.out.println("passed level == 2\n");
            }
            else{
                arena.setScores(scores);
                game.setState(new MenuState(new RegisterScoreMenu("Win",scores.getTotal())));
                System.out.println("passed level == 3\n");
            }


        }

        if (isCrash || isOutOfBonds ) {
            arena.setScores(scores);
            game.setState(new MenuState(new RegisterScoreMenu("Lost",scores.getTotal())));
        }



        if (time - lastMovement > 3000) {
            scores.setTimeScore();
            lastMovement = time;
        }

    }
}

