package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.arena.LoaderArenaBuilder;
import com.aor.DK.model.menu.Level;
import com.aor.DK.states.GameState;

import java.io.IOException;

public class LevelController extends Controller<Level> {


    public LevelController(Level level) {
        super(level);

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        int level= getModel().getLevel();

        if (GUI.ACTION.SPACE == action){
            if (level==1){
                game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
            }
            if(level==2){
                game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
            }

        }
    }
}
