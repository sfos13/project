package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.menu.Level;
import com.aor.DK.model.menu.Menu;

import java.io.IOException;

public class LevelController extends Controller<Level> {
    public LevelController(Level level) {
        super(level);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
