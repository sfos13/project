package com.aor.DK.states;

import com.aor.DK.controller.Controller;
import com.aor.DK.controller.menu.RankingController;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.viewer.Viewer;
import com.aor.DK.viewer.RankingViewer;

public class RankingState extends State<Ranking> {

    public RankingState(Ranking model) {
        super(model);
    }

    @Override
    public Viewer<Ranking> getViewer() {
        return new RankingViewer(getModel());
    }

    @Override
    public Controller<Ranking> getController() {
        return new RankingController(getModel());
    }
}
