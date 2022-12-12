package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.arena.LoaderArenaBuilder;
import com.aor.DK.model.menu.Level;
import com.aor.DK.states.GameState;

import java.io.IOException;
import java.util.List;

public class LevelController extends Controller<Level> {
    private long lastMovement;

    public LevelController(Level level) {
        super(level);
        this.lastMovement = System.currentTimeMillis();
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {
        int level = getModel().getLevel();

        if (time - lastMovement > 1000) {
            if (level == 1) {
                game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
            }
            if (level == 2) {
                game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
            }
            if (level == 21) {
                game.setState(new GameState(new LoaderArenaBuilder(21).createArena()));
            }

        }

    }
}
