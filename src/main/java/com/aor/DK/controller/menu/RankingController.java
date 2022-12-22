package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.states.MenuState;

import java.io.IOException;
import java.util.List;

public class RankingController extends Controller<Ranking> {
    public RankingController(Ranking model) {
        super(model);
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {
        for (GUI.ACTION action : actions) {
            switch (action) {
                case SPACE -> game.setState(new MenuState(new Menu("Start")));
                default -> {
                    return;
                }
            }
        }
    }
}