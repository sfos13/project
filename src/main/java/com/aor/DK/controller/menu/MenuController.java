package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.menu.Level;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.LevelState;
import com.aor.DK.states.MenuState;


import java.util.List;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }


    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time)  {

        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelected_String("Exit")) game.setState(null);
                if (getModel().isSelected_Number(0)) game.setState(new LevelState(new Level(1)));
                if (getModel().isSelected_String("Instructions"))
                    game.setState(new MenuState(new Menu("Instructions")));
            }
        }
    }
}

