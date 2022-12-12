package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Switch;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;

import java.io.IOException;
import java.util.List;

public class ArenaController extends GameController{
    private final MarioController marioController;
    private final BarrelController barrelController;

    private final FireController fireController;

    public ArenaController(Arena arena) {
        super(arena);
        this.marioController = new MarioController(arena);
        this.barrelController = new BarrelController(arena);
        this.fireController = new FireController(arena);
    }

    private void manageSwitches() {
        Mario mario = getModel().getMario();
        for(Switch s : getModel().getSwitches()) {
            if(!s.isOn()) continue;
            if(s.getPosition().getX() == mario.getPosition().getX() &&
                    (mario.getPosition().getY() == s.getPosition().getY() - 1
                    || mario.getPosition().getY() == s.getPosition().getY() - 2 )) {
                s.turnOff();
            }
        }
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {
        if (actions.contains(GUI.ACTION.QUIT))
            game.setState(new MenuState(new Menu("Start")));
        else {
            marioController.step(game, actions, time);
            barrelController.step(game, actions, time);
            fireController.step(game, actions, time);
            manageSwitches();

        }
    }
}
