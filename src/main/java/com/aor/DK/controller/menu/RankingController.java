package com.aor.DK.controller.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.model.ranking.Ranking;

import java.io.IOException;
import java.util.List;

public class RankingController extends Controller<Ranking> {
    public RankingController(Ranking model) {
        super(model);
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {

    }
}
