package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.menu.Level;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.model.menu.RegisterScoreMenu;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.states.LevelState;
import com.aor.DK.states.MenuState;
import com.aor.DK.states.RankingState;
import com.aor.DK.viewer.ranking.PlayerNameGUI;

import java.io.IOException;
import java.util.List;

public class MenuController extends Controller<Menu> {
    long lastRegistered;

    public MenuController(Menu menu) {
        super(menu);
        lastRegistered = 0;
    }


    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException, InterruptedException {

        if (time - lastRegistered > 70) {
            for (GUI.ACTION action : actions) {

                switch (action) {
                    case UP -> getModel().previousEntry();
                    case DOWN -> getModel().nextEntry();
                    case SPACE -> game.setState(new MenuState(new Menu("Start")));
                    case SELECT -> {

                        if (getModel().isSelectedString("Exit")) {
                            game.setState(null);
                        }

                        if (getModel().isSelectedString("Start") || getModel().isSelectedString("Play Again?")) {
                            game.setState(new LevelState(new Level(1, 0)));
                        }
                        if (getModel().isSelectedString("Instructions")) {
                            game.setState(new MenuState(new Menu("Instructions")));
                        }

                        if (getModel().isSelectedString("Register Score")) {
                            var model = (RegisterScoreMenu) getModel();
                            new PlayerNameGUI(game, model.getScore());
                        }
                        if (getModel().isSelectedString("Ranking")) {
                            game.setState(new RankingState(new Ranking()));
                        }
                    }
                    default -> {
                        return;
                    }
                }
            }
            lastRegistered = time;
        }
    }
}