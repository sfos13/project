package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.arena.Arena;
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

        if (time - lastMovement > 3000){
            run_level(game, level, 1);
            run_level(game, level, 2);
        }

    }

    private void run_level(Game game, int level, int i) throws IOException {
        if (level == i) {
            Arena arena = new LoaderArenaBuilder(i).createArena();
            game.setState(new GameState(arena));
        }
    }
}
