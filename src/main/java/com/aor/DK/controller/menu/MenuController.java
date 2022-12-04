package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.arena.LoaderArenaBuilder;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelected_String("Exit")) game.setState(null);
                if (getModel().isSelected_String("Start")) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}

