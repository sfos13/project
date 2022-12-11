package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.arena.LoaderArenaBuilder;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.GameState;

import java.io.IOException;
import java.util.List;

public class MenuController extends Controller<Menu> {
    long lastRegistered;
    public MenuController(Menu menu) {
        super(menu);
        lastRegistered = 0;
    }


    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {
        if (time - lastRegistered > 50) {
            for (GUI.ACTION action : actions) {
                switch (action) {
                    case UP -> getModel().previousEntry();
                    case DOWN -> getModel().nextEntry();
                    case SELECT -> {
                        if (getModel().isSelectedExit()) game.setState(null);
                        if (getModel().isSelectedStart())
                            game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
                    }
                }
            }
            lastRegistered = time;
        }
    }
}

