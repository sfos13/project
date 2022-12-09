package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;


public class ArenaController extends GameController {
    private final MarioController marioController;
    private final BarrelController barrelController;


    public ArenaController(Arena arena) {
        super(arena);
        this.marioController = new MarioController(arena);
        this.barrelController = new BarrelController(arena);

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time)  {

        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu("Start")));

        else {
            marioController.step(game, action, time);
            barrelController.step(game, action, time);
        }
    }
}
